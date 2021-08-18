package com.nwu.service.DoctorTutorInspect;

import com.nwu.entities.Apply;

public interface MyApplyMapperService {
    /**
     * 查询是否存在相应的申请记录
     * @param tutorId
     * @return 行数
     */
    int GetApplyByTutorIdService(String tutorId);

    /**
     * 查询apply信息
     * @param tutorId 导师工号
     * @param applyId 申请类别
     * @return
     */
    Apply GetApplyInfoBytutorIdAndApplyId(String tutorId, Integer applyId );

    /**
     * 存储apply表
     * @param apply
     * @return int
     */
    int SaveApplyInfo(Apply apply);

    /**
     * 根据工号和申请类别查询对应的主键id
     * @param tutorId
     * @param applyId
     * @return
     */
    int GetIdByTutorIdAndApplyId(String tutorId,Integer applyId);
}
