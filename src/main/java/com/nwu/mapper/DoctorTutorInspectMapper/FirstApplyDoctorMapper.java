package com.nwu.mapper.DoctorTutorInspectMapper;

import com.nwu.entities.TutorInspect;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FirstApplyDoctorMapper {
    //保存申请的导师数据
    int SaveBaseInfo(TutorInspect tutorInspect);
}
