package com.nwu.mapper;

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

    List<QueryDepartmentSecretaryInit> getTutorInspectInit(int organizationId, List<String> applyStatuss);
    List<QueryDepartmentSecretaryInit> getTutorNoInspectInit(int organizationId, List<String> applyStatuss);

    /**
     * 条件查询申请信息
     * @param tutorQuery 查询条件
     * @return 申请列表
     */
    List<QueryDepartmentSecretaryInit> getTutorInspectSearch(TutorQuery tutorQuery);

    /**
     * 条件查询申请信息
     * @param tutorQuery 查询条件
     * @return 申请列表
     */
    List<QueryDepartmentSecretaryInit> getTutorNoInspectSearch(TutorQuery tutorQuery);

    List<QueryDepartmentSecretaryInit> selectByQuery(TutorQuery tutorQuery);

    int saveTutorInspectBaseInfo(@Param("firstPage") FirstPage firstPage);

    SecondPage getTutorInspectSecond(@Param("applyId") int applyId);


    int updateTutorInspectSecond(@Param("applyId") int applyId, @Param("secondPage") SecondPage secondPage);

    /**
     * 从 tutorInspect 获取基本信息
     * @param applyId
     * @return
     */
    FirstPage getFirstPage(@Param("applyId") int applyId);


    int updateFirstPage(String applyId, String phone, String email, String evaluateTime, String awardingUnitTime);

    /**
     * 获取tutorInspect表全部信息
     * @param applyId   申请主键
     * @return  PdfTutorInspect
     */
    PdfTutorInspect getTutorInspect(@Param("applyId") Integer applyId);

}
