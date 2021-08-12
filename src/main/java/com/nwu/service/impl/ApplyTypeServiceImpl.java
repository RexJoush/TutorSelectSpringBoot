package com.nwu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nwu.entity.ApplyType;
import com.nwu.mapper.ApplyTypeMapper;
import com.nwu.service.ApplyTypeService;
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
