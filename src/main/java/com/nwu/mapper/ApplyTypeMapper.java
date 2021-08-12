package com.nwu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nwu.entity.ApplyType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ApplyTypeMapper extends BaseMapper<ApplyType> {
    List<ApplyType> getAll();
 }
