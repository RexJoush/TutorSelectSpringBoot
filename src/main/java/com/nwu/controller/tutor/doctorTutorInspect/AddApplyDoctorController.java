package com.nwu.controller.tutor.doctorTutorInspect;

import com.alibaba.fastjson.JSONObject;
import com.nwu.entities.Apply;
import com.nwu.entities.tutor.FirstPage;
import com.nwu.entities.tutor.FourthPage;
import com.nwu.entities.tutor.SecondPage;
import com.nwu.entities.tutor.ThirdPage;
import com.nwu.results.Result;
import com.nwu.results.ResultCode;
import com.nwu.service.TutorInspectService;
import com.nwu.service.admin.ApplyService;
import com.nwu.service.tutor.PageInit;
import com.nwu.service.tutor.common.FirstService;
import com.nwu.service.tutor.common.FourthService;
import com.nwu.service.tutor.common.SecondService;
import com.nwu.service.tutor.common.ThirdService;
import com.nwu.util.TimeUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;

@ApiModel("博士增列")
@RestController
@RequestMapping("tutor/addApplyDoctor")
public class AddApplyDoctorController {

    public static String tutorId = "20133220";

    @Resource
    TutorInspectService tutorInspectService;

    //第一页
    @Resource
    FirstService firstService;
    //第二页
    @Resource
    SecondService secondService;
    //第三页
    @Resource
    ThirdService thirdService;
    //第四页
    @Resource
    FourthService fourthService;
    //申请表
    @Resource
    ApplyService applyService;

    @ApiOperation("保存博士增岗基本信息")
    @PostMapping("/saveFirstPage/{applyCondition}/{applyId}")
    public Result saveFirstPage(@RequestBody FirstPage firstPage, @PathVariable("applyCondition") Integer applyCondition, @PathVariable("applyId") Integer applyId, HttpServletRequest request) throws Exception {

        //判断是否数据库中有数据 applyCondition == 101表示数据库中有status == 0 applyTypeId == 2
        if (applyCondition == 101 && applyId != null) {
            //根据applyId更新老师基本信息 第一页不修改，继续第二页，直接返回
            SecondPage secondPage = secondService.getSecondPage(applyId);
            if (secondPage != null) {
                return new Result(ResultCode.SUCCESS, secondPage);
            }
            return Result.FAIL();
        } else {
            //插入老师数据tutorId applyTypeId status ******* apply tutorInspect
            Apply apply = new Apply();
            apply.setTutorId(tutorId);
            apply.setApplyTypeId(2);
            apply.setStatus(0);
            firstService.saveApplyInfo(apply);
            //插入的主键
            firstPage.setApplyId(String.valueOf(apply.getApplyId()));
            //插入tutorInspect表 保存图片
            int result = firstService.saveFirstPage(firstPage, request);
            if (result > 0) {
                //返回第二页信息
                SecondPage secondPage = PageInit.getSecondPage();
                secondPage.setApplyId(apply.getApplyId());
                return new Result(ResultCode.SUCCESS, secondPage);
            }
            return Result.FAIL();
        }
    }

    @ApiOperation("博士增岗更新第二页信息")
    @PostMapping("/updateSecondPage/{applyCondition}/{applyId}")
    public Result UpdateSecondPage(@RequestBody SecondPage secondPage, @PathVariable Integer applyCondition, @PathVariable Integer applyId) {
        //tutorInspect已经有主键了 102 未申请
        if (applyId != null && secondPage.getApplySubject() != null) {
            // 保存或更新第二页信息
            try {
                secondService.updateOrSaveSecond(applyId, tutorId, secondPage);
            } catch (Exception e) {
                // 出现异常
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("code", 1201);
                jsonObject.put("message", "信息填写异常，请重试");
                jsonObject.put("errorMessage", e.getMessage());
                return new Result(ResultCode.SUCCESS, jsonObject);
            }
            // 没有申请过此岗位，直接返回空对象，填写新值
            if (applyCondition == 102) {
                return new Result(ResultCode.SUCCESS, PageInit.getThirdPage());
            }
            // 获取第三页信息并返回
            ThirdPage thirdPage = thirdService.getThirdPage(applyId, tutorId);
            return new Result(ResultCode.SUCCESS, thirdPage);
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 1201);
        jsonObject.put("message", "信息填写异常，请重试");
        jsonObject.put("errorMessage", "error");
        return new Result(ResultCode.SUCCESS, jsonObject);
    }

    @ApiOperation("更新第三页博士信息")
    @PostMapping("updateThirdPage/{applyCondition}/{applyId}")
    public Result updateThirdPage(@RequestBody ThirdPage thirdPage,@PathVariable("applyCondition") Integer applyCondition,@PathVariable("applyId") Integer applyId){
        try{
            System.out.println(thirdPage);
            //存储或更新第三页
            thirdService.updateOrSaveThirdPage(applyId,tutorId,thirdPage);
        }
        catch (Exception e){
            HashMap<String, Object> map = new HashMap<>();
            map.put("code",1201);
            map.put("message",e.getMessage().split("!")[0]);
            map.put("errorMessage", e.getMessage().split("!")[1]);
            return new Result(ResultCode.SUCCESS,map);
        }
        //首次申请
        if (applyCondition == 102){
            // 没有申请过此岗位，返回空对象，填写新值
            FourthPage fourthPage = PageInit.getFourthPage();
            return new Result(ResultCode.SUCCESS,fourthPage);
        }
        //返回第四页信息
        FourthPage fourthPage = fourthService.getFourthPage(applyId, tutorId);
        return new Result(ResultCode.SUCCESS,fourthPage);
    }

    @ApiOperation("博士第四页信息提交")
    @PostMapping("/updateFourthPage/{applyId}")
    public Result updateFourthPage(@RequestBody FourthPage fourthPage,@PathVariable("applyId") Integer applyId){
        try{
            //存储或更新第四页
            fourthService.updateOrSaveFourthPage(applyId,tutorId,fourthPage);
        }
        catch (Exception e){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", 1201);
            jsonObject.put("message", "信息填写异常，请重试");
            jsonObject.put("errorMessage", e.getMessage());
            return new Result(ResultCode.SUCCESS, jsonObject);
        }
        // 修改 apply 表
        applyService.updateApplyStatusAndTime(applyId, 10, TimeUtils.sdf.format(new Date()));
        return Result.SUCCESS();
    }
}
