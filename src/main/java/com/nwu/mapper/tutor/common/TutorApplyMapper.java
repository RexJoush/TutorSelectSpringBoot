package com.nwu.mapper.tutor.common;

import com.nwu.entities.Apply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface TutorApplyMapper {
    /**
     * 查询教师工号查询 tutor_id 是否存在
     *
     * @param tutorId 教师 id
     * @return 受影响的行数
     */
    int getApplyByTutorId(@Param("tutorId") String tutorId);

    /**
     * 根据导师工号和申请类别查询出对应的apply信息
     *
     * @param tutorId 导师工号
     * @param applyId 申请类别
     * @return apply 信息
     */
    Apply getApplyInfoByTutorIdAndApplyId(@Param("tutorId") String tutorId, @Param("applyId") Integer applyId);

    /**
     * 添加tutor_id apply_id status
     *
     * @param apply 申请信息
     * @return 影响的行数
     */
    int saveApplyInfo(@Param("apply") Apply apply);

    /**
     * 根据tutorId获取当前申请的id主键
     *
     * @param tutorId 教师工号
     * @return 影响的行数
     */
    int getIdByTutorIdAndApplyId(@Param("tutorId") String tutorId, @Param("applyId") Integer applyId);


    Apply getApplyByTutorIdAndApplyIdAndStatus(@Param("tutorId") String tutorId, @Param("applyId") Integer applyId);

    /**
     * 根据教师工号和申请状态查询主键id
     */
    int getApplyIdByTutorIdAndStatus(@Param("tutorId") String tutorId, @Param("status") Integer status);
}
