package com.nwu.service.tutor.common.impl;

import com.nwu.entities.TutorInspect;
import com.nwu.mapper.common.MyTutorInspectMapper;
import com.nwu.service.tutor.common.MyTutorInspectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MyTutorInspectServiceImpl implements MyTutorInspectService {

    @Resource
    MyTutorInspectMapper myTutorInspectMapper;
    @Override
    public int updateTutorInspectById(TutorInspect tutorInspect) {
        return myTutorInspectMapper.updateTutorInspectById(tutorInspect);
    }

    @Override
    public int updateTutorInspect(TutorInspect inspect) {
        return myTutorInspectMapper.updateTutorInspect(inspect);
    }
}
