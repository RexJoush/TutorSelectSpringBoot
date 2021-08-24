package com.nwu.controller.tutor.common;

import com.alibaba.fastjson.JSON;
import com.nwu.entities.Apply;
import com.nwu.entities.tutor.TeacherInfo;
import com.nwu.results.Result;
import com.nwu.results.ResultCode;
import com.nwu.service.tutor.common.impl.MainBoardServiceImpl;
import com.nwu.util.ResultClient;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author Rex Joush
 * @time 2021.08.18 20:40
 */
@RestController
@RequestMapping("/tutor")
public class MainBoardController {

    // 申请表
    @Resource
    private MainBoardServiceImpl myApplyMapperService;

    /*
        判断是否第一次申请
        首次博士，首次学硕，首次专硕
    */
    @ApiOperation("是否申请过此岗位")
    @GetMapping("/firstApply/{applyId}")
    public Result firstApply(@PathVariable("applyId") int applyId) {
        String tutorId = "202032978";
        if (!"".equals(tutorId)) {
            // 根据 tutorId 和 applyId
            Apply apply = myApplyMapperService.getApplyInfoByTutorIdAndApplyId(tutorId, applyId);
            if (apply != null) {
                // 申请过此岗位 有数据 但不知道其状态
                if (apply.getStatus() == 0) {
                    // 查询出来的状态为 0，老师可以进去修改
                    return new Result(ResultCode.SUCCESS, "101");
                } else {
                    // 老师已提交 申请过此岗位
                    return new Result(ResultCode.SUCCESS, "100");
                }
            } else {
                // 没有申请过此岗位
                return new Result(ResultCode.SUCCESS, "102");
            }
        }
        //返回失败
        return Result.FAIL();

    }

    /*
        判断增列
        增列博士，增列学硕，增列专硕，免审
    */
    @ApiOperation("是否申请申请过此类型岗位")
    @GetMapping("/addApply/{applyId}")
    public Result addApply(@PathVariable("applyId") int applyId) {

        String tutorId = "202032978";

        if (!"".equals(tutorId)) {
            // 根据 tutorId 和 applyId 和 status 查询是否申请过
            Apply apply = myApplyMapperService.getApplyByTutorIdAndApplyIdAndStatus(tutorId, applyId);
            if (apply != null) {
                // 申请过此岗位
                return new Result(ResultCode.SUCCESS, "100");
            } else {
                // 没有申请过此岗位
                return new Result(ResultCode.SUCCESS, "101");
            }
        }
        // 返回失败
        return Result.FAIL();
    }

    /*
        获取导师基本信息
     */
    @GetMapping("/getTeacherInfo")
    public Result getTeacherInfo(){

        String tutorId = "20133220"; // 吴老师
        //ResultClient client = new ResultClient();
//        TeacherInfo teacherInfo = client.getDataInfo(tutorId);
        TeacherInfo teacherInfo = new TeacherInfo();
        teacherInfo.setXM("吴昊");
        teacherInfo.setSFZJH("420111197209287319");
        teacherInfo.setXB("男");
        teacherInfo.setSJH("13519162128");
        teacherInfo.setMC("25");
        teacherInfo.setSHZ("");
        teacherInfo.setCSRQ("1972-09-28 00:00:00.0");
        teacherInfo.setZGXW("博士");
        teacherInfo.setZGH("20133220");
        teacherInfo.setZCMC("高级工程师");

        // 查不到教师信息
        if (teacherInfo == null){
            return Result.FAIL();
        }
        return new Result(ResultCode.SUCCESS, teacherInfo);
    }

}
