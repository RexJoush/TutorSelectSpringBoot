package com.nwu.entity;

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

    private String col1;

    private String col2;

    private String col3;

    private String col4;


}
