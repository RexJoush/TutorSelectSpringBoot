package com.nwu.entities.query;

import lombok.Data;

/*
*  封装 修改审核状态时下发的对象
*/
@Data
public class updateStatus {
    private String number_1;  //导师工号
    private int applyId_1;    //申请类型id
    private int status_1;     //修改后的状态
}
