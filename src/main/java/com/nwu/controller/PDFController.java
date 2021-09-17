package com.nwu.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nwu.entities.*;
import com.nwu.entities.PdfEntity.PdfTable;
import com.nwu.entities.PdfEntity.PdfTutorInspect;
import com.nwu.entities.tutor.childSubject.CourseTeaching;
import com.nwu.entities.tutor.childSubject.ExpertTitle;
import com.nwu.entities.tutor.childSubject.GroupsOrPartTimeJob;
import com.nwu.entities.tutor.childSubject.GuidingStudent;
import com.nwu.results.Result;
import com.nwu.results.ResultCode;
import com.nwu.service.PdfInspectService;
import com.nwu.service.PdfNoInspectService;
import com.nwu.service.TutorInspectService;
import com.nwu.service.scientificResearchManager.*;
import com.nwu.service.tutor.SummaryService;
import com.nwu.service.tutor.common.CourseTeachingService;
import com.nwu.service.tutor.common.GuidingStudentService;
import com.nwu.util.PDFTemplates;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.*;

@RestController
@RequestMapping("/tutor")
public class PDFController {
    public static String tutorId = "20133220";

    @Resource
    PdfInspectService pdfInspectService;
    @Resource
    PdfNoInspectService pdfNoInspectService;

    @ApiOperation("pdf导出")
    @GetMapping("/getPdf/{applyId}/{applyTypeId}")
    public Result pdfCreate(@Param("applyId") Integer applyId, @Param("applyTypeId") Integer applyTypeId) throws Exception {
        applyId = 138;
        applyTypeId = 1;
        System.out.println(applyTypeId);
        if (applyId ==null && applyTypeId == null){
            return Result.FAIL();
        }
        //根据不同的申请类别读取不同的pdf资源文件
        String pdfTemplate = "";
        //开发版
        switch (applyTypeId){
            case 1: pdfTemplate = "pdfTemplates/firstApplyDoctor.pdf"; break;
            case 2: pdfTemplate = "pdfTemplates/addApplyDoctor.pdf"; break;
            case 3: pdfTemplate = "pdfTemplates/noInspectApplyDoctor.pdf"; break;
            case 4: pdfTemplate = "pdfTemplates/firstApplyMaster.pdf"; break;
            case 5: pdfTemplate = "pdfTemplates/addApplyMaster.pdf"; break;
            case 6: pdfTemplate = "pdfTemplates/noInspectApplyMaster.pdf"; break;
            case 7: pdfTemplate = "pdfTemplates/firstApplyProfessional.pdf"; break;
            case 8: pdfTemplate = "pdfTemplates/addApplyProfessional.pdf"; break;
        }
        String pdfPath = "";
        if (applyTypeId == 1 || applyTypeId ==2 || applyTypeId == 4 || applyTypeId ==5 || applyTypeId == 7 || applyTypeId == 8){
            //非免审
            pdfPath = pdfInspectService.getTutorInspectPdf(applyId, applyTypeId, pdfTemplate);
        }
        else
        {
            //免审
            pdfPath = pdfNoInspectService.getTutorNoInspect(applyId,applyTypeId,pdfTemplate);
        }
        return new Result(ResultCode.SUCCESS,pdfPath);


//       linux版本
//       InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(pdfTemplate);

    }
}
