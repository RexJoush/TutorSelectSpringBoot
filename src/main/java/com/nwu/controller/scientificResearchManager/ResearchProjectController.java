package com.nwu.controller.scientificResearchManager;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nwu.entities.ResearchProject;
import com.nwu.results.Result;
import com.nwu.results.ResultCode;
import com.nwu.service.scientificResearchManager.ResearchProjectService;
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
 * @since 2021-08-27
 */
@RestController
@RequestMapping("/research_project")
public class ResearchProjectController {

    @Autowired
    ResearchProjectService researchProjectService;

    @GetMapping("/get/{tutorId}")
    public Result getAll(@PathVariable("tutorId") String tutorId){
        QueryWrapper<ResearchProject> wrapper = new QueryWrapper<>();
        wrapper.eq("tutor_id",tutorId);
        List<ResearchProject> list = researchProjectService.list(wrapper);
        System.out.println(list);
        return new Result(ResultCode.SUCCESS,list);
    }

}

