package com.nwu.entities;


import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Apply对象", description="")
public class Apply implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id; //申请表id
    private String tutorId;  //导师工号
    private int applyId;   //申请的类别 id
    private int status;  //当前申请的状态
    private int subject;  //分科，文科或理科
    private int professional;  //专硕或学硕

}
