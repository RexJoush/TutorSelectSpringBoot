package com.nwu.mapper;

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
    NoFirstPage getNoFirstPage(@Param("applyId") String applyId);
}
