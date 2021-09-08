package com.nwu.service.tutor.common;

import com.nwu.entities.Apply;
import com.nwu.entities.tutor.FirstPage;

import javax.servlet.http.HttpServletRequest;

public interface FirstService {
    /**
     * 存储 apply 表
     * @param apply 申请信息
     * @return 返回主键
     */
    int saveApplyInfo(Apply apply);

    /**
     * 插入第一页信息
     * @param firstPage
     * @return
     */
    int saveFirstPage(FirstPage firstPage, HttpServletRequest request) throws Exception ;
}




