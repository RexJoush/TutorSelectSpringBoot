package com.nwu.entities.tutor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Rex Joush
 * @time 2021.08.23 15:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherInfo implements Serializable {

    private String XM;      // 姓名
    private String SFZJH;   // 身份证号
    private String XB;      // 性别
    private String SJH;     // 手机号
    private String MC;      // 单位
    private String SHZ;     // 招聘
    private String CSRQ;    // 出生日期
    private String ZGXW;    // 最高学位
    private String ZGH;     // 工号
    private String ZCMC;    // 职称

}
