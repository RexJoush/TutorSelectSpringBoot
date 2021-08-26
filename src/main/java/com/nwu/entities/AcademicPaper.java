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
@ApiModel(value = "AcademicPaper对象", description = "")
public class AcademicPaper implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "paper_id", type = IdType.ID_WORKER)
    private int paperId;

    private int tutor_id;
    private int apply_id;
    private int paper_name;
    private int paper_number;
    private int paper_rank;
    private int paper_publication_time;
    private int journal_name;
    private int journal_level;
    private int journal_category;
    private int sci_part;
    private int impact_factors;
    private int author_name;
    private int first_author_name;
    private int communication_author_name;
    private int communication_author_number;
    private int paper_subject;
    private int paper_source;
    private int paper_prove_materials;
    private int col1;
    private int col2;
    private int col3;
    private int col4;








}
