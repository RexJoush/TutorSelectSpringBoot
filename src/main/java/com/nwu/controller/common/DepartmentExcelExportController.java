package com.nwu.controller.common;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.event.WriteHandler;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.WriteTable;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.alibaba.excel.write.style.column.SimpleColumnWidthStyleStrategy;
import com.google.common.collect.Lists;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.TableStyle;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DepartmentExcelExportController {


    private static List<List<String>> head(String schoolName, String departmentName){
        //1、生成年份
        Calendar instance = Calendar.getInstance();
        String year = instance.get(Calendar.YEAR) + "";
        //2、构造表头
        List<List<String>> headTitles = Lists.newArrayList();
        String firstRow = schoolName + year + "年"+ departmentName +"学位评定分委员会推荐汇总表";
        String secondRow = "（首次上岗研究生导师/增列学科岗位认定）";
        //前7列
        ArrayList<String> sevenCol = Lists.newArrayList("序号", "姓名", "出生年月", "最后学位", "职称", "申请学科或类别及代码", "导师上岗类别");
        sevenCol.forEach(title ->{
            headTitles.add(Lists.newArrayList(firstRow,secondRow,title,title,title));
        });
        //第8列
        headTitles.add(Lists.newArrayList(firstRow,secondRow,"学位评定委员会审议情况","应到委员","应到委员"));
        //第9列
        headTitles.add(Lists.newArrayList(firstRow,secondRow,"学位评定委员会审议情况","实到委员","实到委员"));
        //第10列
        headTitles.add(Lists.newArrayList(firstRow,secondRow,"学位评定委员会审议情况","表决结果","同意/不同意/弃权"));
        //第11列
        headTitles.add(Lists.newArrayList(firstRow,secondRow,"备注","备注","备注"));
        return headTitles;
    }

    private static List<List<Object>> contentData(){
        List<List<Object>> contentList = Lists.newArrayList();
        contentList.add(Lists.newArrayList("1","2","3","4","5","6","7","3","5","3","2"));
        contentList.add(Lists.newArrayList("1=2","26","3","4","5","6","7","3","5","3","2"));
        return contentList;

    }

    public static void main(String[] args) throws IOException {
        String fileName = "e://test.xlsx";

        //设置头策略
        WriteCellStyle headWriteCellStyle = new WriteCellStyle();
        //背景
        headWriteCellStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        WriteFont headWriteFont = new WriteFont();
        headWriteFont.setFontHeightInPoints((short) 10);
        headWriteCellStyle.setWriteFont(headWriteFont);

        //设置内容策略
        WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
        //字体
//        WriteFont contentWriteFont = new WriteFont();
//        contentWriteFont.setFontHeightInPoints((short)20);

        HorizontalCellStyleStrategy horizontalCellStyleStrategy = new HorizontalCellStyleStrategy(headWriteCellStyle, contentWriteCellStyle);

        EasyExcel.write(fileName)
                .head(head("西北大学","网数中心"))
                .registerWriteHandler(horizontalCellStyleStrategy).registerWriteHandler(new SimpleColumnWidthStyleStrategy(18)).sheet().doWrite(contentData());
    }




}
