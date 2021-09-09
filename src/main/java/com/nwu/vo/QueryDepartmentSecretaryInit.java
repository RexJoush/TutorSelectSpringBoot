package com.nwu.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class QueryDepartmentSecretaryInit implements Serializable {
    private static final long serialVersionUID = 1L;

    //导师非免审申请表
    private String applyId;  //申请表的id

    private String tutorId;  //教师id

    private String number;  //教师工号

    private String name; //姓名

    private Integer organizationId; //所在单位id

    private String gender; //性别

    private String birthday; //出生年月

    private String image; //照片路径

    private String identity;  //证件号码

    private String phone; //电话

    private String email; //邮箱

    private String finalDegree; //最后学位

    private String awardingUnitTime;  //授予单位及时间

    private String researchDirections; //主要研究方向的内容及其意义

    private String academicGroupsJobs; //何时参加何种学术 团体、任何种职务有何社会兼职

    private String titlesOfExpert; //获何专家称号及时间
    //职称
    private String title; // 职称

    private String professionalTitle; // 现任专业技术职位，首次专硕，专硕增岗
    // 评定时间
    private String evaluateTime; //评定时间

    /* 外单位调入填写 */

    private String sourceUnitName; //原单位名称

    private String transferInTime; //调入时间

    /* 博导增岗 */

    private String doctoralTutorOnDuty; //博导在岗学科

    private String doctoralStartTime; //上岗时间

    /* 首次博导 */
    private String firstDoctoralFirstTimeTutor; // 任硕导时间

    private String firstDoctoralFirstDiscipline; // 任硕导一级学科

    /* 首次学硕 */

    /* 学硕增岗 */
    private String masterDegreeIncreaseTutorOnDuty;//硕导在岗学科

    private String masterDegreeIncreaseTutorStartTime;//上岗时间

    /* 博导，学硕的公共部分 */

    private String doctoralMasterApplicationSubjectUnit; //申请学科负责单位

    private String doctoralMasterSubjectCode;//一级学科代码

    private String doctoralMasterSubjectName;//一级学科名称

    /* 首次专硕 */

    /* 专硕增岗 */

    private String professionalMasterOnDuty;//硕导在岗类别

    private String professionalMasterStartTime;//上岗时间

    /* 专硕的公共部分 */

    private String professionalApplicationSubjectUnit; //申请类别负责单位

    private String professionalApplicationSubjectCode; //类别代码

    private String professionalApplicationSubjectName; //类别名称

    private String professionalFieldCode; //领域代码

    private String professionalFieldName; // 领域名称


    /* 申请表部分 */

    //  private int tutorId; // 导师工号
    private int applyTypeId; // 申请的类别 id
    private int status; // 此申请的状态
    private String commit; //秘书初审的备注
    private String commitYxSfh; //院系秘书提交分会的备注
    private String commitYxXy; //院系秘书提交分会意见页面的备注

    /* 申请类别表 */
//  private int applyTypeId;  //申请类型id
    private String applyName; // 申请类别名称
    private int subject;  //分科，文科或理科
    private int professional;  //专硕或学硕

    /*状态码表*/
//  private int codeId; //状态码（申请状态）
    private String codeDescribe;    //申请状态码全称
    private String inspectDescribe;     //申请状态码简称

    //负责院系表
    private String organizationName;  //院系名称

    private  String commitYjsyCs;  // 研究生院管理员初审的备注
    private  String commitYjsySfh; //研究生院管理员提交分会页面的备注
    private  String commitYjsyLr; //研究生院管理员录入分会意见页面的备注
}
