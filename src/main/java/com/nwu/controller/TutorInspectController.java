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
@RequestMapping("/tutor-inspect")
public class TutorInspectController {

    @Autowired
    private TutorInspectServiceImpl tutorInspectService;

    @ApiOperation(value = "获取所有用户")
    @GetMapping("/admin/getAll")
    public Map<String, Object> getAll(TutorQuery tutorQuery) {
        System.out.println("getAll");
        System.out.println("TutorQuery: " + tutorQuery.toString());
        List<String> status = new ArrayList<>();
        if(tutorQuery!=null&&tutorQuery.getApplyStatus()!=null) {
            String[] split = tutorQuery.getApplyStatus().split("-");
            for (String s : split) {
                status.add(s);
            }
        }
        tutorQuery.setApplyStatuss(status);
        List<TutorInspect> list = tutorInspectService.getTutorByQuery(tutorQuery);
        System.out.println(list.size());
        Map<String, Object> res = new HashMap<>();
        res.put("data", list);
        res.put("total", list.size());
        res.put("code", 20000);
        return res;
    }

}

