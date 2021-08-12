package com.nwu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nwu.entity.query.QueryDepartmentSecretaryInit;

import java.util.List;

public interface QueryDepartmentSecretaryService extends IService<QueryDepartmentSecretaryInit>{
//    List<QueryDepartmentSecretaryInit> findAll(int departmentSecretaryId);
    IPage<QueryDepartmentSecretaryInit> findAll(Page page, int departmentSecretaryId);
}
