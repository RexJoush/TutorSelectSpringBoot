package com.nwu.entities.tutor;

/**
 * @author Rex Joush
 * @time 2021.08.24 16:05
 */

import com.nwu.entities.tutor.childSubject.ExpertTitle;
import com.nwu.entities.tutor.childSubject.GroupsOrPartTimeJob;
import lombok.Data;

import java.util.List;

/**
 * 添加表格的第二页研究信息
 */
@Data
public class SecondPage {

    private int applyId; // 申请 id
    private String applySubject;    // 申请学科
    private String doctoralMasterApplicationSubjectUnit;    // 申请学科负责单位
    private String doctoralMasterSubjectCodeName;   // 一级学科代码 + " " + 名称
    private String doctoralMasterSubjectCode;   // 一级学科代码
    private String doctoralMasterSubjectName;   // 一级学科名称

    //=========博士增岗 非免审============

    //博导在岗学科
    private String doctoralTutorOnDuty;

    //上岗时间
    private String doctoralStartTime;

    // 原单位名称
    private String sourceUnitName;

    //原单位调入时间
    private String transferInTime;

    private String major;           // 主要研究方向的内容及其意义
    private List<GroupsOrPartTimeJob> groupsOrPartTimeJobs;    // 何时参加何种学术团体、任何种职务，有何社会兼职列表
    private String groupsOrPartTimeJobsJson;    // 上一个字段的 json 串 存数据库
    private List<ExpertTitle> expertTitles;    // 获何专家称号及时间列表
    private String expertTitlesJson;    // 获何专家称号及时间列表 json 串

}
