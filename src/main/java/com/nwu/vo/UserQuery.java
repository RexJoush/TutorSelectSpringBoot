package com.nwu.vo;

import lombok.Data;

/**
 * @program: TutorSelectSpringBoot
 * @description: 系统用户查询参数
 * @author: dynamic
 * @create: 2021-08-10 10:55
 **/
@Data
public class UserQuery {
    private int pageNum;
    private int pageSize;
    private String userId;
    private String userName;
    private String organization;
    private String userRole;
    private String createTime;
}
