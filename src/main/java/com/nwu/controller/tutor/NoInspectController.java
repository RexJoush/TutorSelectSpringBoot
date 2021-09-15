package com.nwu.controller.tutor;

/**
 * @author Rex Joush
 * @time 2021.09.12 17:29
 */

import com.alibaba.fastjson.JSONObject;
import com.nwu.entities.Apply;
import com.nwu.entities.tutor.FirstPage;
import com.nwu.entities.tutor.noInspect.NoFirstPage;
import com.nwu.entities.tutor.noInspect.NoSecondPage;
import com.nwu.results.Result;
import com.nwu.results.ResultCode;
import com.nwu.service.tutor.common.TeacherInfoService;
import com.nwu.service.tutor.noInspectApply.NoFirstService;
import com.nwu.service.tutor.noInspectApply.NoSecondService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 免审相关控制器
 */
@RestController
@RequestMapping("/tutor")
public class NoInspectController {

    public final String tutorId = "20133220";

    //第一页
    @Resource
    NoFirstService noFirstService;

    //免审第二页 com.nwu.entities.tutor.noInspect.SecondPage;
    @Resource
    NoSecondService noSecondService;

    @Resource
    private TeacherInfoService teacherInfoService;

    /**
     * 获取第一页导师基本信息
     * @param applyId 申请表 id
     * @return firstPage
     */
    @GetMapping("/noInspect/getFirstPage/{applyId}")
    public Result getFirstPage(@PathVariable("applyId") Integer applyId) {
        NoFirstPage noFirstPage;
        FirstPage firstPage;
        if (applyId == null) {
            return new Result(ResultCode.FAIL);
        }
        try {
            if (applyId == -1) {
                // 未申请过，查询基本信息
                firstPage = teacherInfoService.getTeacherInfo(tutorId);
                return new Result(ResultCode.SUCCESS, firstPage);
            } else {
                // 已申请过 查询 tutor_no_inspect 表的信息
                noFirstPage = noFirstService.getNoFirstPage(applyId);
                System.out.println(noFirstPage);
                return new Result(ResultCode.SUCCESS, noFirstPage);
            }
        } catch (Exception e) {
            return new Result(ResultCode.FAIL);
        }
    }

    @ApiOperation("保存免审基本信息")
    @PostMapping("/noInspect/saveFirstPage/{applyId}/{applyTypeId}/{applyCondition}")
    public Result saveFirstPage(@RequestBody NoFirstPage nofirstPage, @PathVariable("applyId") Integer applyId, @PathVariable("applyTypeId") Integer applyTypeId, @PathVariable("applyCondition") Integer applyCondition, HttpServletRequest request) throws Exception {
        //判断是否数据库中有数据 applyCondition == 101表示数据库中有status == 0 applyTypeId == 2
        if (applyCondition == 101 && applyId != null && applyTypeId != null) {
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
            apply.setApplyTypeId(applyTypeId);
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

    @ApiOperation("保存免审第二页信息")
    @PostMapping("/noInspect/saveSecondPage/{applyId}")
    public Result saveSecondPage(@RequestBody NoSecondPage noSecondPage, @PathVariable("applyId") Integer applyId) {

        //第二页无论什么都要更新数据库
        if (noSecondPage != null && applyId != null &&noSecondPage.getApplySubject() != null) {
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
