package com.nwu.controller.tutor;

/**
 * @author Rex Joush
 * @time 2021.09.11 20:55
 */

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
import com.nwu.service.tutor.common.*;
import com.nwu.util.TimeUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 非免审信息的相关控制器
 */
@RestController
@RequestMapping("/tutor")
public class InspectController {

    public final String tutorId = "20133220";

    @Resource
    private MainBoardService mainBoardService;

    @Resource
    private TutorInspectService tutorInspectService;

    @Resource
    private TeacherInfoService teacherInfoService;

    @Resource
    private ApplyService applyService;

    @Resource
    private FirstService firstService;

    @Resource
    private SecondService secondService;

    @Resource
    private ThirdService thirdService;

    @Resource
    private FourthService fourthService;

    /**
     * 获取第一页导师基本信息
     * @param applyId 申请表 id
     * @return firstPage
     */
    @GetMapping("/inspect/getFirstPage/{applyId}")
    public Result getFirstPage(@PathVariable("applyId") Integer applyId) {

        FirstPage firstPage;

        if (applyId == null) {
            return new Result(ResultCode.FAIL);
        }

        try {
            if (applyId == -1) {
                // 未申请过，查询基本信息
                firstPage = teacherInfoService.getTeacherInfo(tutorId);
            } else {
                // 已申请过 查询 tutor_inspect 表的信息
                firstPage = tutorInspectService.getFirstPage(String.valueOf(applyId));
            }
        } catch (Exception e) {
            return new Result(ResultCode.SUCCESS, PageInit.getErrorMessage(e));
        }

        return new Result(ResultCode.SUCCESS, firstPage);
    }

    /**
     * 第一页信息的提交
     * @param applyTypeId    申请类型 id
     * @param applyCondition 当前申请的状态
     * @param firstPage      基本信息
     * @return 结果
     */
    @PostMapping("/inspect/submitFirstPage/{applyId}/{applyTypeId}/{applyCondition}")
    public Result submitFirstPage(@PathVariable("applyId") int applyId,
                                  @PathVariable("applyTypeId") int applyTypeId,
                                  @PathVariable("applyCondition") int applyCondition,
                                  @RequestBody FirstPage firstPage,
                                  HttpServletRequest request) {

        // 已经申请过此岗位，但信息未填写完成，更新第一页信息
        if (applyCondition == 101) {
            // 更新第一页
            firstService.updateFirstPage(firstPage.getApplyId(), firstPage.getPhone(), firstPage.getEmail(), firstPage.getEvaluateTime(), firstPage.getAwardDepartment() + " " + firstPage.getAwardTime());
            // 读取第二页
            SecondPage secondPage = secondService.getSecondPage(applyId);
            return new Result(ResultCode.SUCCESS, secondPage);
        }


        /*
            未申请过，需要添加申请表
         */
        Apply apply = new Apply();

        // 设置申请的类型和教师工号
        apply.setTutorId(firstPage.getTutorId());
        apply.setApplyTypeId(applyTypeId);
        apply.setStatus(0);
        apply.setSubmitTime(TimeUtils.sdf.format(new Date()));

        // 添加申请表
        firstService.saveApplyInfo(apply);

        // 设置 id 值
        firstPage.setApplyId(String.valueOf(apply.getApplyId()));

        /*
            返回第二页的结果
        */
        SecondPage secondPage;
        try {
            // 插入基本信息表
            firstService.saveFirstPage(firstPage, request);
            // 102 表示未申请过，第二页无信息，否则取读取第二页信息
            if (applyCondition == 102) {
                secondPage = PageInit.getSecondPage();
                secondPage.setApplyId(apply.getApplyId());
            } else {
                secondPage = secondService.getSecondPage(apply.getApplyId());
            }
        } catch (Exception e) {
            return new Result(ResultCode.SUCCESS, PageInit.getErrorMessage(e));
        }
        return new Result(ResultCode.SUCCESS, secondPage);
    }

    /**
     * 第二页信息的提交
     *
     * @param applyTypeId   申请类型 id
     * @param applyId       apply 表的 id 值
     * @param secondPage    第二页的信息
     * @return 结果
     */
    @PostMapping("/inspect/submitSecondPage/{applyTypeId}/{applyId}/{applyCondition}")
    public Result submitSecondPage(@PathVariable("applyTypeId") int applyTypeId,
                             @PathVariable("applyId") int applyId,
                             @PathVariable("applyCondition") int applyCondition,
                             @RequestBody SecondPage secondPage) {

        System.out.println(applyTypeId);    // 申请类型
        System.out.println(applyId);        // 第一页添加的 id
        System.out.println(secondPage);

        // 保存或更新第二页信息
        try {
            secondService.updateOrSaveSecond(applyId, tutorId, secondPage);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(ResultCode.SUCCESS, PageInit.getErrorMessage(e));
        }

        /*
            获取第三页信息
         */
        // 没有申请过此岗位，直接返回空对象，填写新值
        if (applyCondition == 102) {
            return new Result(ResultCode.SUCCESS, PageInit.getThirdPage());
        }

        // 获取第三页信息并返回
        ThirdPage thirdPage = thirdService.getThirdPage(applyId, tutorId);

        return new Result(ResultCode.SUCCESS, thirdPage);
    }

    /**
     * 第三页信息的提交
     *
     * @param applyId   apply 表的 id 值
     * @param thirdPage 基本信息
     * @return 结果
     */
    @PostMapping("/inspect/submitThirdPage/{applyId}/{applyCondition}")
    public Result thirdPage(@PathVariable("applyId") int applyId,
                            @PathVariable("applyCondition") int applyCondition,
                            @RequestBody ThirdPage thirdPage) {

        // 存储第三页信息
        try {
            thirdService.updateOrSaveThirdPage(applyId, tutorId, thirdPage);
        } catch (Exception e) {
            return new Result(ResultCode.SUCCESS, PageInit.getErrorMessage(e));
        }

        // 没有申请过此岗位，返回空对象，填写新值
        FourthPage fourthPage = PageInit.getFourthPage();

        if (applyCondition == 102) {
            return new Result(ResultCode.SUCCESS, fourthPage);
        }

        // 获取第四页
        fourthPage = fourthService.getFourthPage(applyId, tutorId);

        // 返回第三页插入成功，且包含第四页信息
        return new Result(ResultCode.SUCCESS, fourthPage);

    }

    /**
     * 第四页信息的提交
     * @param applyId    apply 表的 id 值
     * @param fourthPage 基本信息
     * @return 结果
     */
    @PostMapping("/inspect/submitFourthPage/{applyId}")
    public Result fourthPage(@PathVariable("applyId") int applyId,
                             @RequestBody FourthPage fourthPage) {


        // 存储第四页信息
        try {
            fourthService.updateOrSaveFourthPage(applyId, tutorId, fourthPage);
        } catch (Exception e) {
            return new Result(ResultCode.SUCCESS, PageInit.getErrorMessage(e));
        }

        // 修改 apply 表，提交成功
        applyService.updateApplyStatus(applyId, 10, "");

        // 返回第四页插入成功，且包含第四页信息
        return new Result(ResultCode.SUCCESS, 1200);

    }

}
