package com.nwu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nwu.entity.ApplyType;
import com.nwu.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface testMapper extends BaseMapper<Role> {
    Role getroleById(@Param("id") String id);
}