package com.nwu.mapper.DoctorTutorInspectMapper;

import com.nwu.entities.Apply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MyApplyMapper {
    /**
     * 查询教师工号查询tutor_id是否存在
     *
     * @param tutorId
     * @return 受影响的行数
     */
    int getApplyByTutorId(@Param("tutorId") String tutorId);

    /**
     * 根据导师工号和申请类别查询出对应的apply信息
     *
     * @param tutorId
     * @param applyId
     * @return
     */
    Apply getApplyInfoByTutorIdAndApplyId(@Param("tutorId") String tutorId, @Param("applyId") Integer applyId);

    /**
     * 添加tutor_id apply_id status
     *
     * @param apply
     * @return 影响的行数
     */
    int saveApplyInfo(@Param("apply") Apply apply);

    /**
     * 根据tutorId获取当前申请的id主键
     *
     * @param tutorId
     * @return
     */
    int getIdByTutorIdAndApplyId(@Param("tutorId") String tutorId, @Param("applyId") Integer applyId);

    Apply getApplyByTutorIdAndApplyIdAndStatus(@Param("tutorId") String tutorId, @Param("applyId") Integer applyId);
}
