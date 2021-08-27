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
 * @since 2021-08-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="AcademicPaper对象", description="")
public class AcademicPaper implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "论文的唯一标识")
      @TableId(value = "paper_id", type = IdType.ID_WORKER)
    private Integer paperId;

    @ApiModelProperty(value = "教师工号")
    private String tutorId;

    @ApiModelProperty(value = "老师的哪项申请")
    private Integer applyId;

    private String paperName;

    private String paperNumber;

    private String paperRank;

    private String paperPublicationTime;

    private String journalName;

    private String journalLevel;

    private String journalCategory;

    private String sciPart;

    private BigDecimal impactFactors;

    private String authorName;

    private String firstAuthorName;

    private String communicationAuthorName;

    private String communicationAuthorNumber;

    private String paperSubject;

    private String paperSource;

    @ApiModelProperty(value = "证明材料，图片，pdf等   地址")
    private String paperProveMaterials;

    private String col1;

    private String col2;

    private String col3;

    private String col4;


}
