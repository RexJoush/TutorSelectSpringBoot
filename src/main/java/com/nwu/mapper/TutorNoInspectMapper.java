package com.nwu.mapper;

import com.nwu.entities.Apply;
import com.nwu.entities.PdfEntity.PdfNoTutorInspect;
import com.nwu.entities.tutor.noInspect.NoFirstPage;
import com.nwu.entities.tutor.noInspect.NoSecondPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TutorNoInspectMapper {

    /**
     * 根据applyId查询免审第二页信息
     * @param applyId
     * @return
     */
    NoSecondPage getSecondPage(@Param("applyId") String applyId);

    /**
     * 根据applyId查询免审第一页信息
     * @param applyId
     * @return
     */
    NoFirstPage getNoFirstPage(@Param("applyId") int applyId);

    /**
     * 保存免审第一页信息 tutor_no_inspect
     * @param noFirstPage
     * @return
     */
    int saveTutorNoInspectFirstPage(@Param("noFirstPage") NoFirstPage noFirstPage);

    /**
     * 更新免审第二页信息
     * @param noSecondPage
     * @return
     */
    int updateTutorNoInspectSecondPage(@Param("noSecondPage") NoSecondPage noSecondPage,@Param("applyId") Integer applyId);

    /**
     * 添加申请表信息 tutor_id apply_type_id status
     * @param apply 申请信息
     * @return 影响的行数
     */
    int saveNoApplyInfo(@Param("apply") Apply apply);

    /**
     * 更新第一页的申请学科
     *
     * @param applyId      申请表的主键
     * @param applySubject 申请学科代码，1 文史， 2 理工， 3 交叉学科
     * @return 影响的行数
     */
    int updateApplySubjectStatusTimeByApplyId(@Param("applySubject") int applySubject, @Param("status") int status,@Param("submitTime") String submitTime,@Param("applyId") int applyId);

    /**
     * pdf打印免审信息
     * @param applyId 主键
     * @return  实体类
     */
    PdfNoTutorInspect getPdfTutorNoInspect(@Param("applyId") String applyId);
}
