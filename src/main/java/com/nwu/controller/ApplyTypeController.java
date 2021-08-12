package com.nwu.controller;

import com.nwu.entity.ApplyType;
import com.nwu.results.Result;
import com.nwu.results.ResultCode;
import com.nwu.service.impl.ApplyTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/apply-type")
public class ApplyTypeController {
    @Autowired
    ApplyTypeServiceImpl applyTypeService;

    @GetMapping("/getApplyType")
    public Result getApplyType(){
        List<ApplyType> list = applyTypeService.list();
//       List<ApplyType> list =  applyTypeService.getAll();
        System.out.println("+++++++++++"+list);
        return new Result(ResultCode.SUCCESS,list);

    }
}
