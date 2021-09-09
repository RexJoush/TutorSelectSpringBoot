package com.nwu.service.admin;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nwu.entities.Apply;
import com.nwu.entities.tutor.ApplyDisplay;

import java.util.List;

public interface ApplyService extends IService<Apply> {

    /**
     * 申请表的状态修改方法
     *
     * @param applyId 申请表的 id 值
     * @param status  修改后的状态
     * @param commit  备注，可选
     * @return 修改的结果
     */
    int updateApplyStatus(Integer applyId, Integer status, String commit);

    /**
     * 院系秘书初审提交分会页面的更新操作
     *
     * @param applyId 申请表的 id 值
     * @param status  修改后的状态
     * @param commit  备注，可选
     * @return 修改的结果
     */
    int updateApplyStatusSfh(Integer applyId, Integer status, String commit);

    /**
     * 院系秘书录入分会页面的更新操作
     *
     * @param applyId 申请表的 id 值
     * @param status  修改后的状态
     * @param commit  备注，可选
     * @return 修改的结果
     */
    int updateApplyStatusAndCommitXy(Integer applyId, Integer status, String commit);

    /**
     * 查询当前教师的所有申请
     *
     * @param tutorId 教师工号
     * @return 所有的申请
     */
    List<ApplyDisplay> getApplyList(String tutorId);

    /**
     * 导师提交最后一页修改apply
     *
     * @param applyId
     * @param status
     * @param time
     * @return int
     */
    int updateApplyStatusAndTime(Integer applyId, Integer status, String time);


}
