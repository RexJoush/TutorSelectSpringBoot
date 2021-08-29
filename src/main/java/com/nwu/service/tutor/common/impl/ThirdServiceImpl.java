package com.nwu.service.tutor.common.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nwu.entities.*;
import com.nwu.entities.tutor.ThirdPage;
import com.nwu.service.scientificResearchManager.*;
import com.nwu.service.tutor.SummaryService;
import com.nwu.service.tutor.common.ThirdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
        if (thirdPage.getAcademicPapers() != null) {
            for (AcademicPaper academicPaper : thirdPage.getAcademicPapers()) {
                academicPaper.setApplyId(applyId);
                academicPaper.setTutorId(tutorId);
                academicPaperService.saveOrUpdate(academicPaper);
            }
        }

        // 设置科研项目
        if (thirdPage.getResearchProjects() != null) {
            for (ResearchProject researchProject : thirdPage.getResearchProjects()) {
                researchProject.setApplyId(applyId);
                researchProject.setTutorId(tutorId);
                researchProjectService.saveOrUpdate(researchProject);
            }
        }

        // 设置教材或学术著作
        if (thirdPage.getAcademicWorks() != null) {
            for (AcademicWorks academicWork : thirdPage.getAcademicWorks()) {
                academicWork.setApplyId(applyId);
                academicWork.setTutorId(tutorId);
                academicWorksService.saveOrUpdate(academicWork);
            }
        }

        // 设置科研教学奖励
        if (thirdPage.getTeachingAwards() != null) {
            for (TeachingAwards teachingAward : thirdPage.getTeachingAwards()) {
                teachingAward.setApplyId(applyId);
                teachingAward.setTutorId(tutorId);
                System.out.println(teachingAward);
                teachingAwardsService.saveOrUpdate(teachingAward);
            }
        }

        // 设置发明专利
        if (thirdPage.getInventionPatents() != null) {
            for (InventionPatent inventionPatent : thirdPage.getInventionPatents()) {
                inventionPatent.setApplyId(applyId);
                inventionPatent.setTutorId(tutorId);
                inventionPatentService.saveOrUpdate(inventionPatent);
            }
        }

        // 设置成果汇总
        Summary summary = thirdPage.getSummary();
        summary.setApplyId(applyId);
        summary.setTutorId(tutorId);
        summaryService.saveOrUpdate(summary);

    }

    @Override
    public ThirdPage getThirdPage(int applyId, String tutorId) {
        ThirdPage thirdPage = new ThirdPage();

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("apply_id", applyId);
        queryWrapper.eq("tutor_id", tutorId);

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

        // 获取汇总信息
        Summary summary = summaryService.getOne(queryWrapper);
        thirdPage.setSummary(summary);

        return thirdPage;
    }
}
