package com.nwu.controller.tutor.doctorTutorInspect;

import com.nwu.entities.Apply;
import com.nwu.entities.tutor.FirstPage;
import com.nwu.entities.tutor.SecondPage;
import com.nwu.results.Result;
import com.nwu.results.ResultCode;
import com.nwu.service.tutor.PageInit;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/tutor/noInspect")
public class NoInspectDoctorController {

    public static String tutorId = "20133220";

    @ApiOperation("保存博士增岗基本信息")
    @PostMapping("/saveFirstPage/{applyCondition}/{applyId}")
    public Result saveFirstPage(@RequestBody FirstPage firstPage, @PathVariable("applyCondition") Integer applyCondition, @PathVariable("applyId") Integer applyId, HttpServletRequest request) throws Exception {

        //判断是否数据库中有数据 applyCondition == 101表示数据库中有status == 0 applyTypeId == 2
//        if (applyCondition == 101 && applyId != null) {
//            //根据applyId更新老师基本信息 第一页不修改，继续第二页，直接返回
//            SecondPage secondPage = secondService.getSecondPage(applyId);
//            if (secondPage != null) {
//                return new Result(ResultCode.SUCCESS, secondPage);
//            }
//            return Result.FAIL();
//        } else {
//            //插入老师数据tutorId applyTypeId status ******* apply tutorInspect
//            Apply apply = new Apply();
//            apply.setTutorId(tutorId);
//            apply.setApplyTypeId(2);
//            apply.setStatus(0);
//            firstService.saveApplyInfo(apply);
//            //插入的主键
//            firstPage.setApplyId(String.valueOf(apply.getApplyId()));
//            //插入tutorInspect表 保存图片
//            int result = firstService.saveFirstPage(firstPage, request);
//            if (result > 0) {
//                //返回第二页信息
//                SecondPage secondPage = PageInit.getSecondPage();
//                secondPage.setApplyId(apply.getApplyId());
//                return new Result(ResultCode.SUCCESS, secondPage);
//            }
            return Result.FAIL();
//        }
    }

}
