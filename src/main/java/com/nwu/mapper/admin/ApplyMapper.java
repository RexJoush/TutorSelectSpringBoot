package com.nwu.mapper.admin;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nwu.entities.Apply;

public interface ApplyMapper extends BaseMapper<Apply> {

    int updateApplyStatus(Integer id,Integer status, String commit);

}
