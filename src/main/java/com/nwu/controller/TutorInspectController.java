package com.nwu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nwu.entities.TutorInspect;
import com.nwu.results.Result;
import com.nwu.results.ResultCode;
import com.nwu.service.impl.TutorInspectServiceImpl;
import com.nwu.vo.TutorQuery;
import io.swagger.annotations.ApiOperation;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dynamic
 * @since 2021-08-09
 */
@RestController
@RequestMapping("tutor-inspect")
public class TutorInspectController {
    @Autowired
    private TutorInspectServiceImpl tutorInspectService;
    @ApiOperation(value = "获取所有用户")
    @GetMapping("/getAll")
    public Result getAll(TutorQuery tutorQuery) {
//    public List<TutorInspect> getAll(@RequestParam("pageNum") int pageNum,
//                                     @RequestParam("pageSize") int pageSize) {

        System.out.println("getAll");
    System.out.println("TutorQuery: " + tutorQuery.toString());
//    System.out.println("pageSize: " + pageSize);
       List<TutorInspect> list = tutorInspectService.getTutorByQuery(tutorQuery);
       System.out.println(list.size());
    return new Result(ResultCode.SUCCESS,list);
    }

}

