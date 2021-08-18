package com.nwu.controller.common;


import com.nwu.entities.ApplyType;
import com.nwu.entities.Organization;
import com.nwu.results.Result;
import com.nwu.results.ResultCode;
import com.nwu.service.impl.OrganizationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dynamic
 * @since 2021-08-10
 */
@RestController
@RequestMapping("/organization")
public class OrganizationController {
    @Autowired
    private OrganizationServiceImpl organizationService;
    @GetMapping("/getAll")
    public Result getOrganization(){
        List<Organization> list = organizationService.list();
        return new Result(ResultCode.SUCCESS,list);

    }
}

