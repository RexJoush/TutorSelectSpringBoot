package com.nwu.entities.tutor.noInspect;

import com.nwu.entities.tutor.childSubject.researchProject;
import com.nwu.entities.tutor.childSubject.teachingAward;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoSecondPage {

    //免审

    // 申请 id
    private int applyId;

    //主要研究方向
    private String researchDirections;

    //申请学科负责单位
    private String appliedSubjectUnit;

    //一级学科代码
    private String appliedSubjectCode;

    //一级学科名称
    private String appliedSubjectName;

    //免审条件
    private String exemptionConditions;

    //免审条件路径
    private String exemptionConditionsMaterials;

    /* 科研教学情况 */

    //科研项目 存入数据库
    private String researchProjectsJson;

    //科研项目
    private ArrayList<researchProject> researchProjects;

    //科研教学情况 存入数据库
    private String teachingAwardsJson;

    //科研教学情况
    private ArrayList<teachingAward> teachingAwards;

    /* 博导免审 */

    //硕导上岗时间
    private String masterDirectorTime;
    //硕士招生学科
    private String masterDirectorSubject;



}
