package com.nwu.controller.scientificResearchManager;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nwu.entities.AcademicPaper;
import com.nwu.service.scientificResearchManager.AcademicPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("academic_paper")
public class ScienceController {

    @Autowired
    private AcademicPaperService academicPaperService;

    @GetMapping
    public Map<String, Object> query(@RequestParam String tutorId) {
        List<AcademicPaper> academicPaperList = academicPaperService.list(new QueryWrapper<AcademicPaper>().eq("tutor_id", tutorId));
        System.out.println(academicPaperList);
        Map<String,Object> map = new HashMap<>();
        map.put("data",academicPaperList);
        map.put("code",20000);
        map.put("total",academicPaperList.size());
        return map;
    }
}
