package com.nwu.controller.tutor;

import com.alibaba.fastjson.JSONObject;
import com.nwu.entities.tutor.ApplyDetails;
import com.nwu.entities.tutor.ApplyDisplay;
import com.nwu.results.Result;
import com.nwu.results.ResultCode;
import com.nwu.service.admin.ApplyService;
import com.nwu.service.tutor.PageInit;
import com.nwu.util.AESUtil;
import com.nwu.util.IdUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Rex Joush
 * @time 2021.09.03 15:19
 */
@RestController
public class MyApplyController {

    @Resource
    private ApplyService applyService;

    /**
     * 获取当前教师的所有申请信息
     */
    @GetMapping("/tutor/getApplyList")
    public Result getApplyList(HttpServletRequest request) {

        String tutorId = IdUtils.getTutorId(request);

        String token = request.getHeader("token");
        System.out.println(token);
        System.out.println(AESUtil.decode(token));

        List<ApplyDisplay> applyList = applyService.getApplyList(tutorId);

        return new Result(ResultCode.SUCCESS, applyList);

    }

    /**
     * 将当前的申请表状态改为 0，使得教师可以进行修改
     *
     * @param applyId 申请表 id
     */
    @GetMapping("/tutor/changeStatus/{applyId}")
    public Result change10To0(@PathVariable("applyId") int applyId) {
        // 将状态码 14 改为 0，让教师修改被驳回的申请
        System.out.println(applyId);
        try {
            applyService.updateApplyStatus(applyId, 0, "");
        } catch (Exception e) {
            e.printStackTrace();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", 1201);
            jsonObject.put("message", "网络出现异常，请稍后再试");
            jsonObject.put("errorMessage", e.getMessage());
            return new Result(ResultCode.SUCCESS, jsonObject);
        }
        return new Result(ResultCode.SUCCESS);
    }

    @GetMapping("/common/tutor/getApplyDetails/{applyId}/{isInspect}")
    public Result getApplyDetails(@PathVariable("applyId") int applyId,
                                  @PathVariable("isInspect") int isInspect,
                                  HttpServletRequest request) {

        String tutorId = IdUtils.getTutorId(request);

        System.out.println(isInspect);// 1 非免审，0 免审

        ApplyDetails applyDetails = null;
        try {
            applyDetails = applyService.getApplyDetails(applyId, isInspect, tutorId);
        } catch (Exception e) {
            return new Result(ResultCode.SUCCESS, PageInit.getErrorMessage(e));
        }

        return new Result(ResultCode.SUCCESS, applyDetails);
    }

}
