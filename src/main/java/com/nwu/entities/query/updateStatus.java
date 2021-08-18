package com.nwu.entities.query;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.io.Serializable;

/*
*  封装 修改审核状态时下发的对象
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class updateStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    private String number_1;  //导师工号
    private int applyId_1;    //申请类型id
    private int status_1;     //修改后的状态
}
