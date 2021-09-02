package com.nwu.controller.tutor.doctorTutorInspect;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nwu.entities.Apply;
import com.nwu.entities.Organization;
import com.nwu.entities.Summary;
import com.nwu.entities.tutor.FirstPage;
import com.nwu.entities.tutor.FourthPage;
import com.nwu.entities.tutor.SecondPage;
import com.nwu.entities.tutor.ThirdPage;
import com.nwu.entities.tutor.childSubject.ExpertTitle;
import com.nwu.entities.tutor.childSubject.GroupsOrPartTimeJob;
import com.nwu.results.Result;

import com.nwu.results.ResultCode;
import com.nwu.service.OrganizationService;
import com.nwu.service.TutorInspectService;
import com.nwu.service.tutor.PageInit;
import com.nwu.service.tutor.common.FourthService;
import com.nwu.service.tutor.common.MainBoardService;

import com.nwu.service.tutor.common.ThirdService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.HashMap;


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
    // 申请表
    @Resource
    private MainBoardService mainBoardService;
    // 导师申请表
    @Resource
    private TutorInspectService tutorInspectService;
    //第三页
    @Resource
    private ThirdService thirdService;
    //第四页
    @Resource
    private FourthService fourthService;

    @Resource
    private OrganizationService organizationService;

    public final String tutorId = "20133220";

    /**
     *
     * @param firstPage 第一页表单
     * @param applyTypeId 申请类别id 博士首次申请 1
     * @param applyCondition 申请状态 101 102 100
     * @return firstPAGE 主键id
     */
    @ApiOperation("保存博士基本信息和申请类别表")
    @PostMapping("/saveBaseInfo/{applyTypeId}/{applyCondition}")
    public Result SaveOrUpdateApplyDoctor(@RequestBody FirstPage firstPage, @PathVariable("applyTypeId") int applyTypeId, @PathVariable("applyCondition") int applyCondition) {
        // 没有申请过和正在申请中都进来 根据applyCondition判断是插入还是修改apply
        if (applyCondition == 102) {
            // 没有申请过此岗位apply表插入
            Apply apply = new Apply();
            apply.setTutorId(tutorId);
            apply.setStatus(0);
            //申请类别
            apply.setApplyTypeId(applyTypeId);
            //返回主键
            mainBoardService.saveApplyInfo(apply);
            //得到基本信息表要添加的主键id
            firstPage.setApplyId(String.valueOf(apply.getApplyId()));
            //添加教师基本表 院系名字
            QueryWrapper<Organization> queryWrapper = new QueryWrapper();
            queryWrapper.eq("organization_name", firstPage.getOrganizationName());
            Organization one = organizationService.getOne(queryWrapper);
            // 设置院系 id
            firstPage.setOrganizationId(one.getOrganizationId());
            // 拼接授予时间及单位
            firstPage.setAwardingUnitTime(firstPage.getAwardDepartment() + " " + firstPage.getAwardTime());
            // 插入数据库
            tutorInspectService.saveTutorInspectBaseInfo(firstPage);

            return new Result(ResultCode.SUCCESS, apply.getApplyId());

        } else if (applyCondition == 101) {
            // 已经申请过此岗位，但信息未填写完成，第一页不修改，继续第二页，直接返回
            //根据填写信息查询出对应的主键id
            int id = mainBoardService.getApplyId(firstPage.getTutorId(), 1, 0);
            //返回给前端第二页的数据
            SecondPage secondPage = tutorInspectService.getTutorInspectSecond(id);
            secondPage.setGroupsOrPartTimeJobs(JSON.parseArray(secondPage.getGroupsOrPartTimeJobsJson(), GroupsOrPartTimeJob.class));
            secondPage.setExpertTitles(JSON.parseArray(secondPage.getExpertTitlesJson(), ExpertTitle.class));
            secondPage.setDoctoralMasterSubjectCodeName(secondPage.getDoctoralMasterSubjectCode() + " " + secondPage.getDoctoralMasterSubjectName());
            return new Result(ResultCode.SUCCESS, secondPage);
        }
        return Result.FAIL();
    }

    /**
     *更新第二页博士基本信息
     * @param secondPage 第二页表单
     * @param applyCondition 申请类别id 博士首次申请 1
     * @param applyId apply中id主键值
     * @return thirdPage
     */
    @ApiOperation("更新第二页博士基本信息")
    @PostMapping("updateSecondPage/{applyCondition}/{applyId}")
    public Result updateSecondPage(@RequestBody SecondPage secondPage, @PathVariable("applyCondition") Integer applyCondition, @PathVariable("applyId") Integer applyId) {
        //根据主键更新第二页信息
        if (!"".equals(String.valueOf(applyId)) && !"".equals(secondPage.getApplySubject())) {
            if (secondPage.getExpertTitles() == null) {
                secondPage.setExpertTitlesJson("[]");
            } else {
                //设置json传送到数据库中   设置专家称号的字符串
                secondPage.setExpertTitlesJson(JSON.toJSONString(secondPage.getExpertTitles()));
            }
            if (secondPage.getGroupsOrPartTimeJobs() == null) {
                secondPage.setGroupsOrPartTimeJobsJson("[]");
            } else {
                // 设置学术团体、任何种职务，有何社会兼职的字符串
                secondPage.setGroupsOrPartTimeJobsJson(JSON.toJSONString(secondPage.getGroupsOrPartTimeJobs()));
            }
            // 分别设置一级学科代码和名称  doctoralMasterSubjectCodeName=0818 地质资源与地质工程,
            secondPage.setDoctoralMasterSubjectCode(secondPage.getDoctoralMasterSubjectCodeName().split(" ")[0]);
            //名称
            secondPage.setDoctoralMasterSubjectName(secondPage.getDoctoralMasterSubjectCodeName().split(" ")[1]);
            //更新学科信息
            mainBoardService.updateApplySubject(applyId, Integer.parseInt(secondPage.getApplySubject()));
            //更新第二页信息 applyId
            tutorInspectService.updateTutorInspectSecond(applyId, secondPage);

            ThirdPage thirdPage;
            //返回前端第三页信息
            if (applyCondition == 102){
                //没有申请过此岗位
                thirdPage = PageInit.getThirdPage();
            }
            else{
                //第三页填写过 //申请过此岗位，但是填到第一页交过之后退出了 第三页第四页数据库无字段
                thirdPage = thirdService.getThirdPage(applyId, tutorId);
                thirdPage.setSummary(new Summary(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0));
            }
            System.out.println(thirdPage);
            //返回成功信息
            return new Result(ResultCode.SUCCESS,thirdPage);
        }
        //失败
        return Result.FAIL();
    }

    /**
     *
     * @param thirdPage 第三页表单
     * @param applyId 主键
     * @param applyCondition  102没有申请过此岗位 101申请过可以修改
     * @return
     */
    @ApiOperation("更新第三页博士信息")
    @PostMapping("updateThirdPage/{applyId}/{applyCondition}")
    public Result updateThirdPage(@RequestBody ThirdPage thirdPage,@PathVariable("applyId") int applyId,@PathVariable("applyId") int applyCondition){
        try{
            //存储或更新第三页
            thirdService.updateOrSaveThirdPage(applyId,tutorId,thirdPage);
        }
        catch (Exception e){
            HashMap<String, Object> map = new HashMap<>();
            map.put("code",1201);
            map.put("message",e.getMessage().split("!")[0]);
            map.put("errorMessage", e.getMessage().split("!")[1]);
            return new Result(ResultCode.SUCCESS,map);
        }
        //首次申请
        if (applyCondition == 102){
            return new Result(ResultCode.SUCCESS);
        }
        FourthPage fourthPage = fourthService.getFourthPage(applyId, tutorId);
        return new Result(ResultCode.SUCCESS,fourthPage);
    }

}





