package com.nwu.vo;

import lombok.Data;

/**
 * @program: TutorSelectSpringBoot
 * @description: 使用系统用户的显示信息，
 * @author: dynamic
 * @create: 2021-08-09 21:12
 **/

@Data
public class UserVo {
    // 学工号
    private String userId;
    // 姓名
    private String userName;
    // 院系
    private String organization;
    // 状态
    private String status;
    // 创建时间
    private String createTime;
    // 管理员角色
    private String mr;
    // 用户角色
    private String userRole;

}
