package com.nwu.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nwu.results.Result;
import com.nwu.results.ResultCode;
import com.nwu.service.impl.TutorInspectServiceImpl;
import com.nwu.service.tutor.PageInit;
import com.nwu.vo.QueryDepartmentSecretaryInit;
import com.nwu.vo.TutorQuery;
import io.swagger.annotations.ApiOperation;
import netscape.javascript.JSObject;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.event.InternalFrameListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author dynamic
 * @since 2021-08-09
 */
@RestController
@RequestMapping("/admin/tutor-inspect")
public class TutorInspectController {

    @Autowired
    private TutorInspectServiceImpl tutorInspectService;

//    @GetMapping("/getInit/{organizationId}/{applyStatuss}/{pageNumber}")
    @PostMapping("/getInit")
    public Result getInit(@RequestParam("organizationId") int organizationId,
                          @RequestParam("applyStatuss") List<String> applyStatuss,
                          @RequestParam("pageNumber") int pageNumber){

        System.out.println(organizationId);
        System.out.println(applyStatuss);

        List<QueryDepartmentSecretaryInit> inits = null;
        PageInfo<QueryDepartmentSecretaryInit> pageInfo = null;
        try {
            PageHelper.startPage(pageNumber,10);
            inits = tutorInspectService.getTutorInit(organizationId, applyStatuss);
            pageInfo = new PageInfo<>(inits);

        } catch (Exception e) {
            return new Result(ResultCode.SUCCESS, PageInit.getErrorMessage(e));
        }
        JSONObject object = new JSONObject();
        object.put("data", pageInfo.getList());
        object.put("total", pageInfo.getTotal());
        return new Result(ResultCode.SUCCESS, object);
    }


    @ApiOperation(value = "获取所有用户")
    @GetMapping("/admin/getAll")
    public  Result getAll(TutorQuery tutorQuery) {
        System.out.println("getAll");
        System.out.println("TutorQuery: " + tutorQuery.toString());
        List<String> status = new ArrayList<>();
       // int pageNum = (tutorQuery.getPageNum()-1)*tutorQuery.getPageSize();
      //  tutorQuery.setPageNum(pageNum);
        if(tutorQuery!=null&&tutorQuery.getApplyStatus()!=null) {
            String[] split = tutorQuery.getApplyStatus().split("-");
            for (String s : split) {
                status.add(s);
            }
        }

        System.out.println(tutorQuery.toString());
        tutorQuery.setApplyStatuss(status);
       PageHelper.startPage(tutorQuery.getPageNum(),tutorQuery.getPageSize());
       List<QueryDepartmentSecretaryInit> list= tutorInspectService.getTutorByQuery(tutorQuery);
       PageInfo<QueryDepartmentSecretaryInit> pageInfo = new PageInfo<>(list);


        Map<String, Object> res = new HashMap<>();
//
        if(list.size()>0) {
//            List<QueryDepartmentSecretaryInit> list = (List<QueryDepartmentSecretaryInit>) reslist.get(0);
//            int total = ((List<Integer>)reslist.get(1)).get(0);
            res.put("data", pageInfo.getList());
            res.put("total", pageInfo.getTotal());
        }else{
        }

        return new Result(ResultCode.SUCCESS,res);
    }

}

