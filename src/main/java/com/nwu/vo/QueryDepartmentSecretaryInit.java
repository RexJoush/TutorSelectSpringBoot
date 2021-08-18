package com.nwu.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class QueryDepartmentSecretaryInit implements Serializable{
    private static final long serialVersionUID = 1L;

    //导师非免审申请表
    private String tutorId;  //教师id
    private String number;  //教师工号

    private String name;

    private Integer organizationId;

    private String gender;

    private String birthday;

    private String image;

    private String identity;

    private String phone;

    private String email;

    private String finalDegree;

    private String awardingUnitTime;

    private String researchDirections;

    private String academicGroupsJobs;

    private String titlesOfExpert;

    private String title;

    private String professionalTitle;

    private String evaluateTime;

    private String sourceUnitName;

    private String transferInTime;

    private String doctoralTutorOnDuty;

    private String doctoralStartTime;

    private String firstDoctoralFirstTimeTutor;

    private String firstDoctoralFirstDiscipline;

    private String masterDegreeIncreaseTutorOnDuty;

    private String masterDegreeIncreaseTutorStartTime;

    private String doctoralMasterApplicationSubjectUnit;

    private String doctoralMasterSubjectCode;

    private String doctoralMasterSubjectName;

    private String professionalMasterOnDuty;

    private String professionalMasterStartTime;

    private String professionalApplicationSubjectUnit;

    private String professionalApplicationSubjectCode;

    private String professionalApplicationSubjectName;

    private String professionalFieldCode;

    private String professionalFieldName;

    /* 申请表部分 */
//    private int tutorId; // 导师工号
    private int applyId; // 申请的类别 id
    private int status; // 此申请的状态

    /* 申请类别表 */
//    private int applyId;  //申请类型id
    private String applyName; // 申请类别名称
    private int subject;  //分科，文科或理科
    private int professional;  //专硕或学硕

    /*状态码表*/
//    private int codeId; //状态码（申请状态）
    private String codeDescribe;    //申请状态码全称
    private String inspectDescribe;     //申请状态码简称
    //负责院系表
    private String organizationName;
}
