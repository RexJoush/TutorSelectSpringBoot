package com.nwu.service.tutor.common.impl;

import com.nwu.entities.tutor.TeacherInfo;
import com.nwu.mapper.tutor.common.TeacherInfoMapper;
import com.nwu.service.tutor.common.TeacherInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.sql.Blob;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Rex Joush
 * @time 2021.08.23 15:31
 */

@Service
public class TeacherInfoServiceImpl implements TeacherInfoService {

    @Resource
    private TeacherInfoMapper teacherInfoMapper;

//    @Override
//    public int addTeacherNoInspectInfo(TeacherInfo teacherInfo) {
//        return teacherInfoMapper.addTeacherNoInspectInfo(teacherInfo);
//    }
//
//    @Override
//    public int addTeacherInfo(TeacherInfo teacherInfo) {
//        return teacherInfoMapper.addTeacherInfo(teacherInfo);
//    }

    @Override
    public TeacherInfo getTeacherInfo(String tutorId) {


        TeacherInfo teacherInfo = teacherInfoMapper.getTeacherInfo(tutorId);
        System.out.println(teacherInfo.getSHZ());
        //转换日期格式
        try{
            Date date = new Date(teacherInfo.getCSRQ());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            teacherInfo.setCSRQ(sdf.format(date));
        }
        catch (Exception e){
            System.out.println(e);
        }
        return teacherInfo;
    }
}
