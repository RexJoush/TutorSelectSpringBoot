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
@ApiModel(value="TeachingAwards对象", description="")
public class TeachingAwards implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "awards_id", type = IdType.ID_WORKER)
    private Integer awardsId;

    private String tutorId;

    private Integer applyId;

    private String awardsName;

    private String awardsRank;

    private String awardsUnit;

    private String awardsClass;

    private String awardsLevel;

    private String awardsTime;

    private String awardsAuthorName;

    private String awardsAuthorNumber;

    private String awardsSource;

    private String awardsProveMaterials;

    private String col1;

    private String col2;

    private String col3;

    private String col4;


}
