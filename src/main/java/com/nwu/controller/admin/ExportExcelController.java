package com.nwu.controller.admin;

import com.nwu.service.admin.impl.ExportExcelServiceImpl;
import com.nwu.service.impl.TutorInspectServiceImpl;
import com.nwu.util.exportExcel.DeliberationExportExcel;
import com.nwu.util.exportExcel.QualificationExamExportExcel;
import com.nwu.util.exportExcel.RecommendExportExcel;
import com.nwu.vo.QueryDepartmentSecretaryInit;
import com.nwu.vo.TutorQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/*
*  导出excel
*/

@RestController
@RequestMapping("/admin/export")
public class ExportExcelController {

    @Resource
    private ExportExcelServiceImpl exportExcelService;

    @Resource
    private TutorInspectServiceImpl tutorInspectService;

    /**
     * 院系秘书导出同意上分会数据
     * @param response
     * @param tutorQuery 封装对象
     * @throws IOException
     */
    @PostMapping("/sfh")
    public void exportSFH(HttpServletResponse response, @RequestBody TutorQuery tutorQuery) throws IOException {
        //TODO 用户保存excel路径，前端需传 学校名、部门名、符合条件的状态码（一个或多个）
        System.out.println(tutorQuery);
        //1.查询数据
        List<QueryDepartmentSecretaryInit> list = tutorInspectService.getTutorInitOrSearch(tutorQuery.getOrganization(), tutorQuery.getApplyStatuss(), 1, tutorQuery, 1);
        System.out.println(list);
        //2.输出Excel
        //TODO 判断导出是否成功，返回值

        try {
            new RecommendExportExcel(response, "西北大学", "网数中心", list).execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 院系秘书导出同意上学院分会数据
     * @param response
     * @param tutorQuery 封装对象
     * @throws IOException
     */

    @PostMapping("/sxyfh")
    public void exportSXYFH(HttpServletResponse response,@RequestBody TutorQuery tutorQuery) throws IOException {
        //TODO 用户保存excel路径，前端需传 部门名、符合条件的状态码（一个或多个）
        //1.查询数据
        List<QueryDepartmentSecretaryInit> list = tutorInspectService.getTutorInitOrSearch(tutorQuery.getOrganization(), tutorQuery.getApplyStatuss(),1, tutorQuery, 1);
        //2.输出Excel
        //TODO 判断导出是否成功，返回值

        try {
            new DeliberationExportExcel(response, "西北大学", "网数中心", list).execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return;
    }

    /**
     * 研究生院导出excel
     * @param response
     * @param tutorQuery 封装对象
     * @throws IOException
     */
    @GetMapping("/qualification")
    public void qualificationExportExcel(HttpServletResponse response,TutorQuery tutorQuery) throws IOException{
        List<QueryDepartmentSecretaryInit> list = exportExcelService.getTutorByQuery(tutorQuery);
        try {
            new QualificationExamExportExcel(response,"西北大学",list).execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return;
    }

}
