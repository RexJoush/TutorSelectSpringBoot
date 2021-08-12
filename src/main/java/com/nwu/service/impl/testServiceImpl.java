package com.nwu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nwu.entity.Role;
import com.nwu.mapper.testMapper;
import com.nwu.service.testService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class testServiceImpl extends ServiceImpl<testMapper,Role> implements testService  {

    @Resource
    testMapper testMapper;

    @Override
    public Role getroleById(String id) {
        return testMapper.getroleById(id);
    }


}
