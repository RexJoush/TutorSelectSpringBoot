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
import com.nwu.util.IdUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 免审相关控制器
 */
@RestController
@RequestMapping("/tutor")
public class NoInspectController {

    // public final String tutorId = "20133220";

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
     *
     * @param applyId 申请表 id
     * @return firstPage
     */
    @GetMapping("/noInspect/getFirstPage/{applyId}")
    public Result getFirstPage(@PathVariable("applyId") Integer applyId,
                               HttpServletRequest request) {

        String tutorId = IdUtils.getTutorId(request);

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
    public Result saveFirstPage(@RequestBody NoFirstPage nofirstPage,
                                @PathVariable("applyId") int applyId,
                                @PathVariable("applyTypeId") int applyTypeId,
                                @PathVariable("applyCondition") int applyCondition,
                                HttpServletRequest request) throws Exception {

        String tutorId = IdUtils.getTutorId(request);

        // 判断是否数据库中有数据 applyCondition == 101 表示数据库中有 status == 0 applyTypeId == 2
        if (applyCondition == 101) {
            // 根据 applyId 更新老师基本信息 第一页不修改，继续第二页，直接返回
            NoSecondPage secondPage = noSecondService.getSecondPage(applyId);
            if (secondPage != null) {
                return new Result(ResultCode.SUCCESS, secondPage);
            }
        } else {
            // 插入老师数据 tutorId applyTypeId status ******* apply tutorInspect
            Apply apply = new Apply();
            apply.setTutorId(tutorId);
            apply.setName(nofirstPage.getName());
            apply.setOrganizationId(nofirstPage.getOrganizationId());
            apply.setApplyTypeId(applyTypeId);
            apply.setStatus(0);
            noFirstService.saveNoApplyInfo(apply);
            // 插入的主键
            nofirstPage.setApplyId(String.valueOf(apply.getApplyId()));
            // 插入 tutorNoInspect 表 保存图片
            int result = noFirstService.saveNoFirstPage(nofirstPage, request);
            if (result > 0) {
                // 返回第二页信息 免审第二页
                NoSecondPage secondPage = noSecondService.getSecondPageInit();
                secondPage.setApplyId(apply.getApplyId());
                return new Result(ResultCode.SUCCESS, secondPage);
            }
        }
        return Result.FAIL();
    }

    @ApiOperation("保存免审第二页信息")
    @PostMapping("/noInspect/saveSecondPage/{applyId}")
    public Result saveSecondPage(@RequestBody NoSecondPage noSecondPage,
                                 @PathVariable("applyId") int applyId) {

        // 第二页无论什么都要更新数据库
        if (noSecondPage != null && !"".equals(noSecondPage.getApplySubject())) {
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
        else
        {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", 1202);
            jsonObject.put("message", "请填写申请学科类别！");
            return new Result(ResultCode.SUCCESS, jsonObject);
        }
        return new Result(ResultCode.SUCCESS, Map.of("code",1200));
    }
}
