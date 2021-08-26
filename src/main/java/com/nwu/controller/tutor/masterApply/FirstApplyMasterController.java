package com.nwu.controller.tutor.masterApply;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nwu.entities.Apply;
import com.nwu.entities.Organization;
import com.nwu.entities.tutor.FirstPage;
import com.nwu.entities.tutor.SecondPage;
import com.nwu.entities.tutor.childSubject.ExpertTitle;
import com.nwu.entities.tutor.childSubject.GroupsOrPartTimeJob;
import com.nwu.results.Result;
import com.nwu.results.ResultCode;
import com.nwu.service.OrganizationService;
import com.nwu.service.TutorInspectService;
import com.nwu.service.tutor.common.MainBoardService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
            int id = mainBoardService.getId(firstPage.getNumber(), 4, 0);
            SecondPage secondPage = tutorInspectService.getTutorInspectSecond(id);
            secondPage.setGroupsOrPartTimeJobs(JSON.parseArray(secondPage.getGroupsOrPartTimeJobsJson(), GroupsOrPartTimeJob.class));
            secondPage.setExpertTitles(JSON.parseArray(secondPage.getExpertTitlesJson(), ExpertTitle.class));
            secondPage.setDoctoralMasterSubjectCodeName(secondPage.getDoctoralMasterSubjectCode() + " " + secondPage.getDoctoralMasterSubjectName());
            return new Result(ResultCode.SUCCESS, secondPage);
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

        // 读取第二页信息
        SecondPage secondPage = tutorInspectService.getTutorInspectSecond(apply.getId());
        secondPage.setGroupsOrPartTimeJobs(JSON.parseArray(secondPage.getGroupsOrPartTimeJobsJson(), GroupsOrPartTimeJob.class));
        secondPage.setExpertTitles(JSON.parseArray(secondPage.getExpertTitlesJson(), ExpertTitle.class));
        secondPage.setDoctoralMasterSubjectCodeName(secondPage.getDoctoralMasterSubjectCode() + " " + secondPage.getDoctoralMasterSubjectName());

        return new Result(ResultCode.SUCCESS, secondPage);

    }

    @PostMapping("/second/{applyId}/{id}")
    public Result secondPage(@PathVariable("applyId") int applyId,
                             @PathVariable("id") int id,
                             @RequestBody SecondPage secondPage){

        System.out.println(applyId);    // 申请类型
        System.out.println(id);         // 第一页添加的 id

        System.out.println(secondPage); // 第二页信息

        // 设置学术团体、任何种职务，有何社会兼职的字符串
        secondPage.setGroupsOrPartTimeJobsJson(JSON.toJSONString(secondPage.getGroupsOrPartTimeJobs()));

        // 设置专家称号的字符串
        secondPage.setExpertTitlesJson(JSON.toJSONString(secondPage.getExpertTitles()));

        // 分别设置一级学科代码和名称
        secondPage.setDoctoralMasterSubjectCode(secondPage.getDoctoralMasterSubjectCodeName().split(" ")[0]);
        secondPage.setDoctoralMasterSubjectName(secondPage.getDoctoralMasterSubjectCodeName().split(" ")[1]);

        // 更新第二页信息
        tutorInspectService.updateTutorInspectSecond(id, secondPage);

        // 更新第一页申请学科信息
        mainBoardService.updateApplySubject(id, Integer.parseInt(secondPage.getApplySubject()));

        return new Result(ResultCode.SUCCESS);
    }

}

/*
SecondPage(
applySubject=1,
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
