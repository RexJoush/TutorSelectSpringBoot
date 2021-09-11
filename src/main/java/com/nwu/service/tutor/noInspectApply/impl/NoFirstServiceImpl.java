package com.nwu.service.tutor.noInspectApply.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nwu.entities.Apply;
import com.nwu.entities.Organization;
import com.nwu.entities.tutor.noInspect.NoFirstPage;
import com.nwu.mapper.TutorNoInspectMapper;
import com.nwu.mapper.tutor.common.TutorApplyMapper;
import com.nwu.service.OrganizationService;
import com.nwu.service.tutor.noInspectApply.NoFirstService;
import com.nwu.util.SaveImage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Service
public class NoFirstServiceImpl implements NoFirstService {

    @Resource
    private OrganizationService organizationService;

    @Resource
    TutorNoInspectMapper noInspectMapper;

    @Resource
    TutorNoInspectMapper tutorNoInspectMapper;

    @Override
    public int saveNoFirstPage(NoFirstPage noFirstPage, HttpServletRequest request) throws Exception {
        int i=0;
        try{
            //添加教师基本表 院系名字
            QueryWrapper<Organization> queryWrapper = new QueryWrapper();
            queryWrapper.eq("organization_name", noFirstPage.getOrganizationName());
            Organization one = organizationService.getOne(queryWrapper);
            // 设置院系 id
            noFirstPage.setOrganizationId(one.getOrganizationId());
            if (!"".equals(noFirstPage.getAwardDepartment())){
                // 拼接授予时间及单位
                noFirstPage.setAwardingUnitTime(noFirstPage.getAwardDepartment() + " " + noFirstPage.getAwardTime());
            }else
            {
                noFirstPage.setAwardingUnitTime("");
            }
            //将图路径存入数据库
            String httpPath = SaveImage.ExportBlob( noFirstPage.getBlobImage(), noFirstPage.getTutorId(), request) ;
            noFirstPage.setImage(httpPath);
            i=tutorNoInspectMapper.saveTutorNoInspectFirstPage(noFirstPage);
        }
        catch (Exception e){
            return 0;
        }
        return i;
    }

    @Override
    public int saveNoApplyInfo(Apply apply) {
        return tutorNoInspectMapper.saveNoApplyInfo(apply);
    }

    @Override
    public NoFirstPage getNoFirstPage(String applyId) {
        NoFirstPage noFirstPage = noInspectMapper.getNoFirstPage(applyId);
        //查询所在院系
        QueryWrapper<Organization> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("organization_id", noFirstPage.getOrganizationId());
        noFirstPage.setOrganizationName(organizationService.getOne(queryWrapper).getOrganizationName());
        //设置对应的授予单位及时间
        if (!"".equals(noFirstPage.getAwardingUnitTime())){
            noFirstPage.setAwardDepartment(noFirstPage.getAwardingUnitTime().split(" ")[0]);
            noFirstPage.setAwardTime(noFirstPage.getAwardingUnitTime().split(" ")[1]);
        }
        return noFirstPage;
    }
}
