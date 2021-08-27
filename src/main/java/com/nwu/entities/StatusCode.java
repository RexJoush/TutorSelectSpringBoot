package com.nwu.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "StatusCode对象", description = "")
public class StatusCode implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "apply_id", type = IdType.ID_WORKER)
    private int codeId;  //状态码
    private String codeDescribe; //状态码描述
    private String inspectDescribe;  //状态码显示描述
}
