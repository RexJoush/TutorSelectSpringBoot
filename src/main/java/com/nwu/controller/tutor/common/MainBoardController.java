package com.nwu.controller.tutor.common;

import com.nwu.entities.Apply;
import com.nwu.results.Result;
import com.nwu.results.ResultCode;
import com.nwu.service.tutor.DoctorTutorInspect.Impl.MyApplyMapperServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Rex Joush
 * @time 2021.08.18 20:40
 */
@RestController
@RequestMapping("/tutor")
public class MainBoardController {

    //申请表
    @Autowired
    MyApplyMapperServiceImpl myApplyMapperService;

    /*
        判断是否第一次申请
        首次博士，首次学硕，首次专硕
    */
    @ApiOperation("是否申请过此岗位")
    @GetMapping("/firstApply/{applyId}")
    public Result firstApply(@PathVariable("applyId") int applyId) {
        String tutorId = "202032978";
        if (!"".equals(tutorId)) {
            //根据tutorId和applyId
            Apply apply = myApplyMapperService.getApplyInfoByTutorIdAndApplyId(tutorId, applyId);
            if (apply != null) {
                //申请过此岗位 有数据 但不知道其状态
                if (apply.getStatus()==0){
                    //查询出来的状态为0 ，老师可以进去修改
                    return new Result(ResultCode.SUCCESS, "101");
                }
                else
                {
                    //老师已提交 申请过此岗位
                    return new Result(ResultCode.SUCCESS, "100");
                }
            } else {
                //没有申请过此岗位
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
            //根据tutorId和applyId和status查询是否申请过
            Apply apply = myApplyMapperService.getApplyByTutorIdAndApplyIdAndStatus(tutorId, applyId);
            if (apply != null) {
                // 申请过此岗位
                return new Result(ResultCode.SUCCESS, "100");
            } else {
                // 没有申请过此岗位
                return new Result(ResultCode.SUCCESS, "101");
            }
        }
        //返回失败
        return Result.FAIL();

    }

}
