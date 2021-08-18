package com.nwu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nwu.entities.Apply;
import org.apache.ibatis.annotations.Param;

public interface ApplyMapper extends BaseMapper<Apply> {
    int updateApplyStatus(@Param("number") String number, @Param("applyId") Integer applyId, @Param("status") Integer status);
}
