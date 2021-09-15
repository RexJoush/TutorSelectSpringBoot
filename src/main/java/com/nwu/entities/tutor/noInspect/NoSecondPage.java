package com.nwu.entities.tutor.noInspect;

import com.nwu.entities.tutor.childSubject.ResearchProject;
import com.nwu.entities.tutor.childSubject.TeachingAward;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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

    //一级学科代码及名称 辅助字段
    private String doctoralMasterSubjectCodeName;

    //免审条件
    private String exemptionConditions;

    //免审条件路径
    private String exemptionConditionsMaterials;

    //申请类别 文史 理工 交叉
    private String applySubject;

    /* 科研教学情况 */

    //科研项目 存入数据库
    private String researchProjectsJson;

    //科研项目 辅助字段
    private List<ResearchProject> researchProjects;

    //科研教学情况 存入数据库
    private String teachingAwardsJson;

    //科研教学情况 辅助字段
    private List<TeachingAward> teachingAwards;

    /* 博导免审 */

    //硕导上岗时间
    private String masterDirectorTime;
    //硕士招生学科
    private String masterDirectorSubject;



}
