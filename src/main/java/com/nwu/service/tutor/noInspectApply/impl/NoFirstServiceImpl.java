package com.nwu.service.tutor.noInspectApply.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nwu.entities.Organization;
import com.nwu.entities.tutor.noInspect.NoFirstPage;
import com.nwu.mapper.TutorNoInspectMapper;
import com.nwu.service.OrganizationService;
import com.nwu.service.tutor.noInspectApply.NoFirstService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class NoFirstServiceImpl implements NoFirstService {

    @Resource
    private OrganizationService organizationService;

    @Resource
    TutorNoInspectMapper noInspectMapper;

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
