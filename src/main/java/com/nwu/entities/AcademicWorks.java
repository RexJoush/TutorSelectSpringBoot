package com.nwu.entities;

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
@ApiModel(value="AcademicWorks对象", description="")
public class AcademicWorks implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "works_id", type = IdType.ID_WORKER)
    private Integer worksId;

    @ApiModelProperty(value = "apply表中的user_id  教师工号")
    private String tutorId;

    private Integer applyId;

    private String worksName;

    private String worksNumber;

    private String worksRank;

    private String worksPublicationTime;

    private String worksPublicationUnit;

    private String totalWords;

    private String authorName;

    private String worksSource;

    private String worksProveMaterials;

    private String col1;

    private String col2;

    private String col3;

    private String col4;


}
