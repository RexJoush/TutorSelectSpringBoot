package com.nwu.mapper;

import com.nwu.entities.ApplyInfo;
import com.nwu.entities.PdfEntity.PdfTutorInspect;
import com.nwu.entities.TutorInspect;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nwu.entities.tutor.FirstPage;

import com.nwu.vo.QueryDepartmentSecretaryInit;

import com.nwu.entities.tutor.SecondPage;
import com.nwu.vo.TutorQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  导师非免审信息表 Mapper 接口
 * </p>
 *
 * @author dynamic
 * @since 2021-08-09
 */
@Mapper
public interface TutorInspectMapper extends BaseMapper<TutorInspect> {


    /**
     * 获取所有初始化申请信息
     * @param organizationId 院系 id
     * @param applyStatuss 申请状态列表
     * @param pageStart limit 起始索引
     */
    List<ApplyInfo> getTutorInspectApplyInit(int organizationId, List<String> applyStatuss, int pageStart);
    int getTutorInspectApplyInitTotal(int organizationId, List<String> applyStatuss);

    /**
     * 获取所有搜索的申请信息
     * @param tutorQuery 搜索条件
     *        tutorQuery.userId 工号
     *        tutorQuery.userName 姓名
     *        tutorQuery.organization 院系 id
     *        tutorQuery.applyType 申请类别
     *        tutorQuery.subjectType 学科属性，文史 1，理工 2，交叉学科 3
     *        tutorQuery.applyStatuss 申请状态码列表
     * @param pageStart limit 起始索引
     */
    List<ApplyInfo> getTutorInspectApplySearch(TutorQuery tutorQuery, int pageStart);
    int getTutorInspectApplySearchTotal(TutorQuery tutorQuery);

    /**
     * 非免审 ---- 查询当前申请的详细信息，用于管理员页面的展示
     * @param applyId 申请 id
     * @return 申请详情
     */
    QueryDepartmentSecretaryInit getTutorInspectApplyInitDetails(int applyId);

    /**
     * 免审 ---- 查询当前申请的详细信息，用于管理员页面的展示
     * @param applyId 申请 id
     * @return 申请详情
     */
    QueryDepartmentSecretaryInit getTutorNoInspectApplyInitDetails(int applyId);




    /**
     * 获取所有非免审的信息
     * @param organizationId 院系 id
     * @param applyStatuss 申请状态
     */
    // List<QueryDepartmentSecretaryInit> getTutorInspectInit(int organizationId, List<String> applyStatuss);

    /**
     *
     * @param organizationId
     * @param applyStatuss
     * @return
     */
    // List<QueryDepartmentSecretaryInit> getTutorNoInspectInit(int organizationId, List<String> applyStatuss);

    /**
     * 条件查询申请信息
     * @param tutorQuery 查询条件
     * @return 申请列表
     */
    // List<QueryDepartmentSecretaryInit> getTutorInspectSearch(TutorQuery tutorQuery);

    /**
     * 条件查询申请信息
     * @param tutorQuery 查询条件
     * @return 申请列表
     */
    // List<QueryDepartmentSecretaryInit> getTutorNoInspectSearch(TutorQuery tutorQuery);

    List<QueryDepartmentSecretaryInit> selectByQuery(TutorQuery tutorQuery);

    int saveTutorInspectBaseInfo(@Param("firstPage") FirstPage firstPage);

    SecondPage getTutorInspectSecond(@Param("applyId") int applyId);


    int updateTutorInspectSecond(@Param("applyId") int applyId, @Param("secondPage") SecondPage secondPage);

    /**
     * 从 tutorInspect 获取第一页基本信息
     * @param applyId 申请 id
     * @return 第一页的信息
     */
    FirstPage getFirstPage(@Param("applyId") int applyId);


    int updateFirstPage(String applyId, String phone, String email, String evaluateTime, String awardingUnitTime);

    /**
     * 获取 tutorInspect 表全部信息
     * @param applyId   申请主键
     * @return  PdfTutorInspect
     */
    PdfTutorInspect getTutorInspect(@Param("applyId") Integer applyId);

}
