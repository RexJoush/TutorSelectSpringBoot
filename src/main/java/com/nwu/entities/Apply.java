package com.nwu.entities;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Apply对象")
@TableName("apply")
public class Apply implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "apply_id", type = IdType.AUTO)
    private int applyId; // 申请表id 自增
    private String tutorId;  // 导师工号
    private int applyTypeId;   // 申请的类别 id
    private int status;  // 当前申请的状态
    private int subject;  // 分科，文科或理科
    private int professional;  // 专硕或学硕
    private String commit;  // 备注，驳回理由
    private String submitTime; // 提交申请的时间

}
