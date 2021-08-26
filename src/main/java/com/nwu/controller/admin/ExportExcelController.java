package com.nwu.controller.admin;

import com.nwu.results.Result;
import com.nwu.service.admin.impl.ExportExcelServiceImpl;
import com.nwu.util.RecommendExportExcel;
import com.nwu.vo.QueryDepartmentSecretaryInit;
import com.nwu.vo.TutorQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/*
*  管理员后端excel导出控制层
*/

@RestController
@RequestMapping("/export")
public class ExportExcelController {

    @Resource
    private ExportExcelServiceImpl exportExcelService;

    @GetMapping("/sfh")
    public Result exportSFH(HttpServletResponse response, TutorQuery tutorQuery) {
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

        return Result.SUCCESS();
    }
}
