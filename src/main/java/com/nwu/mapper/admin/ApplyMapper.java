package com.nwu.mapper.admin;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nwu.entities.Apply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.nwu.vo.ApplyDisplayVo;

import java.util.List;

@Mapper
public interface ApplyMapper extends BaseMapper<Apply> {

    /**
     *
     * @param id
     * @param status
     * @param commit 院系秘书初审页面的备注
     * @return
     */
    int updateApplyStatusAndCommit(@Param("applyId") Integer id, @Param("status") Integer status, @Param("commit") String commit);
    /**
     *
     * @param id
     * @param status
     * @param commit 院系秘书提交分会页面的备注
     * @return
     */
    int updateApplyStatusAndCommitSfh(@Param("applyId") Integer id, @Param("status") Integer status, @Param("commit") String commit);

    /**
     *
     * @param id
     * @param status
     * @param commit 院系秘书录入分会意见页面的备注
     * @return
     */
    int updateApplyStatusAndCommitXy(@Param("applyId") Integer id, @Param("status") Integer status, @Param("commit") String commit);
    /**
     * 导师提交最后一页修改
     *
     * @param applyId
     * @param status
     * @param time
     * @return
     */
    int updateApplyStatusAndTime(@Param("applyId") Integer applyId, @Param("status") Integer status, @Param("time") String time);

    List<ApplyDisplayVo> getInspectApply(String tutorId);

    List<ApplyDisplayVo> getNoInspectApply(String tutorId);

}
