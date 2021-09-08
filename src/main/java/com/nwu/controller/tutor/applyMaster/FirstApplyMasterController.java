package com.nwu.controller.tutor.applyMaster;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nwu.entities.Apply;
import com.nwu.entities.Organization;
import com.nwu.entities.tutor.*;
import com.nwu.entities.tutor.childSubject.*;
import com.nwu.results.Result;
import com.nwu.results.ResultCode;
import com.nwu.service.OrganizationService;
import com.nwu.service.TutorInspectService;
import com.nwu.service.admin.ApplyService;
import com.nwu.service.tutor.PageInit;
import com.nwu.service.tutor.common.*;
import com.nwu.util.TimeUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;

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

    public final String tutorId = "20133220";

    @Resource
    private MainBoardService mainBoardService;

    @Resource
    private ApplyService applyService;

    @Resource
    private TutorInspectService tutorInspectService;

    @Resource
    private OrganizationService organizationService;

    @Resource
    private FirstService firstService;

    @Resource
    private SecondService secondService;

    @Resource
    private ThirdService thirdService;

    @Resource
    private FourthService fourthService;

    /**
     * 第一页信息的提交
     *
     * @param applyTypeId    申请类型 id
     * @param applyCondition 当前申请的状态
     * @param firstPage      基本信息
     * @return 结果
     */
    @PostMapping("/first/{applyTypeId}/{applyCondition}")
    public Result firstPage(@PathVariable("applyTypeId") int applyTypeId,
                            @PathVariable("applyCondition") int applyCondition,
                            @RequestBody FirstPage firstPage,
                            HttpServletRequest request) {

        // 已经申请过此岗位，但信息未填写完成，第一页不修改，继续第二页，直接返回
        if (applyCondition == 101) {
            int applyId = mainBoardService.getApplyId(firstPage.getTutorId(), applyTypeId, 0);
            SecondPage secondPage = secondService.getSecondPage(applyId);
            return new Result(ResultCode.SUCCESS, secondPage);
        }

        // 首次申请，添加申请表
        String tutorId = firstPage.getTutorId();

        Apply apply = new Apply();

        // 未申请过，需要添加申请表
        if (applyCondition == 102) {
            // 设置申请的类型和教师工号
            apply.setTutorId(tutorId);
            apply.setApplyTypeId(applyTypeId);
            apply.setStatus(0);
            apply.setSubmitTime(TimeUtils.sdf.format(new Date()));
            // 添加申请表
            firstService.saveApplyInfo(apply);
        }
        // 已申请过，读取申请表
        else {
            QueryWrapper<Apply> wrapper = new QueryWrapper<>();
            wrapper.eq("tutor_id", tutorId).eq("apply_type_id", applyTypeId);
            apply = applyService.getOne(wrapper);
        }

        // 添加信息表
        firstPage.setApplyId(String.valueOf(apply.getApplyId()));

        // 返回第二页的结果
        SecondPage secondPage = null;
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

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", 1201);
            jsonObject.put("message", "您不在此系统中，请联系系统管理员");
            jsonObject.put("errorMessage", e.getMessage());
            return new Result(ResultCode.SUCCESS, jsonObject);
        }
        return new Result(ResultCode.SUCCESS, secondPage);
    }

    /**
     * 第二页信息的提交
     *
     * @param applyTypeId   申请类型 id
     * @param applyId       第一页添加的 apply 表的 id 值
     * @param secondPage    基本信息
     * @return 结果
     */
    @PostMapping("/second/{applyTypeId}/{applyId}/{applyCondition}")
    public Result secondPage(@PathVariable("applyTypeId") int applyTypeId,
                             @PathVariable("applyId") int applyId,
                             @PathVariable("applyCondition") int applyCondition,
                             @RequestBody SecondPage secondPage) {

        System.out.println(applyTypeId);    // 申请类型
        System.out.println(applyId);         // 第一页添加的 id

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

    /**
     * 第三页信息的提交
     *
     * @param applyId   第一页添加的 apply 表的 id 值
     * @param thirdPage 基本信息
     * @return 结果
     */
    @PostMapping("/third/{applyId}/{applyCondition}")
    public Result thirdPage(@PathVariable("applyId") int applyId,
                            @PathVariable("applyCondition") int applyCondition,
                            @RequestBody ThirdPage thirdPage) {

        System.out.println(applyId); // 第一页的 apply 表 id

        // 存储第三页信息
        try {
            thirdService.updateOrSaveThirdPage(applyId, tutorId, thirdPage);
        } catch (Exception e) {
            // 出现异常
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", 1201);
            jsonObject.put("message", e.getMessage().split("!")[0]);
            jsonObject.put("errorMessage", e.getMessage().split("!")[1]);
            return new Result(ResultCode.SUCCESS, jsonObject);
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
     *
     * @param applyId    第一页添加的 apply 表的 id 值
     * @param fourthPage 基本信息
     * @return 结果
     */
    @PostMapping("/fourth/{applyId}")
    public Result fourthPage(@PathVariable("applyId") int applyId,
                             @RequestBody FourthPage fourthPage) {

        System.out.println(applyId); // 第一页的 apply 表 id
        System.out.println(fourthPage);
        // 存储第四页信息
        try {
            fourthService.updateOrSaveFourthPage(applyId, tutorId, fourthPage);
        } catch (Exception e) {
            // 出现异常
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", 1201);
            jsonObject.put("message", e.getMessage().split("!")[0]);
            jsonObject.put("errorMessage", e.getMessage().split("!")[1]);
            return new Result(ResultCode.SUCCESS, jsonObject);
        }

        // 修改 apply 表
        applyService.updateApplyStatus(applyId, 10, "");

        // 返回第四页插入成功，且包含第四页信息
        return new Result(ResultCode.SUCCESS, 1200);

    }

}
