package com.nwu.service.tutor.common.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nwu.entities.tutor.FourthPage;
import com.nwu.entities.tutor.childSubject.CourseTeaching;
import com.nwu.entities.tutor.childSubject.GuidingStudent;
import com.nwu.service.tutor.common.CourseTeachingService;
import com.nwu.service.tutor.common.FourthService;
import com.nwu.service.tutor.common.GuidingStudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Rex Joush
 * @time 2021.08.30 21:06
 */
@Service
public class FourthServiceImpl implements FourthService {

    @Resource
    private CourseTeachingService courseTeachingService;

    @Resource
    private GuidingStudentService guidingStudentService;

    @Override
    public FourthPage getFourthPage(int applyId, String tutorId) {

        FourthPage fourthPage = new FourthPage();

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("apply_id", applyId);
        queryWrapper.eq("tutor_id", tutorId);

        try {
            List<CourseTeaching> courseTeachings = courseTeachingService.list(queryWrapper);
            List<GuidingStudent> GuidingStudents = guidingStudentService.list(queryWrapper);

            fourthPage.setCourseTeachings(courseTeachings);
            fourthPage.setGuidingStudents(GuidingStudents);
        } catch (Exception e) {
            // 出现异常则返回空信息
            return new FourthPage();
        }

        return fourthPage;
    }

    @Override
    public void updateOrSaveFourthPage(int applyId, String tutorId, FourthPage fourthPage) {

        // 填写研究生课程信息
        try {
            for (CourseTeaching courseTeaching : fourthPage.getCourseTeachings()) {
                courseTeaching.setApplyId(applyId);
                courseTeaching.setTutorId(tutorId);
                courseTeachingService.saveOrUpdate(courseTeaching);
            }
        } catch (Exception e) {
            throw new RuntimeException("研究生课程信息填写错误，请检查" + "-" + e.getMessage());
        }

        // 填写学生信息
        try {
            for (GuidingStudent guidingStudent : fourthPage.getGuidingStudents()) {
                guidingStudent.setApplyId(applyId);
                guidingStudent.setTutorId(tutorId);
                guidingStudentService.saveOrUpdate(guidingStudent);
            }
        } catch (Exception e) {
            throw new RuntimeException("学生信息填写错误，请检查" + "-" + e.getMessage());
        }
    }
}
