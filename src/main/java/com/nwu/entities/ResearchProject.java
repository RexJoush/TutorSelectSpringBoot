package com.nwu.entities;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Anna
 * @since 2021-08-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="ResearchProject对象", description="")
public class ResearchProject implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "project_id", type = IdType.ID_WORKER)
    private Integer projectId;

    private String tutorId;

    private Integer applyId;

    private String projectName;

    private String projectNumber;

    private String approvalNumber;

    private String projectRank;

    private String projectStartTime;

    private String projectEndTime;

    private String projectSourceUnit;

    private BigDecimal projectTotalPrice;

    private String projectLevel;

    private String projectCategory;

    private String projectChargeName;

    private String projectChargeNumber;

    private String projectSubject;

    private String projectSource;

    private String projectProveMaterials;

    private String col1;

    private String col2;

    private String col3;

    private String col4;


}
