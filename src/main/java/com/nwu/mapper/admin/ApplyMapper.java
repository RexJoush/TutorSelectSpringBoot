package com.nwu.mapper.admin;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nwu.entities.Apply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ApplyMapper extends BaseMapper<Apply> {

    int updateApplyStatus(@Param("id") Integer id,@Param("status") Integer status, @Param("commit") String commit);

    /**
     * 导师提交最后一页修改
     * @param applyId
     * @param status
     * @param time
     * @return
     */
    int updateApplyStatusAndTime(@Param("applyId") Integer applyId, @Param("status") Integer status,@Param("time") String time);
}
