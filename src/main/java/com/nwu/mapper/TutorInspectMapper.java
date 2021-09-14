package com.nwu.mapper;

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

}
