package com.nwu.service.tutor.noInspectApply.impl;

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


    @Resource
    TutorNoInspectMapper  tutorNoInspectMapper;
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
