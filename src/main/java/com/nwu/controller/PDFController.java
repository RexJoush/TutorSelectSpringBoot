package com.nwu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nwu.entities.*;
import com.nwu.entities.PdfEntity.PdfTable;
import com.nwu.entities.PdfEntity.PdfTutorInspect;
import com.nwu.entities.tutor.childSubject.GuidingStudent;
import com.nwu.results.Result;
import com.nwu.service.TutorInspectService;
import com.nwu.service.scientificResearchManager.*;
import com.nwu.service.tutor.SummaryService;
import com.nwu.service.tutor.common.FirstService;
import com.nwu.service.tutor.common.GuidingStudentService;
import com.nwu.util.PDFTemplates;
import io.swagger.annotations.ApiOperation;
import net.bytebuddy.implementation.bytecode.Throw;
import org.apache.ibatis.annotations.Param;
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
    TutorInspectService tutorInspectService;
    //学术论文
    @Resource
    AcademicPaperService academicPaperService;
    //论文汇总
    @Resource
    SummaryService summaryService;
    //科研项目
    @Resource
    ResearchProjectService researchProjectService;
    //教材或学术著作
    @Resource
    AcademicWorksService academicWorksService;
    //科研教学奖励
    @Resource
    TeachingAwardsService teachingAwardsService;
    //发明专利
    @Resource
    InventionPatentService inventionPatentService;
    //指导学生
    @Resource
    GuidingStudentService guidingStudentService;

    @ApiOperation("pdf导出")
    @GetMapping("/getPdf/{applyId}/{applyTypeId}")
    public Result pdfCreate(@Param("applyId") Integer applyId, @Param("applyTypeId") Integer applyTypeId) throws Exception {
        applyId = 138;
        applyTypeId = 1;
        System.out.println(applyTypeId);
        //读取资源的路径
        String pdfTemplate = "D:\\RARZIP\\pdfTemplates\\firstDoctorApply.pdf";

        PdfTutorInspect pdfTutorInspect = tutorInspectService.getPdfTutorInspect(applyId);

        HashMap<String, Object> textFields = new HashMap<String, Object>();

        textFields.put("year_now", Calendar.getInstance().get(Calendar.YEAR));//当前年份
        textFields.put("name", pdfTutorInspect.getName());
        textFields.put("tutorId", pdfTutorInspect.getTutorId());
        textFields.put("organizationName", pdfTutorInspect.getOrganizationName());
        textFields.put("gender", pdfTutorInspect.getGender());
        textFields.put("birthday", pdfTutorInspect.getBirthday());
//        textFields.put("image",pdfTutorInspect.getImage());
        textFields.put("identity", pdfTutorInspect.getIdentity());
        textFields.put("phone", pdfTutorInspect.getPhone());
        textFields.put("email", pdfTutorInspect.getEmail());
        textFields.put("finalDegree", pdfTutorInspect.getFinalDegree());
        textFields.put("awardingUnitTime", pdfTutorInspect.getAwardingUnitTime());
        textFields.put("researchDirections", pdfTutorInspect.getResearchDirections());
        textFields.put("academicGroupsJobs", pdfTutorInspect.getAcademicGroupsJobs());
        textFields.put("titlesOfExpert", pdfTutorInspect.getTitlesOfExpert());
        textFields.put("title", pdfTutorInspect.getTitle());
        textFields.put("evaluateTime", pdfTutorInspect.getEvaluateTime());

        //首次专硕，专硕增岗 现任专业技术职位
        textFields.put("professionalTitle", pdfTutorInspect.getProfessionalTitle());

        // 外单位调入填写 专硕增岗 学硕增岗 博导增岗
        textFields.put("sourceUnitName", pdfTutorInspect.getSourceUnitName());
        textFields.put("transferInTime", pdfTutorInspect.getTransferInTime());

        //首次博导
        textFields.put("firstDoctoralFirstTimeTutor", pdfTutorInspect.getFirstDoctoralFirstTimeTutor());
        textFields.put("firstDoctoralFirstDiscipline", pdfTutorInspect.getFirstDoctoralFirstDiscipline());

        //博导增岗
        textFields.put("doctoralTutorOnDuty", pdfTutorInspect.getDoctoralTutorOnDuty());
        textFields.put("doctoralStartTime", pdfTutorInspect.getDoctoralStartTime());

        //学硕增岗
        textFields.put("masterDegreeIncreaseTutorOnDuty", pdfTutorInspect.getMasterDegreeIncreaseTutorOnDuty());
        textFields.put("masterDegreeIncreaseTutorStartTime", pdfTutorInspect.getMasterDegreeIncreaseTutorStartTime());

        /* 博导，学硕的公共部分 */
        textFields.put("doctoralMasterApplicationSubjectUnit", pdfTutorInspect.getDoctoralMasterApplicationSubjectUnit());
        textFields.put("doctoralMasterSubjectCode", pdfTutorInspect.getDoctoralMasterSubjectCode());
        textFields.put("doctoralMasterSubjectName", pdfTutorInspect.getDoctoralMasterSubjectName());

        //专硕增岗
        textFields.put("professionalMasterOnDuty", pdfTutorInspect.getProfessionalMasterOnDuty());
        textFields.put("professionalMasterStartTime", pdfTutorInspect.getProfessionalMasterStartTime());

        //专硕公共部分
        textFields.put("professionalApplicationSubjectUnit", pdfTutorInspect.getProfessionalApplicationSubjectUnit());
        textFields.put("professionalApplicationSubjectCode", pdfTutorInspect.getProfessionalApplicationSubjectCode());
        textFields.put("professionalApplicationSubjectName", pdfTutorInspect.getProfessionalApplicationSubjectName());
        textFields.put("professionalFieldCode", pdfTutorInspect.getProfessionalFieldCode());
        textFields.put("professionalFieldName", pdfTutorInspect.getProfessionalFieldName());

        //图片信息 单独定位
        HashMap<String, Object> imgFields = new HashMap<>();
        if (pdfTutorInspect.getImage() != null) {
            imgFields.put("image", pdfTutorInspect.getImage());
        }

        //=======================科研教学汇总=====================
        QueryWrapper<Summary> wrapper = new QueryWrapper<>();
        wrapper.eq("apply_id",applyId).last("LIMIT 1");
        Summary one = summaryService.getOne(wrapper);
        textFields.put("firstAuthorPaper",one.getFirstAuthorPaper());
        textFields.put("authorityAmount",one.getAuthorityAmount());
        textFields.put("eiAmount",one.getEiAmount());
        textFields.put("cssciAmount",one.getCssciAmount());
        textFields.put("ssciAmount",one.getSsciAmount());
        textFields.put("directProject",one.getDirectProject());
        textFields.put("projectNationalLevel",one.getProjectNationalLevel());
        textFields.put("projectProvinceLevel",one.getProjectProvinceLevel());
        textFields.put("accumulatedFunds",one.getAccumulatedFunds());
        textFields.put("horizontalProject",one.getHorizontalProject());
        textFields.put("publishWorks",one.getPublishWorks());
        textFields.put("publishWorksWords",one.getPublishWorksWords());
        textFields.put("scientificAwards",one.getScientificAwards());
        textFields.put("awardsNationalLevel",one.getAwardsNationalLevel());
        textFields.put("awardsProvinceLevel",one.getAwardsProvinceLevel());
        textFields.put("inventionPatentAmount",one.getInventionPatentAmount());
        textFields.put("newUtilityPatent",one.getNewUtilityPatent());

        //=======================学术论文表格=====================
        // { label: '文史', value: 1 },
        // { label: '理工', value: 2 },
        // { label: '交叉学科', value: 3 }
        PdfTable tableAcademicPaper_lg = new PdfTable();      //理工
        PdfTable tableAcademicPaper_ws = new PdfTable();        //文史
        if (pdfTutorInspect.getSubject() == 2 || pdfTutorInspect.getSubject() == 3) {
            tableAcademicPaper_lg.setColNames("序号,名称,第一\n作者,通讯\n作者,发表时间,期刊名称,期刊类别,分区/\n影响因子");
            tableAcademicPaper_lg.setColFields("id,paperName,firstAuthorName,communicationAuthorName,paperPublicationTime,journalName,journalCategory,sciPart");
            //根据主键id去查询论文表
            QueryWrapper<AcademicPaper> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("apply_id", applyId);
            List<AcademicPaper> academicPaperList = academicPaperService.list(queryWrapper);
            ArrayList<Map<String, Object>> academicPaperPdfList = new ArrayList<>();
            for (int i = 0; i < academicPaperList.size(); i++) {
                HashMap<String, Object> row = new HashMap<String, Object>();
                row.put("id", i + 1);
                row.put("paperName", academicPaperList.get(i).getPaperName());
                row.put("firstAuthorName", academicPaperList.get(i).getFirstAuthorName());
                row.put("communicationAuthorName", academicPaperList.get(i).getCommunicationAuthorName());
                row.put("paperPublicationTime", academicPaperList.get(i).getPaperPublicationTime());
                row.put("journalName", academicPaperList.get(i).getJournalName());
                row.put("journalCategory", academicPaperList.get(i).getJournalCategory());
                if (academicPaperList.get(i).getSciPart() != null && String.valueOf(academicPaperList.get(i).getImpactFactors()) != null) {
                    row.put("sciPart", academicPaperList.get(i).getSciPart() + academicPaperList.get(i).getImpactFactors());
                } else if (String.valueOf(academicPaperList.get(i).getImpactFactors()) == null) {
                    row.put("sciPart", academicPaperList.get(i).getImpactFactors());
                } else {
                    row.put("sciPart", academicPaperList.get(i).getSciPart());
                }
                academicPaperPdfList.add(row);
            }
            //存到对象中 pdf
            tableAcademicPaper_lg.setDataList(academicPaperPdfList);
        } else {
            //文科类 比之前少一个
            tableAcademicPaper_ws.setColNames("序号,论文名称,第一作者,发表时间,期刊名称,期刊等级");
            tableAcademicPaper_ws.setColFields("id,paperName,firstAuthorName,paperPublicationTime,journalName,journalLevel");
            ArrayList<Map<String, Object>> academicPaperPdfList = new ArrayList<>();
            QueryWrapper<AcademicPaper> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("apply_id", applyId);
            List<AcademicPaper> academicPaperList = academicPaperService.list(queryWrapper);    //从数据库中查询出论文
            for (int i = 0; i < academicPaperList.size(); i++) {
                HashMap<String, Object> map = new HashMap<>();
                map.put("id", i + 1);
                map.put("paperName", academicPaperList.get(i).getPaperName());
                map.put("firstAuthorName", academicPaperList.get(i).getFirstAuthorName());
                map.put("paperPublicationTime", academicPaperList.get(i).getPaperPublicationTime());
                map.put("journalName", academicPaperList.get(i).getJournalName());
                map.put("journalLevel", academicPaperList.get(i).getJournalLevel());
                academicPaperPdfList.add(map);
            }
            tableAcademicPaper_ws.setDataList(academicPaperPdfList);
        }

        //=================科研项目=============9
        PdfTable tableResearchProject = new PdfTable();
        tableResearchProject.setColNames("序号,名称,批准号,负责人,开始时间,结题时间,项目级别,项目分类,总经费/\n（万元）");
        tableResearchProject.setColFields("id,projectName,projectNumber,projectChargeName,projectStartTime,projectEndTime,projectLevel,projectCategory,projectTotalPrice");
        //从数据库中查询出论文
        QueryWrapper<ResearchProject> RPqueryWrapper = new QueryWrapper<>();
        RPqueryWrapper.eq("apply_id", applyId);
        List<ResearchProject> researchProjectList = researchProjectService.list(RPqueryWrapper);
        ArrayList<Map<String, Object>> researchProjectPdfList = new ArrayList<>();
        //遍历科研项目
        for (int i =0; i< researchProjectList.size(); i++){
            HashMap<String, Object> map = new HashMap<>();
            map.put("id",i+1);
            map.put("projectName",researchProjectList.get(i).getProjectName());
            map.put("projectNumber",researchProjectList.get(i).getProjectNumber());
            map.put("projectChargeName",researchProjectList.get(i).getProjectChargeName());
            map.put("projectStartTime",researchProjectList.get(i).getProjectStartTime());
            map.put("projectEndTime",researchProjectList.get(i).getProjectEndTime());
            map.put("projectLevel",researchProjectList.get(i).getProjectLevel());
            map.put("projectCategory",researchProjectList.get(i).getProjectCategory());
            map.put("projectTotalPrice",researchProjectList.get(i).getProjectTotalPrice());
            researchProjectPdfList.add(map);
        }
        tableResearchProject.setDataList(researchProjectPdfList);   //设置到实体类中

        //=================教材或学术著作AcademicWorks=============7
        PdfTable tableAcademicWorks = new PdfTable();
        tableAcademicWorks.setColNames("序号,名称,编号,出版时间,出版单位,作者姓名,完成字数（万字）");
        tableAcademicWorks.setColFields("id,worksName,worksNumber,worksPublicationTime,worksPublicationUnit,authorName,totalWords");
        //设置datalist
        QueryWrapper<AcademicWorks> awQueryWrapper = new QueryWrapper<>();
        awQueryWrapper.eq("apply_id",applyId);
        List<AcademicWorks> academicWorkList = academicWorksService.list(awQueryWrapper);
        //声明一个arrayList数组 用于放入DataList数组中
        ArrayList<Map<String,Object>> academicWorkPdfList = new ArrayList<>();
        for (int i =0 ; i < academicWorkList.size() ; i++){
            HashMap<String, Object> map = new HashMap<>();
            map.put("id",i+1);
            map.put("worksName",academicWorkList.get(i).getWorksName());
            map.put("worksNumber",academicWorkList.get(i).getWorksNumber());
            map.put("worksPublicationTime",academicWorkList.get(i).getWorksPublicationTime());
            map.put("worksPublicationUnit",academicWorkList.get(i).getWorksPublicationUnit());
            map.put("authorName",academicWorkList.get(i).getAuthorName());
            map.put("totalWords",academicWorkList.get(i).getTotalWords());
            academicWorkPdfList.add(map);
        }
        tableAcademicWorks.setDataList(academicWorkPdfList);

        //=================科研教学奖励============================ 7=7
        PdfTable tableTeachingAwards = new PdfTable();
        tableTeachingAwards.setColNames("序号,名称,排名,颁奖单位,获奖级别,获奖人姓名,获奖时间");
        tableTeachingAwards.setColFields("id,awardsName,awardsRank,awardsUnit,awardsLevel,awardsAuthorName,awardsTime");
        QueryWrapper<TeachingAwards> taQueryWrapper = new QueryWrapper<>();
        taQueryWrapper.eq("apply_id",applyId);
        List<TeachingAwards> teachingAwardsList = teachingAwardsService.list(taQueryWrapper);
        //声明一个arrayList数组 用于放入DataList数组中
        ArrayList<Map<String,Object>> teachingAwardsPdfList = new ArrayList<>();
        for (int i =0; i<teachingAwardsList.size(); i++){
            HashMap<String, Object> map = new HashMap<>();
            map.put("id",i+1);
            map.put("awardsName",teachingAwardsList.get(i).getAwardsName());
            map.put("awardsRank",teachingAwardsList.get(i).getAwardsRank());
            map.put("awardsUnit",teachingAwardsList.get(i).getAwardsUnit());
            map.put("awardsLevel",teachingAwardsList.get(i).getAwardsLevel());
            map.put("awardsAuthorName",teachingAwardsList.get(i).getAwardsAuthorName());
            map.put("awardsTime",teachingAwardsList.get(i).getAwardsTime());
            teachingAwardsPdfList.add(map);
        }
        tableTeachingAwards.setDataList(teachingAwardsPdfList);

        //====================发明专利================= 6
        PdfTable tableInventionPatent = new PdfTable();
        tableInventionPatent.setColNames("序号,专利名称,作者,授权（颁证）时间,专利授权号,专利类型");
        tableInventionPatent.setColFields("id,patentName,patentAuthorName,patentGrantTime,patentGrantNumber,patentType");
        QueryWrapper<InventionPatent> ipQueryWrapper = new QueryWrapper<>();
        ipQueryWrapper.eq("apply_id",applyId);
        List<InventionPatent> inventionPatentList = inventionPatentService.list(ipQueryWrapper);
        //声明一个arrayList数组 用于放入DataList数组中
        ArrayList<Map<String,Object>> inventionPatentPdfList = new ArrayList<>();
        for (int i =0; i<inventionPatentList.size(); i++){
            HashMap<String, Object> map = new HashMap<>();
            map.put("id",i+1);
            map.put("patentName",inventionPatentList.get(i).getPatentName());
            map.put("patentAuthorName",inventionPatentList.get(i).getPatentAuthorName());
            map.put("patentGrantTime",inventionPatentList.get(i).getPatentGrantTime());
            map.put("patentGrantNumber",inventionPatentList.get(i).getPatentGrantNumber());
            map.put("patentType",inventionPatentList.get(i).getPatentType());
            inventionPatentPdfList.add(map);
        }
        tableInventionPatent.setDataList(inventionPatentPdfList);

        //=====================指导博士/硕士/学士==================
        //首次博士：协助指导博士 指导硕士
        //博士增岗：指导博士 指导硕士
        //首次硕士：协助指导硕士 指导本科
        //学硕增岗：指导硕士
        //专硕增岗：指导硕士

        //指导博士
        PdfTable tableGuidingDoctor =new PdfTable();
        tableGuidingDoctor.setColNames("学生姓名,论文题目,入学时间,是否获得学位");
        tableGuidingDoctor.setColFields("studentName,degreePaperTitle,studentEntryTime,isGainDegree");
        //协助指导博士
        PdfTable tableHelpGuidingDoctor = new PdfTable();
        tableHelpGuidingDoctor.setColNames("学生姓名,论文题目,入学时间,指导教师,是否获得学位");
        tableHelpGuidingDoctor.setColFields("studentName,degreePaperTitle,studentEntryTime,tutorName,isGainDegree");
        //指导硕士   首次博士   博士增岗  学硕增列
        PdfTable tableGuidingMaster = new PdfTable();
        tableGuidingMaster.setColNames("学生姓名,论文题目,入学时间,是否获得学位");
        tableGuidingMaster.setColFields("studentName,degreePaperTitle,studentEntryTime,isGainDegree");
        //协助指导硕士                    首次硕士
        PdfTable tableHelpGuidingMaster = new PdfTable();
        tableHelpGuidingMaster.setColNames("学生姓名,论文题目,入学时间,指导教师,是否获得学位");
        tableHelpGuidingMaster.setColNames("studentName,degreePaperTitle,studentEntryTime,tutorName,isGainDegree");
        //指导本科                      （仅首次申请硕导填写）
        PdfTable tableGuidingBachelor = new PdfTable();
        tableGuidingBachelor.setColNames("学生姓名,毕业时间,毕业设计题目");
        tableGuidingBachelor.setColFields("studentName,graduateTime,degreePaperTitle");

        QueryWrapper<GuidingStudent> gsQueryWrapper = new QueryWrapper<>();
        gsQueryWrapper.eq("apply_id",applyId);
        List<GuidingStudent> guidingStudentList = guidingStudentService.list(gsQueryWrapper);
        for (int i = 0;i < guidingStudentList.size();i++){
            if (guidingStudentList.get(i).getStudentType() == "博士"){

            }
            else if (guidingStudentList.get(i).getStudentType() == "硕士"){

            }
            else{//本科

            }
        }

        //声明一个arrayList数组 用于放入DataList数组中
        ArrayList<Map<String,Object>> inventionPatentPdfList = new ArrayList<>();


        //创建表格内table所需字段
        HashMap<String, PdfTable> tableFields = new HashMap<>();
        tableFields.put("tableAcademicPaper_lg", tableAcademicPaper_lg); //理工 交叉
        tableFields.put("tableAcademicPaper_ws", tableAcademicPaper_ws); //文史


        try {
            File inFile = new File(pdfTemplate);
            if (inFile.exists()) {
                InputStream stream = new FileInputStream(inFile);
                stream.close();
            } else {
                System.out.println("模板资源不存在");
            }
//            InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(pdfTemplate);
//            if (stream == null){
//                throw new Exception("模板资源不存在");
//            }
            //创建pdf生成路径
            String path = "D:\\RARZIP\\PDF\\20133220.pdf";
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            new PDFTemplates(pdfTemplate).export(fileOutputStream, textFields, tableFields, imgFields);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return Result.SUCCESS();
    }
}
