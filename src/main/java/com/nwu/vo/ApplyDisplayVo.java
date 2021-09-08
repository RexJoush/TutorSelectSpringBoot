package com.nwu.vo;

/**
 * @author Rex Joush
 * @time 2021.09.03 15:45
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 我的申请展示页面的实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplyDisplayVo implements Serializable {

    private int applyId;            // 申请表的 id
    private int applyTypeId;        // 申请的类型 id
    private int status;             // 当前的状态 id
    private String applyName;       // 申请类型
    private String statusDisplay;   // 当前状态
    private String commit;          // 评论

    private boolean isNoInspect;    // 是否为免审申请

    private String applyDepartment; // 申请学科所在学院的展示
    private String applySubject;    // 申请学科的展示

    /* 博导，学硕的公共部分 */
    private String doctoralMasterApplicationSubjectUnit;    // 申请学科负责单位
    private String doctoralMasterSubjectCode;               // 一级学科代码
    private String doctoralMasterSubjectName;               // 一级学科名称

    /* 专硕的公共部分 */
    private String professionalApplicationSubjectUnit;      // 申请类别负责单位
    private String professionalApplicationSubjectCode;      // 类别代码
    private String professionalApplicationSubjectName;      // 类别名称
    private String professionalFieldCode;                   // 领域代码
    private String professionalFieldName;                   // 领域名称

    /* 免审表的信息 */
    private String appliedSubjectUnit;     // 申请学科_申请学科负责单位
    private String appliedSubjectCode;     // 申请学科_一级学科代码
    private String appliedSubjectName;     // 申请学科_一级学科名称

}
