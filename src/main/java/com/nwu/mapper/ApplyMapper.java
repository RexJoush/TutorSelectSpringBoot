package com.nwu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nwu.entities.Apply;

public interface ApplyMapper extends BaseMapper<Apply> {
    int updateApplyStatus(String number,Integer applyId,Integer status);

}
