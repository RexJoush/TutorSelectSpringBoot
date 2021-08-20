package com.nwu.mapper.common;

import com.nwu.entities.TutorInspect;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MyTutorInspectMapper {
    /**
     * 根据tutor_id修改tutor_inspect
     * @param tutorInspect
     * @return
     */
    int updateTutorInspectById(@Param("tutorInspect") TutorInspect tutorInspect);

    int updateTutorInspect(@Param("tutorInspect") TutorInspect tutorInspect);

}
