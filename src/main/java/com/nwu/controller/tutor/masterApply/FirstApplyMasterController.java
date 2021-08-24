package com.nwu.controller.tutor.masterApply;

import com.nwu.entities.Apply;
import com.nwu.entities.TutorInspect;
import com.nwu.results.Result;
import com.nwu.results.ResultCode;
import com.nwu.service.tutor.common.MainBoardService;
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
    private MainBoardService myApplyMapperService;

//    @Resource
//    private TutorInspectService myTutorInspectService;

    @PostMapping("/first/{applyId}/{applyCondition}")
    public Result firstPage(@PathVariable("applyId") int applyId,
                            @PathVariable("applyCondition") int applyCondition,
                            @RequestBody TutorInspect inspect){


        String tutorId = "202032978";
        System.out.println(applyId);
        System.out.println(applyCondition);
        System.out.println(inspect);
        inspect.setTutorId("16");

        // 申请中，修改
//        if (applyCondition == 101){
//            myTutorInspectService.updateTutorInspect(inspect);
//        }

        // 添加申请表
        Apply apply = new Apply(0, tutorId, applyId, 0, 0, 0, "");
        myApplyMapperService.saveApplyInfo(apply);

        System.out.println(apply.getApplyId());

        return new Result(ResultCode.SUCCESS, apply.getApplyId());

    }

}
