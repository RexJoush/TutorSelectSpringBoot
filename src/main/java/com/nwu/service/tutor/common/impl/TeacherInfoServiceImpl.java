package com.nwu.service.tutor.common.impl;

import com.nwu.entities.tutor.TeacherInfo;
import com.nwu.mapper.tutor.common.TeacherInfoMapper;
import com.nwu.service.tutor.common.TeacherInfoService;

import javax.annotation.Resource;

/**
 * @author Rex Joush
 * @time 2021.08.23 15:31
 */

public class TeacherInfoServiceImpl implements TeacherInfoService {

    @Resource
    private TeacherInfoMapper teacherInfoMapper;

    @Override
    public int addTeacherNoInspectInfo(TeacherInfo teacherInfo) {
        return teacherInfoMapper.addTeacherNoInspectInfo(teacherInfo);
    }

    @Override
    public int addTeacherInfo(TeacherInfo teacherInfo) {
        return teacherInfoMapper.addTeacherInfo(teacherInfo);
    }
}
