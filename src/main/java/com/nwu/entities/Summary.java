package com.nwu.entities;

/**
 * @author Rex Joush
 * @time 2021.08.29 17:31
 */

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 申请表中的总结信息
 */
@Data
@TableName("summary")
public class Summary {

    @TableId(value = "summary_id", type = IdType.AUTO)
    private int summaryId              ; // 论文 id
    private String tutorId             ; // 论文所属教师 id
    private int applyId                ; // 申请类别的id，即此论文申请的类别

    /* 汇总字段 */
    private int firstAuthorPaper       ; // 以第一作者或通讯在 核心及以上期刊发表与本学科发表的论文篇数
    private int authorityAmount        ; // 权威篇数
    private int eiAmount               ; // EI 篇数
    private int cssciAmount            ; // CSSCI 篇数
    private int ssciAmount             ; // SSCI 篇数
    private int directProject          ; // 主持科研项目
    private int projectNationalLevel   ; // 国家级项目
    private int projectProvinceLevel   ; // 省部级项目
    private int accumulatedFunds       ; // 累计科研经费，万元
    private int horizontalProject      ; // 横向项目到款经费，万元
    private int publishWorks           ; // 出版专业领域专著数
    private int publishWorksWords      ; // 本人完成字数
    private int scientificAwards       ; // 科研教学获奖项数
    private int awardsNationalLevel    ; // 国家级奖项
    private int awardsProvinceLevel    ; // 省部级奖项
    private int inventionPatentAmount  ; // 发明专利
    private int newUtilityPatent       ; // 新型实用专利

    public Summary(int firstAuthorPaper, int authorityAmount, int eiAmount, int cssciAmount, int ssciAmount, int directProject, int projectNationalLevel, int projectProvinceLevel, int accumulatedFunds, int horizontalProject, int publishWorks, int publishWorksWords, int scientificAwards, int awardsNationalLevel, int awardsProvinceLevel, int inventionPatentAmount, int newUtilityPatent) {
        this.firstAuthorPaper = firstAuthorPaper;
        this.authorityAmount = authorityAmount;
        this.eiAmount = eiAmount;
        this.cssciAmount = cssciAmount;
        this.ssciAmount = ssciAmount;
        this.directProject = directProject;
        this.projectNationalLevel = projectNationalLevel;
        this.projectProvinceLevel = projectProvinceLevel;
        this.accumulatedFunds = accumulatedFunds;
        this.horizontalProject = horizontalProject;
        this.publishWorks = publishWorks;
        this.publishWorksWords = publishWorksWords;
        this.scientificAwards = scientificAwards;
        this.awardsNationalLevel = awardsNationalLevel;
        this.awardsProvinceLevel = awardsProvinceLevel;
        this.inventionPatentAmount = inventionPatentAmount;
        this.newUtilityPatent = newUtilityPatent;
    }
}
