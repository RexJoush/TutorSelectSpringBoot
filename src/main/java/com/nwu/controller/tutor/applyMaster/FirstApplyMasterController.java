package com.nwu.controller.tutor.applyMaster;

import com.nwu.entities.Apply;
import com.nwu.entities.TutorInspect;
import com.nwu.results.Result;
import com.nwu.results.ResultCode;
import com.nwu.service.tutor.DoctorTutorInspect.MyApplyMapperService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Rex Joush
 * @time 2021.08.18 20:02
 */

/**
 * 首次申请学术硕士导师
 */
@RestController
@RequestMapping("/tutor/firstApplyMaster")
public class FirstApplyMasterController {

    @Resource
    private MyApplyMapperService myApplyMapperService;

    @PostMapping("/first/{applyId}")
    public Result firstPage(@PathVariable("applyId") int applyId,
                            @RequestBody TutorInspect inspect){
        String tutorId = "202032978";
        System.out.println(applyId);
        System.out.println(inspect);

        // 添加申请表
        Apply apply = new Apply(0, tutorId, applyId, 0, 0, 0, "");
        myApplyMapperService.saveApplyInfo(apply);

        System.out.println(apply.getApplyId());

        // 添加教师信息表


        return new Result(ResultCode.SUCCESS, apply.getApplyId());

    }

}
