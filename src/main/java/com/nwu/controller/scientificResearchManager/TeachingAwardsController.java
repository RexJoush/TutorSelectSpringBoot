package com.nwu.controller.scientificResearchManager;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nwu.entities.TeachingAwards;
import com.nwu.results.Result;
import com.nwu.results.ResultCode;
import com.nwu.service.scientificResearchManager.TeachingAwardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Anna
 * @since 2021-08-26
 */
@RestController
@RequestMapping("/teaching_awards")
public class TeachingAwardsController {
    @Autowired
    TeachingAwardsService teachingAwardsService;

    @GetMapping("/get/{tutorId}")
    public Result getAll(@PathVariable("tutorId") String tutorId){
        QueryWrapper<TeachingAwards> wrapper = new QueryWrapper<>();
        wrapper.eq("tutor_id",tutorId);
        List<TeachingAwards> list = teachingAwardsService.list(wrapper);
        System.out.println(list);
        return new Result(ResultCode.SUCCESS,list);
    }

}

