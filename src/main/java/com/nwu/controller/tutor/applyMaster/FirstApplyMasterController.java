package com.nwu.controller.tutor.applyMaster;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nwu.entities.Apply;
import com.nwu.entities.tutor.*;
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
    private FirstService firstService;

    @Resource
    private SecondService secondService;

    @Resource
    private ThirdService thirdService;

    @Resource
    private FourthService fourthService;


    /**
     * 第二页信息的提交
     *
     * @param applyTypeId   申请类型 id
     * @param applyId       第一页添加的 apply 表的 id 值
     * @param secondPage    基本信息
     * @return 结果
     */
//    @PostMapping("/second/{applyTypeId}/{applyId}/{applyCondition}")
//    public Result secondPage(@PathVariable("applyTypeId") int applyTypeId,
//                             @PathVariable("applyId") int applyId,
//                             @PathVariable("applyCondition") int applyCondition,
//                             @RequestBody SecondPage secondPage) {
//
//        System.out.println(applyTypeId);    // 申请类型
//        System.out.println(applyId);         // 第一页添加的 id
//
//        // 保存或更新第二页信息
//        try {
//            secondService.updateOrSaveSecond(applyId, tutorId, secondPage);
//        } catch (Exception e) {
//            // 出现异常
//            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("code", 1201);
//            jsonObject.put("message", "信息填写异常，请重试");
//            jsonObject.put("errorMessage", e.getMessage());
//            return new Result(ResultCode.SUCCESS, jsonObject);
//        }
//
//        // 没有申请过此岗位，直接返回空对象，填写新值
//        if (applyCondition == 102) {
//            return new Result(ResultCode.SUCCESS, PageInit.getThirdPage());
//        }
//
//        // 获取第三页信息并返回
//        ThirdPage thirdPage = thirdService.getThirdPage(applyId, tutorId);
//
//        return new Result(ResultCode.SUCCESS, thirdPage);
//    }

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
