package com.nwu.controller.tutor.doctorTutorInspect;

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
import com.nwu.util.UpLoadFile;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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

    public final String tutorId = "20133220";

    /**
     *
     * @param firstPage
     * @param applyId 申请类别id 博士首次申请 1
     * @param applyCondition 申请状态 101 102 100
     * @return firstPAGE 主键id
     */
    @ApiOperation("保存博士基本信息和申请类别表")
    @PostMapping("/saveBaseInfo/{applyId}/{applyCondition}")
    public Result SaveOrUpdateApplyDoctor(@RequestBody FirstPage firstPage, @PathVariable("applyId") int applyId, @PathVariable("applyCondition") int applyCondition) {
        // 没有申请过和正在申请中都进来 根据applyCondition判断是插入还是修改apply
        if (applyCondition == 102) {
            // 没有申请过此岗位apply表插入
            Apply apply = new Apply();
            apply.setTutorId(tutorId);
            apply.setStatus(0);
            apply.setApplyId(applyId);
            mainBoardService.saveApplyInfo(apply);
            //得到基本信息表要添加的主键id
            firstPage.setTutorId(String.valueOf(apply.getApplyId()));
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

            return new Result(ResultCode.SUCCESS, apply.getApplyId());

        } else if (applyCondition == 101) {
            // 已经申请过此岗位，但信息未填写完成，第一页不修改，继续第二页，直接返回
            //根据填写信息查询出对应的主键id
            int id = mainBoardService.getApplyId(firstPage.getTutorId(), 1, 0);
            //返回给前端第二页的数据
            SecondPage secondPage = tutorInspectService.getTutorInspectSecond(id);
            System.out.println(secondPage);
            secondPage.setGroupsOrPartTimeJobs(JSON.parseArray(secondPage.getGroupsOrPartTimeJobsJson(), GroupsOrPartTimeJob.class));
            secondPage.setExpertTitles(JSON.parseArray(secondPage.getExpertTitlesJson(), ExpertTitle.class));
            secondPage.setDoctoralMasterSubjectCodeName(secondPage.getDoctoralMasterSubjectCode() + " " + secondPage.getDoctoralMasterSubjectName());
            return new Result(ResultCode.SUCCESS, secondPage);
        }
        return Result.FAIL();
    }

    /**
     *
     * @param secondPage
     * @param applyId 申请类别id 博士首次申请 1
     * @param id apply中id主键值
     * @return
     */
    @ApiOperation("更新第二页博士基本信息")
    @PostMapping("updateSecondPage/{applyId}/{id}")
    public Result updateSecondPage(@RequestBody SecondPage secondPage, @PathVariable("applyId") Integer applyId, @PathVariable("id") Integer id) {
        //根据主键更新第二页信息
        if (!"".equals(id) && !"".equals(secondPage.getApplySubject())) {
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
            mainBoardService.updateApplySubject(id, Integer.parseInt(secondPage.getApplySubject()));
            //更新第二页信息
            tutorInspectService.updateTutorInspectSecond(id, secondPage);
            //返回成功信息
            return new Result(ResultCode.SUCCESS);
        }
        //失败
        return Result.FAIL();
    }

    /**
     *
     * @param thirdPage 第三页表单
     * @param applyId 首次申请博士
     * @param id apply表中的主键id
     * @return
     */
    @ApiOperation("更新第三页博士信息")
    @PostMapping("updateThirdPage/{applyId}/{id}")
    public Result updateThirdPage(@RequestBody ThirdPage thirdPage,@PathVariable("applyId") int applyId,@PathVariable("id") int id){
        //更新学术论文表 academic_paper

        //1.查找是否有此申请对应的学术论文

        //2.无对应的论文进行插入操作

        //3.有对应的论文 先批量删除后重新插入
        //判断academic_paper是否有对应的数据，有更新，无插入

        //更新科研项目表

        //教材或学术著作表

        //科研教学奖励

        //发明专利

        //汇总生成表
        return Result.FAIL();
    }
    //文件上传controller
    @ApiOperation("文件上传")
    @PostMapping("/upload/{typeId}")
    public Result uploadFile(@RequestParam("material") MultipartFile uploadFile, @PathVariable("typeId") Integer typeId, HttpServletRequest req) {
        UpLoadFile loadFile = new UpLoadFile();
        String typeName = "";
        if (!"".equals(typeId)) {
            switch (typeId) {
                case 1: {
                    typeName = "学术论文/社科类论文";
                    break;
                }
                case 2: {
                    typeName = "学术论文/理工类论文";
                    break;
                }
                case 3: {
                    typeName = "科研项目";
                    break;
                }
                case 4: {
                    typeName = "教材或学术著作";
                    break;
                }
                case 5: {
                    typeName = "科研教学奖励";
                    break;
                }
                case 6: {
                    typeName = "发明专利";
                    break;
                }
                default: {
                    return Result.FAIL();
                }
            }
            String path = loadFile.upload(uploadFile, req, typeName, tutorId);
            System.out.println(path);
            if (!"".equals(path)) {
                //路径不为空
                HashMap<String, Object> map = new HashMap<>();
                map.put("fileType",typeId);
                map.put("path",path);
                return new Result(ResultCode.SUCCESS, map);
            } else {   //路径为空
                return Result.FAIL();
            }
        }
        return Result.FAIL();
    }

    //文件删除
    @ApiOperation("文件删除")
    @PostMapping("/delFile")
    public Result delFile(@RequestBody String httpPath) throws UnsupportedEncodingException {

        if (!"".equals(httpPath)){
            //有路径
            UpLoadFile loadFile = new UpLoadFile();
            String res = loadFile.delFile(URLDecoder.decode(httpPath, "UTF-8"));
            if ("ok".equals(res)){
                return Result.SUCCESS();
            }
        }
        return Result.FAIL();
    }
}





