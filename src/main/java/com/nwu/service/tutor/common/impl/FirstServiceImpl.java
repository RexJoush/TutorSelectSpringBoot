package com.nwu.service.tutor.common.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nwu.entities.Apply;
import com.nwu.entities.Organization;
import com.nwu.entities.tutor.FirstPage;
import com.nwu.mapper.TutorInspectMapper;
import com.nwu.mapper.tutor.common.TutorApplyMapper;
import com.nwu.service.OrganizationService;
import com.nwu.service.tutor.common.FirstService;
import com.nwu.util.SaveImage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Service
public class FirstServiceImpl implements FirstService {

    @Resource
    private TutorApplyMapper tutorApplyMapper;

    @Resource
    private OrganizationService organizationService;

    @Resource
    private TutorInspectMapper tutorInspectMapper;

    @Override
    public int saveApplyInfo(Apply apply) {
        return tutorApplyMapper.saveApplyInfo(apply);
    }

    @Override
    public int saveFirstPage(FirstPage firstPage, HttpServletRequest request) throws Exception {
        int i=0;
        try{
            //添加教师基本表 院系名字
            QueryWrapper<Organization> queryWrapper = new QueryWrapper();
            queryWrapper.eq("organization_name", firstPage.getOrganizationName());
            Organization one = organizationService.getOne(queryWrapper);
            // 设置院系 id
            firstPage.setOrganizationId(one.getOrganizationId());
            // 拼接授予时间及单位
            firstPage.setAwardingUnitTime(firstPage.getAwardDepartment() + " " + firstPage.getAwardTime());
            //将图路径存入数据库
            String httpPath = SaveImage.ExportBlob( firstPage.getBlobImage(), firstPage.getTutorId(), request) ;
            firstPage.setImage(httpPath);
            i=tutorInspectMapper.saveTutorInspectBaseInfo(firstPage);
        }
        catch (Exception e){
            return 0;
        }
        return i;
    }
}
