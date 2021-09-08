package com.nwu.entities.tutor.noInspect;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.util.pattern.PathPattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecondPage {

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

    //科研教学情况
    private String researchTeachingSituations;

    //==============博导免审=============
    //硕导上岗时间
    private String masterDirectorTime;
    //硕士招生学科
    private String masterDirectorSubject;

}
