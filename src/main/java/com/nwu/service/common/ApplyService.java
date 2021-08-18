package com.nwu.service.common;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nwu.entities.Apply;
import com.nwu.entities.Organization;
import org.apache.ibatis.annotations.Param;

public interface ApplyService extends IService<Apply> {
    int updateApplyStatus(@Param("number") String number, @Param("applyId") Integer applyId, @Param("status") Integer status);
}
