package com.nwu.controller.tutor.doctorTutorInspect;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nwu.entities.Apply;
import com.nwu.entities.Organization;
import com.nwu.entities.TutorInspect;
import com.nwu.entities.tutor.FirstPage;
import com.nwu.results.Result;

import com.nwu.results.ResultCode;
import com.nwu.service.OrganizationService;
import com.nwu.service.TutorInspectService;
import com.nwu.service.tutor.common.MainBoardService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zjz
 * @since 2021-08-16
 */
@RestController
@ApiModel("首次申请博士导师岗位")
@RequestMapping("/tutor/firstApplyDoctor")
public class FirstApplyDoctorController {
    // saveOrUpdate() 这个方法是更新或者插入，有主键就执行更新，如果没有主键就执行插入。
//    @Resource
//    private FirstApplyDoctorService firstApplyDoctorService;
    // 申请表
    @Resource
    private MainBoardService mainBoardService;
    // 导师申请表
    @Resource
    private TutorInspectService tutorInspectService;
    @Resource
    private OrganizationService organizationService;

    public static String tutorId="20133220";
    @ApiOperation("保存博士基本信息和申请类别表")
    @PostMapping("/saveBaseInfo/{applyId}/{applyCondition}")
    public Result SaveOrUpdateApplyDoctor(@RequestBody FirstPage firstPage, @PathVariable("applyId") Integer applyId, @PathVariable("applyCondition") Integer applyCondition) {

        // 没有申请过和正在申请中都进来 根据applyCondition判断是插入还是修改apply
        if (applyCondition == 102) {
            // 没有申请过此岗位apply表插入
            Apply apply = new Apply();
            apply.setTutorId(tutorId);
            apply.setStatus(0);
            apply.setApplyId(applyId);
            mainBoardService.saveApplyInfo(apply);
            //得到基本信息表要添加的主键id
            firstPage.setTutorId(String.valueOf(apply.getId()));
            //添加教师基本表
            QueryWrapper<Organization> queryWrapper = new QueryWrapper();
            queryWrapper.eq("organization_name", firstPage.getOrganizationName());
            Organization one = organizationService.getOne(queryWrapper);

            // 设置院系 id
            firstPage.setOrganizationId(one.getOrganizationId());
            // 拼接授予时间及单位
            firstPage.setAwardingUnitTime(firstPage.getAwardDepartment() + " " + firstPage.getAwardTime());
            // 插入数据库
            tutorInspectService.saveTutorInspectBaseInfo(firstPage);

            return new Result(ResultCode.SUCCESS, apply.getId());


        } else if (applyCondition == 101) {
            // 已经申请过此岗位，但信息未填写完成，第一页不修改，继续第二页，直接返回
            return new Result(ResultCode.SUCCESS);
            // 2.根据apply表去修改教师申请表
            // 根据tutor_id和status查出与apply对应的tutor_inspect的id
            // int id = mainBoardService.getApplyIdByTutorIdAndStatus(tutorId, 0);
            //System.out.println(tutorInspect);
//          tutorInspectService.updateTutorInspect(tutorInspect);


        }
        return Result.FAIL();


    }


}
