package com.nwu.controller.tutor.masterApply;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nwu.entities.Apply;
import com.nwu.entities.Organization;
import com.nwu.entities.TutorInspect;
import com.nwu.entities.tutor.FirstPage;
import com.nwu.entities.tutor.SecondPage;
import com.nwu.results.Result;
import com.nwu.results.ResultCode;
import com.nwu.service.OrganizationService;
import com.nwu.service.TutorInspectService;
import com.nwu.service.tutor.common.MainBoardService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

    @Resource
    private MainBoardService mainBoardService;

    @Resource
    private TutorInspectService tutorInspectService;

    @Resource
    private OrganizationService organizationService;

    /**
     * 第一页信息的提交
     * @param applyId           申请类型 id
     * @param applyCondition    当前申请的状态
     * @param firstPage         基本信息
     * @return  结果
     */
    @PostMapping("/first/{applyId}/{applyCondition}")
    public Result firstPage(@PathVariable("applyId") int applyId,
                            @PathVariable("applyCondition") int applyCondition,
                            @RequestBody FirstPage firstPage){

        // 已经申请过此岗位，但信息未填写完成，第一页不修改，继续第二页，直接返回
        if (applyCondition == 101) {
            return new Result(ResultCode.SUCCESS);
        }

        // 首次申请，添加申请表
        String tutorId = firstPage.getNumber();
        System.out.println(applyId);
        System.out.println(applyCondition);
        System.out.println(firstPage);

        // 添加申请表
        Apply apply = new Apply(0, tutorId, applyId, 0, 0, 0, "");
        mainBoardService.saveApplyInfo(apply);

        // 添加信息表
        firstPage.setTutorId(String.valueOf(apply.getId()));
        System.out.println(firstPage);

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

    }

    @PostMapping("/second/{applyId}/{id}")
    public Result secondPage(@PathVariable("applyId") int applyId,
                             @PathVariable("id") int id,
                             @RequestBody SecondPage secondPage){

        System.out.println(applyId);    // 申请类型
        System.out.println(id); // 第一页添加的 id

        System.out.println(secondPage); // 第二页信息



        return new Result(ResultCode.SUCCESS);
    }

}

/*
SecondPage(
applySubject=文史,
doctoralMasterApplicationSubjectUnit=地质学系,
doctoralMasterSubjectCodeName=0818 地质资源与地质工程,
major=12345676879876543,
groupsOrPartTimeJobs=
    [
    GroupsOrPartTimeJob(
        time=2021-03,
        groups=12324354,
        job=324354),
    GroupsOrPartTimeJob(
        time=2021-02,
        groups=1234,
        job=32435),
    GroupsOrPartTimeJob(
    time=2021-02,
    groups=2134,
    job=32435)
    ],
expertTitles=
    [
    ExpertTitle(
        time=2021-02,
        title=2345),
    ExpertTitle(
        time=2021-02,
        title=213454)
    ]
)


 */
