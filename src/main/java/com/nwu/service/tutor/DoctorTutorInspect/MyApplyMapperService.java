package com.nwu.service.tutor.DoctorTutorInspect;

import com.nwu.entities.Apply;

import java.util.List;

public interface MyApplyMapperService {
    /**
     * 查询是否存在相应的申请记录
     * @param tutorId
     * @return 行数
     */
    int getApplyByTutorIdService(String tutorId);

    /**
     * 查询apply信息
     * @param tutorId 导师工号
     * @param applyId 申请类别
     * @return
     */
    Apply getApplyInfoByTutorIdAndApplyId(String tutorId, Integer applyId);

    /**
     * 查询 apply 信息
     * @param tutorId 导师工号
     * @param applyId 申请类别
     * @return
     */
    Apply getApplyByTutorIdAndApplyIdAndStatus(String tutorId, Integer applyId);

    /**
     * 存储apply表
     * @param apply
     * @return int
     */
    int saveApplyInfo(Apply apply);

    /**
     * 根据工号和申请类别查询对应的主键id
     * @param tutorId
     * @param applyId
     * @return
     */
    int getIdByTutorIdAndApplyId(String tutorId,Integer applyId);
}
