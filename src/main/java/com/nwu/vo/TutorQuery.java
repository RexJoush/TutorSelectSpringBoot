package com.nwu.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @program: TutorSelectSpringBoot
 * @description: 管理员筛选查询条件
 * @author: dynamic
 * @create: 2021-08-17 15:12
 **/
@Data
public class TutorQuery {
    private int pageNum;
    private int pageSize;
    //学号
    private String userId;
    //姓名
    private String userName;
    //部门id
    private String organization;
    //申请类别
    private String applyType;
    //学科属性
    private String subjectType;
    //学科名称
    private String subjectName;
    //申请状态
    private String applyStatus;
    //申请状态码数组
    private List<String> applyStatuss;

    public TutorQuery(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getApplyType() {
        return applyType;
    }

    public void setApplyType(String applyType) {
        this.applyType = applyType;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus;
    }
}
