package com.nwu.service.tutor.common;

import com.nwu.entities.Apply;

public interface MainBoardService {

    /**
     * 查询是否存在相应的申请记录
     * @param tutorId 教师工号
     * @return 行数
     */
    int getApplyByTutorIdService(String tutorId);

    /**
     * 查询 apply 信息
     * @param tutorId 导师工号
     * @param applyId 申请类别
     * @return apply 信息
     */
    Apply getApplyInfoByTutorIdAndApplyId(String tutorId, Integer applyId);

    /**
     * 查询 apply 信息
     * @param tutorId 导师工号
     * @param applyId 申请类别
     * @return apply 信息
     */
    Apply getApplyByTutorIdAndApplyIdAndStatus(String tutorId, Integer applyId);

    /**
     * 存储apply表
     * @param apply 申请信息
     * @return int 影响的行数
     */
    int saveApplyInfo(Apply apply);

    /**
     * 根据工号和申请类别查询对应的主键id
     * @param tutorId 教师工号
     * @param applyId 申请类别
     * @return 查询主键
     */
    int getIdByTutorIdAndApplyId(String tutorId,Integer applyId);

    /**
     * 查询主键id
     * @param tutorId 教师 id
     * @param status 申请状态
     * @return 主键
     */
    int getApplyIdByTutorIdAndStatus(String tutorId, Integer status);
}
