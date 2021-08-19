package com.nwu.vo;

import lombok.Data;

/*
*  封装 修改审核状态时下发的对象
*/
@Data
public class updateStatus {
    private int id_1;
    private String number_1;  //导师工号
    private int applyId_1;    //申请类型id
    private int status_1;     //修改后的状态
    private String commit_1;   //审核完带回的备注
}
