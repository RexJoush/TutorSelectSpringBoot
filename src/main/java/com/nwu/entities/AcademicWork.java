package com.nwu.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="AcademicWork对象",description = "")
public class AcademicWork implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "works_id", type = IdType.ID_WORKER)
    private String works_id;

    private String tutor_id;
    private String apply_id;
    private String works_name;
    private String works_number;
    private String works_rank;
    private String works_publication_time;
    private String works_publication_unit;
    private String total_words;
    private String author_name;
    private String works_source;
    private String works_prove_materials;
    private String col1;
    private String col2;
    private String col3;


}
