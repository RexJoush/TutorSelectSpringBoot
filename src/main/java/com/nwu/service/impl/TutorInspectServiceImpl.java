package com.nwu.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nwu.entities.Organization;
import com.nwu.entities.PdfEntity.PdfTutorInspect;
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
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    public FirstPage getFirstPage(int applyId) {

        FirstPage firstPage = null;
        try {
            firstPage = tutorInspectMapper.getFirstPage(applyId);
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
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("获取教师信息失败" + "!" + e.getMessage());
        }
        return firstPage;
    }

    @Override
    public List<QueryDepartmentSecretaryInit> getTutorInitOrSearch(int organizationId, List<String> applyStatuss, TutorQuery tutorQuery, int type) {

        List<QueryDepartmentSecretaryInit> tutorInspectInit = null;
        List<QueryDepartmentSecretaryInit> tutorNoInspectInit = null;

        try {
            // 获取非免审的信息
            if (type == 0) {
                // 非条件查询
                tutorInspectInit = tutorInspectMapper.getTutorInspectInit(organizationId, applyStatuss);
            } else {
                // 条件查询
                tutorInspectInit = tutorInspectMapper.getTutorInspectSearch(tutorQuery);
            }
            for (QueryDepartmentSecretaryInit queryDepartmentSecretaryInit : tutorInspectInit) {
                switch (queryDepartmentSecretaryInit.getApplyTypeId()) {
                    case 1:
                    case 2:
                    case 4:
                    case 5:
                        queryDepartmentSecretaryInit.setApplyDepartment(queryDepartmentSecretaryInit.getDoctoralMasterApplicationSubjectUnit());
                        if (queryDepartmentSecretaryInit.getDoctoralMasterSubjectCode() == null) {
                            queryDepartmentSecretaryInit.setApplySubject("");
                        } else {
                            queryDepartmentSecretaryInit.setApplySubject(queryDepartmentSecretaryInit.getDoctoralMasterSubjectCode() + " " + queryDepartmentSecretaryInit.getDoctoralMasterSubjectName());
                        }
                        break;
                    case 7:
                    case 8:
                        queryDepartmentSecretaryInit.setApplyDepartment(queryDepartmentSecretaryInit.getProfessionalApplicationSubjectUnit());
                        if (queryDepartmentSecretaryInit.getProfessionalApplicationSubjectCode() == null) {
                            queryDepartmentSecretaryInit.setApplySubject("");
                        } else {
                            if (queryDepartmentSecretaryInit.getProfessionalFieldCode() == null) {
                                queryDepartmentSecretaryInit.setApplySubject(queryDepartmentSecretaryInit.getProfessionalApplicationSubjectCode() + " " + queryDepartmentSecretaryInit.getProfessionalApplicationSubjectName());
                            } else {
                                queryDepartmentSecretaryInit.setApplySubject(queryDepartmentSecretaryInit.getProfessionalFieldCode() + " " + queryDepartmentSecretaryInit.getProfessionalFieldName());
                            }
                        }
                        break;
                    default:
                        break;
                }
                // 标识非免审
                queryDepartmentSecretaryInit.setNoInspect(false);
            }

            // 获取免审的信息
            if (type == 0) {
                tutorNoInspectInit = tutorInspectMapper.getTutorNoInspectInit(organizationId, applyStatuss);
            } else {
                tutorNoInspectInit = tutorInspectMapper.getTutorNoInspectSearch(tutorQuery);
            }
            // 标记免审
            tutorNoInspectInit.forEach(queryDepartmentSecretaryInit -> queryDepartmentSecretaryInit.setNoInspect(true));

            for (QueryDepartmentSecretaryInit queryDepartmentSecretaryInit : tutorNoInspectInit) {
                // 设置申请的学院和专业
                if (!"".equals(queryDepartmentSecretaryInit.getAppliedSubjectUnit()) && queryDepartmentSecretaryInit.getAppliedSubjectUnit() != null) {
                    queryDepartmentSecretaryInit.setApplyDepartment(queryDepartmentSecretaryInit.getAppliedSubjectUnit());
                } else {
                    queryDepartmentSecretaryInit.setApplyDepartment("");
                }

                if (!"".equals(queryDepartmentSecretaryInit.getAppliedSubjectCode()) && queryDepartmentSecretaryInit.getAppliedSubjectCode() != null) {
                    queryDepartmentSecretaryInit.setApplySubject(queryDepartmentSecretaryInit.getAppliedSubjectCode() + " " + queryDepartmentSecretaryInit.getAppliedSubjectName());
                } else {
                    queryDepartmentSecretaryInit.setApplySubject("");
                }

                // 标识免审
                queryDepartmentSecretaryInit.setNoInspect(true);
            }

        } catch (Exception e) {
            throw new RuntimeException("获取数据失败，请稍后再试" + "!" + e.getMessage());
        }

        // 返回合并后的列表
        return Stream.of(tutorInspectInit, tutorNoInspectInit).flatMap(Collection::stream).collect(Collectors.toList());
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

    /**
     * pdf打印
     * @param applyId
     * @return
     */
    @Override
    public PdfTutorInspect getPdfTutorInspect(int applyId) {
        return tutorInspectMapper.getTutorInspect(applyId);
    }


}
