package com.nwu.service;


public interface PdfNoInspectService {

    /**
     * 免审pdf导出
     * @param applyId
     * @param applyTypeId
     * @return 返回路径
     */
    String getTutorNoInspect(Integer applyId,Integer applyTypeId,String pdfTemplate);
}
