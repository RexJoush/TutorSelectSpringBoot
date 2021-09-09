package com.nwu.controller.tutor.applyMaster;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nwu.entities.Apply;
import com.nwu.entities.tutor.FirstPage;
import com.nwu.entities.tutor.SecondPage;
import com.nwu.results.Result;
import com.nwu.results.ResultCode;
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
 * @time 2021.09.09 19:38
 */
@RequestMapping("/tutor/firstApplyProfessional")
@RestController
public class FirstApplyProfessionalController {

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
}
