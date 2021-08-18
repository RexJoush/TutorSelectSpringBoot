package com.nwu.service.common.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nwu.entities.ApplyType;
import com.nwu.mapper.ApplyTypeMapper;
import com.nwu.service.common.ApplyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplyTypeServiceImpl extends ServiceImpl<ApplyTypeMapper,ApplyType> implements ApplyTypeService {

    @Autowired
    ApplyTypeMapper applyTypeMapper;

    public List<ApplyType> getAll(){
        List<ApplyType> all = applyTypeMapper.getAll();
        return all;
    }

}
