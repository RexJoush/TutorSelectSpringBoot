package com.nwu.service.tutor.common;

import com.nwu.entities.tutor.TeacherInfo;
import org.apache.ibatis.annotations.Param;

/**
 * @author Rex Joush
 * @time 2021.08.23 15:29
 */

public interface TeacherInfoService {
    /**
     * 添加免审表
     * @return 添加结果
     */
    int addTeacherNoInspectInfo(@Param("teacherInfo") TeacherInfo teacherInfo);

    /**
     * 添加非免审表
     * @return 添加结果
     */
    int addTeacherInfo(@Param("teacherInfo") TeacherInfo teacherInfo);
}
