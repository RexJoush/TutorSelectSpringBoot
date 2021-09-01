package com.nwu.service.admin;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nwu.entities.Apply;

public interface ApplyService extends IService<Apply> {

    /**
     * 申请表的状态修改方法
     * @param id 申请表的 id 值
     * @param status 修改后的状态
     * @param commit 备注，可选
     * @return 修改的结果
     */
    int updateApplyStatus(Integer id,Integer status,String commit);
}
