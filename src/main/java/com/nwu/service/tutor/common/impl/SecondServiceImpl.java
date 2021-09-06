package com.nwu.service.tutor.common.impl;

import com.alibaba.fastjson.JSON;
import com.nwu.entities.tutor.SecondPage;
import com.nwu.entities.tutor.childSubject.ExpertTitle;
import com.nwu.entities.tutor.childSubject.GroupsOrPartTimeJob;
import com.nwu.service.TutorInspectService;
import com.nwu.service.tutor.common.MainBoardService;
import com.nwu.service.tutor.common.SecondService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * @author Rex Joush
 * @time 2021.08.29 21:56
 */
@Service
public class SecondServiceImpl implements SecondService {

    @Resource
    TutorInspectService tutorInspectService;

    @Resource
    MainBoardService mainBoardService;

    @Override
    public void updateOrSaveSecond(int applyId, String tutorId, SecondPage secondPage) {

        // 设置学术团体、任何种职务，有何社会兼职的字符串
        if (secondPage.getGroupsOrPartTimeJobs() != null) {
            secondPage.setGroupsOrPartTimeJobsJson(JSON.toJSONString(secondPage.getGroupsOrPartTimeJobs()));
        } else {
            secondPage.setGroupsOrPartTimeJobsJson("[]");
        }

        // 设置专家称号的字符串
        if (secondPage.getExpertTitles() != null) {
            secondPage.setExpertTitlesJson(JSON.toJSONString(secondPage.getExpertTitles()));
        } else {
            secondPage.setExpertTitlesJson("[]");
        }

        // 分别设置一级学科代码和名称
        secondPage.setDoctoralMasterSubjectCode(secondPage.getDoctoralMasterSubjectCodeName().split(" ")[0]);
        secondPage.setDoctoralMasterSubjectName(secondPage.getDoctoralMasterSubjectCodeName().split(" ")[1]);

        try {
            // 更新第二页信息
            tutorInspectService.updateTutorInspectSecond(applyId, secondPage);
            // 更新第一页申请学科信息
            mainBoardService.updateApplySubject(applyId, Integer.parseInt(secondPage.getApplySubject()));
        } catch (Exception e) {
            throw new RuntimeException("信息填写出错，请重新尝试");
        }

    }

    @Override
    public SecondPage getSecondPage(int applyId) {

        SecondPage secondPage = tutorInspectService.getTutorInspectSecond(applyId);

        // 处理申请专业的代码和名字
        if (secondPage.getDoctoralMasterSubjectCode() == null){
            secondPage.setDoctoralMasterSubjectCodeName("");
        } else {
            secondPage.setDoctoralMasterSubjectCodeName(secondPage.getDoctoralMasterSubjectCode() + " " + secondPage.getDoctoralMasterSubjectName());
        }

        // 专家称号处理
        if ("[]".equals(secondPage.getExpertTitlesJson()) || secondPage.getExpertTitlesJson() == null){
            secondPage.setExpertTitles(new ArrayList<>());
        } else {
            secondPage.setExpertTitles(JSON.parseArray(secondPage.getExpertTitlesJson(), ExpertTitle.class));
        }
        // 参加职务处理
        if ("[]".equals(secondPage.getGroupsOrPartTimeJobsJson()) || secondPage.getGroupsOrPartTimeJobsJson() == null){
            secondPage.setGroupsOrPartTimeJobs(new ArrayList<>());
        } else {
            secondPage.setGroupsOrPartTimeJobs(JSON.parseArray(secondPage.getGroupsOrPartTimeJobsJson(), GroupsOrPartTimeJob.class));
        }

        return secondPage;
    }
}
