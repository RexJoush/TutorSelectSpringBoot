package com.nwu.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nwu.entities.Organization;
import com.nwu.entities.TutorInspect;
import com.nwu.entities.tutor.FirstPage;
import com.nwu.entities.tutor.SecondPage;
import com.nwu.entities.tutor.childSubject.ExpertTitle;
import com.nwu.entities.tutor.childSubject.GroupsOrPartTimeJob;
import com.nwu.mapper.TutorInspectMapper;
import com.nwu.service.OrganizationService;
import com.nwu.service.TutorInspectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nwu.vo.QueryDepartmentSecretaryInit;
import com.nwu.vo.TutorQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author dynamic
 * @since 2021-08-09
 */
@Service
public class TutorInspectServiceImpl extends ServiceImpl<TutorInspectMapper, TutorInspect> implements TutorInspectService {

    @Resource
    private TutorInspectMapper tutorInspectMapper;

    @Resource
    private OrganizationService organizationService;

    @Override
    public FirstPage getFirstPage(String applyId) {

        FirstPage firstPage = tutorInspectMapper.getFirstPage(applyId);
        // 查询所在院系
        QueryWrapper<Organization> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("organization_id", firstPage.getOrganizationId());
        Organization one = organizationService.getOne(queryWrapper);
        firstPage.setOrganizationName(one.getOrganizationName());

        // 设置对应的授予单位及时间
        if (!"".equals(firstPage.getAwardingUnitTime())) {
            firstPage.setAwardDepartment(firstPage.getAwardingUnitTime().split(" ")[0]);
            firstPage.setAwardTime(firstPage.getAwardingUnitTime().split(" ")[1]);
        }
        return firstPage;
    }

    @Override
    public List<QueryDepartmentSecretaryInit> getTutorByQuery(TutorQuery tutorQuery) {
        return tutorInspectMapper.selectByQuery(tutorQuery);
    }

    @Override
    public int saveTutorInspectBaseInfo(FirstPage firstPage) {

        return tutorInspectMapper.saveTutorInspectBaseInfo(firstPage);
    }

    @Override
    public SecondPage getTutorInspectSecond(int applyId) {

        return tutorInspectMapper.getTutorInspectSecond(applyId);
    }

    @Override
    public int updateTutorInspectSecond(int applyId, SecondPage secondPage) {
        return tutorInspectMapper.updateTutorInspectSecond(applyId, secondPage);
    }

}
