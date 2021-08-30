package com.nwu.controller.tutor.applyMaster;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nwu.entities.Apply;
import com.nwu.entities.Organization;
import com.nwu.entities.tutor.FirstPage;
import com.nwu.entities.tutor.SecondPage;
import com.nwu.entities.tutor.ThirdPage;
import com.nwu.entities.tutor.childSubject.ExpertTitle;
import com.nwu.entities.tutor.childSubject.GroupsOrPartTimeJob;
import com.nwu.results.Result;
import com.nwu.results.ResultCode;
import com.nwu.service.OrganizationService;
import com.nwu.service.TutorInspectService;
import com.nwu.service.tutor.common.MainBoardService;
import com.nwu.service.tutor.common.SecondService;
import com.nwu.service.tutor.common.ThirdService;
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

    public final String tutorId = "20133220";

    @Resource
    private MainBoardService mainBoardService;

    @Resource
    private TutorInspectService tutorInspectService;

    @Resource
    private OrganizationService organizationService;

    @Resource
    private SecondService secondService;

    @Resource
    private ThirdService thirdService;

    /**
     * 第一页信息的提交
     *
     * @param applyId        申请类型 id
     * @param applyCondition 当前申请的状态
     * @param firstPage      基本信息
     * @return 结果
     */
    @PostMapping("/first/{applyId}/{applyCondition}")
    public Result firstPage(@PathVariable("applyId") int applyId,
                            @PathVariable("applyCondition") int applyCondition,
                            @RequestBody FirstPage firstPage) {

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

        QueryWrapper<Organization> queryWrapper = new QueryWrapper<>();
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

    /**
     * 第二页信息的提交
     *
     * @param applyId       申请类型 id
     * @param id            第一页添加的 apply 表的 id 值
     * @param secondPage    基本信息
     * @return 结果
     */
    @PostMapping("/second/{applyId}/{id}")
    public Result secondPage(@PathVariable("applyId") int applyId,
                             @PathVariable("id") int id,
                             @RequestBody SecondPage secondPage) {

        System.out.println(applyId);    // 申请类型
        System.out.println(id);         // 第一页添加的 id

        // 保存或更新第二页信息
        try {
            secondService.updateOrSaveSecond(id, tutorId, secondPage);
        } catch (Exception e) {
            // 出现异常
            return new Result(ResultCode.FAIL, "1201");
        }

        // 获取第三页信息并返回
        ThirdPage thirdPage = thirdService.getThirdPage(id, tutorId);

        return new Result(ResultCode.SUCCESS, thirdPage);
    }

    /**
     * 第三页信息的提交
     *
     * @param id        第一页添加的 apply 表的 id 值
     * @param thirdPage 基本信息
     * @return 结果
     */
    @PostMapping("/third/{id}")
    public Result thirdPage(@PathVariable("id") int id,
                            @RequestBody ThirdPage thirdPage) {

        System.out.println(id); // 第一页的 apply 表 id

        // 存储第三页信息
        try {
            thirdService.updateOrSaveThirdPage(id, tutorId, thirdPage);
        } catch (Exception e) {
            // 出现异常
            e.printStackTrace();
            return new Result(ResultCode.FAIL, "1201");
        }

        // 返回第三页插入成功
        return new Result(ResultCode.SUCCESS);

    }

}
