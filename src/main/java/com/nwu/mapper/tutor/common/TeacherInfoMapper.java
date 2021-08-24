package com.nwu.mapper.tutor.common;

import com.nwu.entities.tutor.TeacherInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Rex Joush
 * @time 2021.08.23 15:27
 */

/**
 * 登录时添加教师信息
 */
@Mapper
public interface TeacherInfoMapper {

    int addTeacherNoInspectInfo(@Param("teacherInfo") TeacherInfo teacherInfo);

    int addTeacherInfo(@Param("teacherInfo") TeacherInfo teacherInfo);

}
