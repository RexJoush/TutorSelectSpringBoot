package com.nwu.service.tutor.common.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nwu.entities.*;
import com.nwu.entities.tutor.ThirdPage;
import com.nwu.entities.tutor.childSubject.DeleteItem;
import com.nwu.service.scientificResearchManager.*;
import com.nwu.service.tutor.SummaryService;
import com.nwu.service.tutor.common.ThirdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Rex Joush
 * @time 2021.08.29 20:42
 */
@Service
public class ThirdServiceImpl implements ThirdService {

    @Resource
    private AcademicPaperService academicPaperService; // 论文服务类

    @Resource
    private ResearchProjectService researchProjectService; // 科研项目服务类

    @Resource
    private AcademicWorksService academicWorksService; // 教材或学术著作服务类

    @Resource
    private TeachingAwardsService teachingAwardsService; // 科研教学奖励服务类

    @Resource
    private InventionPatentService inventionPatentService; // 发明专利服务类

    @Resource
    private SummaryService summaryService; // 汇总服务类

    @Override
    public void updateOrSaveThirdPage(int applyId, String tutorId, ThirdPage thirdPage) {

        // 设置论文
        try {
            if (thirdPage.getAcademicPapers() != null) {
                for (AcademicPaper academicPaper : thirdPage.getAcademicPapers()) {
                    academicPaper.setApplyId(applyId);
                    academicPaper.setTutorId(tutorId);
                    academicPaperService.saveOrUpdate(academicPaper);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("论文信息填写错误，请检查" + "!" + e.getMessage());
        }

        // 设置科研项目
        try {
            if (thirdPage.getResearchProjects() != null) {
                for (ResearchProject researchProject : thirdPage.getResearchProjects()) {
                    researchProject.setApplyId(applyId);
                    researchProject.setTutorId(tutorId);
                    researchProjectService.saveOrUpdate(researchProject);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("科研项目填写错误，请检查" + "!" + e.getMessage());
        }

        // 设置教材或学术著作
        try {
            if (thirdPage.getAcademicWorks() != null) {
                for (AcademicWorks academicWork : thirdPage.getAcademicWorks()) {
                    academicWork.setApplyId(applyId);
                    academicWork.setTutorId(tutorId);
                    academicWorksService.saveOrUpdate(academicWork);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("教材或学术著作填写错误，请检查" + "!" + e.getMessage());
        }

        // 设置科研教学奖励
        try {
            if (thirdPage.getTeachingAwards() != null) {
                for (TeachingAwards teachingAward : thirdPage.getTeachingAwards()) {
                    teachingAward.setApplyId(applyId);
                    teachingAward.setTutorId(tutorId);
                    System.out.println(teachingAward);
                    teachingAwardsService.saveOrUpdate(teachingAward);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("科研教学奖励填写错误，请检查" + "!" + e.getMessage());
        }

        // 设置发明专利
        try {
            if (thirdPage.getInventionPatents() != null) {
                for (InventionPatent inventionPatent : thirdPage.getInventionPatents()) {
                    inventionPatent.setApplyId(applyId);
                    inventionPatent.setTutorId(tutorId);
                    inventionPatentService.saveOrUpdate(inventionPatent);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("发明专利填写错误，请检查" + "!" + e.getMessage());
        }

        // 设置成果汇总
        try {
            Summary summary = thirdPage.getSummary();
            summary.setApplyId(applyId);
            summary.setTutorId(tutorId);
            summaryService.saveOrUpdate(summary);
        } catch (Exception e) {
            throw new RuntimeException("成果汇总填写错误，请检查" + "!" + e.getMessage());
        }

        // 删除信息
        if (thirdPage.getDeleteItems() != null) {
            for (DeleteItem deleteItem : thirdPage.getDeleteItems()) {
            /*
                1, 论文
                2, 科研项目
                3, 教材或学术著作
                4, 科研或教学奖励
                5, 发明专利
             */
                // 删除对应的数据库信息
                if (deleteItem.getDeleteId() != -1) {
                    // 获取 id 值
                    int id = deleteItem.getDeleteId();
                    switch (deleteItem.getDeleteType()) {
                        case 1:
                            academicPaperService.removeById(id);
                            break;
                        case 2:
                            researchProjectService.removeById(id);
                            break;
                        case 3:
                            academicWorksService.removeById(id);
                            break;
                        case 4:
                            teachingAwardsService.removeById(id);
                            break;
                        case 5:
                            inventionPatentService.removeById(id);
                            break;
                        default:
                            break;
                    }
                }
                // 删除文件
                // todo 删除文件
                String path = deleteItem.getDeletePath();
            }
        }

    }

    @Override
    public ThirdPage getThirdPage(int applyId, String tutorId) {

        ThirdPage thirdPage = new ThirdPage();

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("apply_id", applyId);
        queryWrapper.eq("tutor_id", tutorId);

        try {
            // 获取学术论文
            List<AcademicPaper> academicPapers = academicPaperService.list(queryWrapper);
            thirdPage.setAcademicPapers(academicPapers);

            // 获取科研项目
            List<ResearchProject> researchProjects = researchProjectService.list(queryWrapper);
            thirdPage.setResearchProjects(researchProjects);

            // 获取教材或学术著作
            List<AcademicWorks> academicWorks = academicWorksService.list(queryWrapper);
            thirdPage.setAcademicWorks(academicWorks);

            // 获取科研教学奖励
            List<TeachingAwards> teachingAwards = teachingAwardsService.list(queryWrapper);
            thirdPage.setTeachingAwards(teachingAwards);

            // 获取发明专利
            List<InventionPatent> inventionPatents = inventionPatentService.list(queryWrapper);
            thirdPage.setInventionPatents(inventionPatents);

            // 获取汇总信息,需要用户手动点击汇总信息，所以不查询数据库
            Summary summary = summaryService.getOne(queryWrapper);
            thirdPage.setSummary(summary);

            // 添加删除空列表
            thirdPage.setDeleteItems(new ArrayList<>());

        } catch (Exception e) {
            // 出现异常则返回空信息
            return new ThirdPage();
        }
        return thirdPage;
    }
}
