package com.nwu.service.common.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nwu.entities.Apply;
import com.nwu.mapper.ApplyMapper;
import com.nwu.service.common.ApplyService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ApplyServiceImpl extends ServiceImpl<ApplyMapper, Apply> implements ApplyService {

    @Resource
    ApplyMapper applyMapper;

    @Override
    public int updateApplyStatus(Integer id, Integer status, String commit) {
        applyMapper.updateApplyStatus(id,status,commit);
        return 1;
    }

    /*public int updateApplyStatus(Integer id,String number,Integer applyId,Integer status,String commit){
        applyMapper.updateApplyStatus(id,number,applyId,status,commit);
        return 1;
    }*/
}
