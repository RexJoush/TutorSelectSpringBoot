package com.nwu.util.exportExcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.alibaba.excel.write.style.column.SimpleColumnWidthStyleStrategy;
import com.google.common.collect.Lists;
import com.nwu.vo.QueryDepartmentSecretaryInit;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @program: TutorSelectSpringBoot
 * @description: 上岗资格审核表
 * @author: dynamic
 * @create: 2021-09-04 10:32
 **/

public class QualificationExamExportExcel {
    private List<QueryDepartmentSecretaryInit> originList;
    private HorizontalCellStyleStrategy horizontalCellStyleStrategy;
    private List<List<Object>> contentList = Lists.newArrayList();
    private HttpServletResponse response;
    private String schoolName;
    private String departmentName;
    private List<List<String>> headData;
    private String year;

    /**
     *构造函数
     * @param response 请求头
     * @param schoolName 学校名字
     * @param originList 原始数据
     */
    public QualificationExamExportExcel(HttpServletResponse response,
                                String schoolName,
                                List<QueryDepartmentSecretaryInit> originList) {
        //1、生成年份
        Calendar instance = Calendar.getInstance();
        this.year = instance.get(Calendar.YEAR) + "";
        this.response = response;
        this.schoolName = schoolName;
        this.originList = originList;
    }

    /**
     * 执行函数，写入excel
     * @throws IOException
     */

    public void execute() throws IOException {

        this.setHead(this.schoolName);
        this.setResponse();
        this.exchangeData(this.originList);
        this.tableStyle();
        EasyExcel.write(response.getOutputStream())
                .head(this.headData).autoCloseStream(Boolean.FALSE)
                .registerWriteHandler(this.horizontalCellStyleStrategy)
                .registerWriteHandler(new SimpleColumnWidthStyleStrategy(18))
                .sheet().doWrite(contentList);
    }

    /**
     * 浏览器默认下载位置
     * @throws UnsupportedEncodingException
     */
    private void setResponse() throws UnsupportedEncodingException {

        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");

        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String name = this.schoolName + this.year + "年" + this.departmentName + "学位评定分委员会推荐汇总表";
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(name, "UTF-8") + ".xlsx");

    }


    /**
     * 创建表头
     * @param schoolName 学校名称
     */
    private void setHead(String schoolName) {

        //2、构造表头
        List<List<String>> headTitles = Lists.newArrayList();
        String firstRow = schoolName + this.year + "年"  + "上岗资格审核汇总表";
        String secondRow = "（首次上岗研究生导师/增列学科岗位认定）";
        //前7列
        ArrayList<String> sevenCol = Lists.newArrayList("序号", "所在单位", "姓名", "申请学科类别或代码", "职称", "最后学位","科研情况","著作、奖项或专利", "导师上岗类别","备注");
        sevenCol.forEach(title -> {
            headTitles.add(Lists.newArrayList(firstRow, secondRow, title, title, title));
        });
        this.headData = headTitles;
    }

    /**
     * 将数据库查出的符合前端规则的数据，转换成Excel表格的数据格式
     * @param list 数据库查出符合的数据列表
     */
    public void exchangeData(List<QueryDepartmentSecretaryInit> list) {
        int i = 1;
        for (QueryDepartmentSecretaryInit queryDepartmentSecretaryInit : list) {
            this.contentList.add(
                    Lists.newArrayList(
                            String.valueOf(i++),  //序号
                            queryDepartmentSecretaryInit.getOrganizationName(),//所在单位
                            queryDepartmentSecretaryInit.getName(),  //姓名
                            queryDepartmentSecretaryInit.getProfessional(), //申请学科或类别及代码
                            queryDepartmentSecretaryInit.getTitle(), //职称
                            queryDepartmentSecretaryInit.getFinalDegree(), //最后学位
                            queryDepartmentSecretaryInit.getResearchDirections(),//科研情况
                            queryDepartmentSecretaryInit.getAcademicGroupsJobs(),//著作、奖项或专利
                            queryDepartmentSecretaryInit.getApplyName(),//导师上岗类别
                            queryDepartmentSecretaryInit.getCommit()//备注
                    )
            );
        }
    }

    /**
     * 表的格式定义
     */
    private void tableStyle() {
        WriteCellStyle headWriteCellStyle = new WriteCellStyle();
        //背景
        headWriteCellStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        WriteFont headWriteFont = new WriteFont();
        headWriteFont.setFontHeightInPoints((short) 12);
        headWriteCellStyle.setWriteFont(headWriteFont);

        //设置内容策略
        WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
        // 设置自动换行
        contentWriteCellStyle.setWrapped(true);
        //设置 垂直居中
        contentWriteCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
//        //设置 水平居中
        contentWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);
        // 设置底边框;
        contentWriteCellStyle.setBorderBottom(BorderStyle.THIN);
        // 设置底边框颜色;
        contentWriteCellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        // 设置左边框;
        contentWriteCellStyle.setBorderLeft(BorderStyle.THIN);
        // 设置左边框颜色;
        contentWriteCellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        // 设置右边框;
        contentWriteCellStyle.setBorderRight(BorderStyle.THIN);
        // 设置右边框颜色;
        contentWriteCellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
        // 设置顶边框;
        contentWriteCellStyle.setBorderTop(BorderStyle.THIN);
        // 设置顶边框颜色;
        contentWriteCellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());

        //字体
//        WriteFont contentWriteFont = new WriteFont();
//        contentWriteFont.setFontHeightInPoints((short)10);
        this.horizontalCellStyleStrategy = new HorizontalCellStyleStrategy(headWriteCellStyle, contentWriteCellStyle);
    }
}
