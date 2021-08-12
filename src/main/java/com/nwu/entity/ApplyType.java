package com.nwu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

@Data
//@EqualsAndHashCode(callSuper = false)
//@Accessors(chain = true)
//@ApiModel(value="ApplyType对象", description="")
public class ApplyType implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "apply_id", type = IdType.ID_WORKER)
    private int applyId;  //申请类型id

    private String applyName;  //申请类型名称

    private String applyPath;  //申请路径
}
