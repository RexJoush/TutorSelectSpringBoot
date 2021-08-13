package com.nwu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nwu.entity.query.QueryDepartmentSecretaryInit;
import com.nwu.mapper.QueryDepartmentSecretaryMapper;
import com.nwu.results.Result;
import com.nwu.results.ResultCode;
import com.nwu.service.impl.QueryDepartmentSecretaryServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/department-secretary")
public class QueryDepartmentSecretaryController {

    @Resource
    public QueryDepartmentSecretaryServiceImpl queryDepartmentSecretaryService;

    //查询所有需要院系秘书初审的数据列表（分页）
    @GetMapping("/findAll/{departmentSecretaryId}")
    public Result secretaryInit(@PathVariable(value = "departmentSecretaryId") int departmentSecretaryId) {
        Page<QueryDepartmentSecretaryInit> page = new Page<>(1, 10);
        IPage<QueryDepartmentSecretaryInit> res = queryDepartmentSecretaryService.findAll(page,departmentSecretaryId);
        return new Result(ResultCode.SUCCESS, res);
    }

    //院系秘书初审的批量操作（通过、不通过）
}
