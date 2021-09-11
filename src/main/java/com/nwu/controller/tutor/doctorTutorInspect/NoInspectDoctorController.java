package com.nwu.controller.tutor.doctorTutorInspect;

import com.alibaba.fastjson.JSONObject;
import com.nwu.entities.Apply;
import com.nwu.entities.tutor.FirstPage;
import com.nwu.entities.tutor.noInspect.NoFirstPage;
import com.nwu.entities.tutor.noInspect.NoSecondPage;
import com.nwu.results.Result;

import com.nwu.results.ResultCode;
import com.nwu.service.tutor.common.FirstService;
import com.nwu.service.tutor.noInspectApply.NoFirstService;
import com.nwu.service.tutor.noInspectApply.NoSecondService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("tutor/noInspect")
public class NoInspectDoctorController {

    public static String tutorId = "20133220";

    //第一页
    @Resource
    NoFirstService noFirstService;

    //免审第二页 com.nwu.entities.tutor.noInspect.SecondPage;
    @Resource
    NoSecondService noSecondService;

    @ApiOperation("保存博士免审基本信息")
    @PostMapping("/saveFirstPage/{applyCondition}/{applyId}")
    public Result saveFirstPage(@RequestBody NoFirstPage nofirstPage, @PathVariable("applyCondition") Integer applyCondition, @PathVariable("applyId") Integer applyId, HttpServletRequest request) throws Exception {
        //判断是否数据库中有数据 applyCondition == 101表示数据库中有status == 0 applyTypeId == 2
        if (applyCondition == 101 && applyId != null) {
            //根据applyId更新老师基本信息 第一页不修改，继续第二页，直接返回
            NoSecondPage secondPage = noSecondService.getSecondPage(applyId);
            if (secondPage != null) {
                return new Result(ResultCode.SUCCESS, secondPage);
            }
            return Result.FAIL();
        } else {
            //插入老师数据tutorId applyTypeId status ******* apply tutorInspect
            Apply apply = new Apply();
            apply.setTutorId(tutorId);
            apply.setApplyTypeId(3);
            apply.setStatus(0);
            noFirstService.saveNoApplyInfo(apply);
            //插入的主键
            nofirstPage.setApplyId(String.valueOf(apply.getApplyId()));
            //插入tutorNoInspect表 保存图片
            int result = noFirstService.saveNoFirstPage(nofirstPage, request);
            if (result > 0) {
                //返回第二页信息 免审第二页
                NoSecondPage secondPage = noSecondService.getSecondPageInit();
                secondPage.setApplyId(apply.getApplyId());
                return new Result(ResultCode.SUCCESS, secondPage);
            }
            return Result.FAIL();
        }
    }

    @ApiOperation("保存博士免审第二页信息")
    @PostMapping("/saveSecondPage/{applyId}")
    public Result saveSecondPage(@RequestBody NoSecondPage noSecondPage, @PathVariable("applyId") Integer applyId) {

        //第二页无论什么都要更新数据库
        if (noSecondPage != null && applyId != null) {
            try {
                noSecondService.updateNoSecondPage(noSecondPage, applyId);
            } catch (Exception e) {
                // 出现异常
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("code", 1201);
                jsonObject.put("message", "信息填写异常，请重试");
                jsonObject.put("errorMessage", e.getMessage());
                return new Result(ResultCode.SUCCESS, jsonObject);
            }

        }
        return Result.FAIL();
    }
}
