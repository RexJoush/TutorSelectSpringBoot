package com.nwu.controller.admin;

import com.nwu.service.admin.impl.ExportExcelServiceImpl;
import com.nwu.util.exportExcel.DeliberationExportExcel;
import com.nwu.util.exportExcel.RecommendExportExcel;
import com.nwu.vo.QueryDepartmentSecretaryInit;
import com.nwu.vo.TutorQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/*
*  导出excel
*/

@RestController
@RequestMapping("/export")
public class ExportExcelController {

    @Resource
    private ExportExcelServiceImpl exportExcelService;

    /**
     * 院系秘书导出同意上分会数据
     * @param response
     * @param tutorQuery 封装对象
     * @throws IOException
     */
    @GetMapping("/sfh")
    public void exportSFH(HttpServletResponse response, TutorQuery tutorQuery) throws IOException {
        //TODO 用户保存excel路径，前端需传 学校名、部门名、符合条件的状态码（一个或多个）
        //1.查询数据
        List<QueryDepartmentSecretaryInit> list = exportExcelService.getTutorByQuery(tutorQuery);
        //2.输出Excel
        //TODO 判断导出是否成功，返回值

        try {
            new RecommendExportExcel(response, "西北大学", "网数中心", list).execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return;
    }

    /**
     * 院系秘书导出同意上学院分会数据
     * @param response
     * @param tutorQuery 封装对象
     * @throws IOException
     */

    @GetMapping("/sxyfh")
    public void exportSXYFH(HttpServletResponse response, TutorQuery tutorQuery) throws IOException {
        //TODO 用户保存excel路径，前端需传 学校名、部门名、符合条件的状态码（一个或多个）
        //1.查询数据
        List<QueryDepartmentSecretaryInit> list = exportExcelService.getTutorByQuery(tutorQuery);
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
}
