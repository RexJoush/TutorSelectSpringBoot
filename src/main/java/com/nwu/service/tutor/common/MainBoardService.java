package com.nwu.service.tutor.common;

import com.nwu.entities.Apply;

public interface MainBoardService {

    /**
     * 查询是否存在相应的申请记录
     * @param tutorId 教师工号
     * @return 行数
     */
    // int getApplyByTutorIdService(String tutorId);

    /**
     * 查询 apply 信息
     *
     * @param tutorId 导师工号
     * @param applyTypeId 申请类别
     * @return apply 信息
     */
    Apply getApplyInfoByTutorIdAndApplyId(String tutorId, Integer applyTypeId);

    /**
     * 查询 apply 信息
     *
     * @param tutorId 导师工号
     * @param applyId 申请类别
     * @return apply 信息
     */
    Apply getApplyByTutorIdAndApplyTypeIdAndStatus(String tutorId, Integer applyId);

    /**
     * 存储 apply 表
     *
     * @param apply 申请信息
     * @return 返回主键
     */
    int saveApplyInfo(Apply apply);

    /**
     * 更新第一页的申请学科
     *
     * @param applyId      申请表的主键
     * @param applySubject 申请学科代码，1 文史， 2 理工， 3 交叉学科
     * @return 影响的行数
     */
    int updateApplySubject(int applyId, int applySubject);

    /**
     * 根据工号和申请类别，申请状态查询对应的主键id
     *
     * @param tutorId 教师工号
     * @param applyTypeId 申请类别
     * @param status  申请表的状态
     * @return 查询主键
     */
    int getApplyId(String tutorId, int applyTypeId, int status);

    /**
     * 查询主键 id
     *
     * @param tutorId 教师 id
     * @param status  申请状态
     * @return 主键
     */
    int getApplyIdByTutorIdAndStatus(String tutorId, Integer status);
}
