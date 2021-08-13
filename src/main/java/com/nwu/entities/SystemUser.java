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
 * @since 2021-08-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SystemUser对象", description="")
public class SystemUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "tutor表对应id")
    private Integer tutorId;

    @ApiModelProperty(value = "学工号")
    private Integer number;

    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "用户状态 0 禁用；1启用")
    private Integer status;

    @ApiModelProperty(value = "系统用户创建时间")
    private String createTime;

    @ApiModelProperty(value = "系统用户院系名称")
    private String organization;


}
