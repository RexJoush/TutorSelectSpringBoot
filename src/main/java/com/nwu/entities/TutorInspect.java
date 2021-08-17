package com.nwu.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author dynamic
 * @since 2021-08-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TutorInspect对象", description="")
public class TutorInspect implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "tutor_id", type = IdType.ID_WORKER)
    private String tutorId;

    private String number;
    // 姓名
    private String name;
    // 所在单位
    private Integer organizationId;
    // 性别
    private String gender;
    // 出生年月
    private String birthday;

    private String image;
    // 证件号码
    private String identity;
    // 联系电话
    private String phone;
    // 电子邮箱
    private String email;
    // 最后学位
    private String finalDegree;
    //授予单位及时间
    private String awardingUnitTime;

    private String researchDirections;

    private String academicGroupsJobs;

    private String titlesOfExpert;
    //职称
    private String title;

    private String professionalTitle;
    // 评定时间
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

    private String col1;

    private String col2;

    private String col3;

    private String col4;


}
