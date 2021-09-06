package com.nwu.controller.tutor.common;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nwu.entities.Apply;
import com.nwu.results.Result;
import com.nwu.results.ResultCode;
import com.nwu.service.admin.ApplyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Rex Joush
 * @time 2021.09.03 15:19
 */
@RequestMapping("/tutor")
@RestController
public class ApplyController {

    public final String tutorId = "20133220";

    @Resource
    private ApplyService applyService;

    @GetMapping("/getApplyList")
    public Result getApplyList(){

        QueryWrapper<Apply> wrapper = new QueryWrapper<>();
        wrapper.eq("tutor_id", tutorId);

        List<Apply> applyList = applyService.list(wrapper);

        return new Result(ResultCode.SUCCESS, applyList);

    }

}
