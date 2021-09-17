package com.nwu.service;

public interface PdfInspectService {
    /**
     * 非免审pdf导出
     * @param applyId
     * @param applyTypeId
     * @return 返回路径
     */
    String getTutorInspectPdf(Integer applyId,Integer applyTypeId,String pdfTemplatePath);
}
