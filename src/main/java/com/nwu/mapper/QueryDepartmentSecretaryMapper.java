package com.nwu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nwu.entity.query.QueryDepartmentSecretaryInit;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface QueryDepartmentSecretaryMapper extends BaseMapper<QueryDepartmentSecretaryInit>{

//    List<QueryDepartmentSecretaryInit> findAll(int departmentSecretaryId);
      IPage<QueryDepartmentSecretaryInit> findAll(Page page,int departmentSecretaryId);
}
