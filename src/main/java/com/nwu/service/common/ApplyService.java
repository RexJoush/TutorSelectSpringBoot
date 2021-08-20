package com.nwu.service.common;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nwu.entities.Apply;
import com.nwu.entities.Organization;
import org.apache.ibatis.annotations.Param;

public interface ApplyService extends IService<Apply> {
//    int updateApplyStatus(Integer id,String number,Integer applyId,Integer status,String commit);
    int updateApplyStatus(Integer id,Integer status,String commit);
}
