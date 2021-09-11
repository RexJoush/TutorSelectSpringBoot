package com.nwu.service.tutor.noInspectApply.impl;

import com.alibaba.fastjson.JSON;
import com.nwu.entities.tutor.noInspect.NoSecondPage;
import com.nwu.mapper.TutorNoInspectMapper;
import com.nwu.service.tutor.noInspectApply.NoSecondService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * 免审实现类
 */

@Service
public class NoSecondServiceImpl implements NoSecondService {

    //免审mapper
    @Resource
    TutorNoInspectMapper  tutorNoInspectMapper;

    @Override
    public void updateNoSecondPage(NoSecondPage noSecondPage,Integer applyId) {
        //更新第二页免审信息
        //科研项目
        if (noSecondPage.getResearchProjects()!=null){
            noSecondPage.setResearchProjectsJson(JSON.toJSONString(noSecondPage.getResearchProjects()));
        }
        else
        {
            noSecondPage.setResearchProjectsJson("[]");
        }
        //教学奖励
        if (noSecondPage.getTeachingAwards()!=null){
            noSecondPage.setTeachingAwardsJson(JSON.toJSONString(noSecondPage.getTeachingAwards()));
        }
        else{
            noSecondPage.setTeachingAwardsJson("[]");
        }
        // 分别设置一级学科代码和名称
        if (noSecondPage.getDoctoralMasterSubjectCodeName() != null){
            noSecondPage.setAppliedSubjectCode(noSecondPage.getDoctoralMasterSubjectCodeName().split(" ")[0]);
            noSecondPage.setAppliedSubjectName(noSecondPage.getDoctoralMasterSubjectCodeName().split(" ")[1]);
        }
        try {
            //更新第二页
            tutorNoInspectMapper.updateTutorNoInspectSecondPage(noSecondPage);
            //更新第一页申请学科类别信息
            tutorNoInspectMapper.updateNoApplySubject(applyId,noSecondPage.getApplySubject());
        }
        catch (Exception e){
            throw new RuntimeException("信息填写出错，请重新尝试");
        }
    }

    @Override
    public NoSecondPage getSecondPage(Integer applyId) {

        NoSecondPage secondPage = new NoSecondPage();

        secondPage = tutorNoInspectMapper.getSecondPage(String.valueOf(applyId));
        //一级学科代码及名称
        secondPage.getAppliedSubjectCode();

        return secondPage;
    }

    @Override
    public NoSecondPage getSecondPageInit() {

        NoSecondPage secondPage = new NoSecondPage();
        secondPage.setResearchProjects(new ArrayList<>());
        secondPage.setTeachingAwards(new ArrayList<>());
        return secondPage;
    }
}
