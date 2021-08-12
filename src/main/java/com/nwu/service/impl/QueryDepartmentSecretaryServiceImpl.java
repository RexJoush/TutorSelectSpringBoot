package com.nwu.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nwu.entity.ApplyType;
import com.nwu.entity.query.QueryDepartmentSecretaryInit;
import com.nwu.mapper.ApplyTypeMapper;
import com.nwu.mapper.QueryDepartmentSecretaryMapper;
import com.nwu.service.QueryDepartmentSecretaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class QueryDepartmentSecretaryServiceImpl extends ServiceImpl<QueryDepartmentSecretaryMapper, QueryDepartmentSecretaryInit> implements QueryDepartmentSecretaryService {
    @Resource
    QueryDepartmentSecretaryMapper queryDepartmentSecretaryMapper;

//    public List<QueryDepartmentSecretaryInit> findAll(int departmentSecretaryId){
//        return queryDepartmentSecretaryMapper.findAll(departmentSecretaryId);
//    }

    public IPage<QueryDepartmentSecretaryInit> findAll(Page page,int departmentSecretaryId) {
        return queryDepartmentSecretaryMapper.findAll(page,departmentSecretaryId);
    }

//    @Override
//    public List<QueryDepartmentSecretaryInit> findAll(int departmentSecretaryId) {
//        return null;
//    }
}
