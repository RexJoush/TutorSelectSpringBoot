package com.nwu.service.tutor.noInspectApply.impl;

import com.alibaba.fastjson.JSON;
import com.nwu.entities.tutor.childSubject.ResearchProject;
import com.nwu.entities.tutor.childSubject.TeachingAward;
import com.nwu.entities.tutor.NoSecondPage;
import com.nwu.mapper.TutorNoInspectMapper;
import com.nwu.service.tutor.noInspectApply.NoSecondService;
import com.nwu.util.TimeUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;

/**
 * 免审实现类
 */

@Service
public class NoSecondServiceImpl implements NoSecondService {

    // 免审mapper
    @Resource
    TutorNoInspectMapper tutorNoInspectMapper;

    @Override
    public void updateNoSecondPage(NoSecondPage noSecondPage, int applyId) {
        // 更新第二页免审信息
        // 科研项目
        if (noSecondPage.getResearchProjects() != null) {
            noSecondPage.setResearchProjectsJson(JSON.toJSONString(noSecondPage.getResearchProjects()));
        } else {
            noSecondPage.setResearchProjectsJson("[]");
        }
        // 教学奖励
        if (noSecondPage.getTeachingAwards() != null) {
            noSecondPage.setTeachingAwardsJson(JSON.toJSONString(noSecondPage.getTeachingAwards()));
        } else {
            noSecondPage.setTeachingAwardsJson("[]");
        }
        // 分别设置一级学科代码和名称
        if (noSecondPage.getDoctoralMasterSubjectCodeName() != null && !"".equals(noSecondPage.getDoctoralMasterSubjectCodeName())) {
            noSecondPage.setAppliedSubjectCode(noSecondPage.getDoctoralMasterSubjectCodeName().split(" ")[0]);
            noSecondPage.setAppliedSubjectName(noSecondPage.getDoctoralMasterSubjectCodeName().split(" ")[1]);
        }
        try {
            // 更新第二页
            tutorNoInspectMapper.updateTutorNoInspectSecondPage(noSecondPage, applyId);
            // 更新第一页申请学科类别信息
            tutorNoInspectMapper.updateApplySubjectStatusTimeByApplyId(noSecondPage.getApplySubject(), 6, TimeUtils.sdf.format(new Date()), applyId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("信息填写出错，请重新尝试" + "!" + e.getMessage());
        }
    }

    @Override
    public NoSecondPage getSecondPage(int applyId) {

        NoSecondPage secondPage = tutorNoInspectMapper.getSecondPage(applyId);

        // 处理学硕申请一级学科代码及名称
        if (secondPage.getAppliedSubjectCode() == null) {
            secondPage.setDoctoralMasterSubjectCodeName("");
        } else {
            secondPage.setDoctoralMasterSubjectCodeName(secondPage.getAppliedSubjectCode() + " " + secondPage.getAppliedSubjectName());
        }

        // 处理专业硕士的申请类别代码和名字
        if (secondPage.getProfessionalAppliedSubjectCode() == null) {
            secondPage.setProfessionalAppliedSubjectCodeName("");
        } else {
            secondPage.setProfessionalAppliedSubjectCodeName(secondPage.getProfessionalAppliedSubjectCode() + " " + secondPage.getProfessionalAppliedSubjectName());
        }

        // 处理专业硕士的申请领域代码和名字
        if (secondPage.getProfessionalFieldCode() == null) {
            secondPage.setProfessionalFieldCodeName("");
        } else {
            secondPage.setProfessionalFieldCodeName(secondPage.getProfessionalFieldCode() + " " + secondPage.getProfessionalFieldName());
        }

        // 科研项目
        if (secondPage.getResearchProjectsJson() == null) {
            secondPage.setResearchProjects(new ArrayList<>());
        } else {
            secondPage.setResearchProjects(JSON.parseArray(secondPage.getResearchProjectsJson(), ResearchProject.class));
        }
        // 教学奖励
        if (secondPage.getTeachingAwardsJson() == null) {
            secondPage.setTeachingAwards(new ArrayList<>());
        } else {
            secondPage.setTeachingAwards(JSON.parseArray(secondPage.getTeachingAwardsJson(), TeachingAward.class));
        }
        return secondPage;
    }
}
