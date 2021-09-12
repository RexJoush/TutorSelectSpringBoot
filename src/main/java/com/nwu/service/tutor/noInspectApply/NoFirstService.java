package com.nwu.service.tutor.noInspectApply;

import com.nwu.entities.Apply;
import com.nwu.entities.tutor.noInspect.NoFirstPage;

import javax.servlet.http.HttpServletRequest;

public interface NoFirstService {

    /**
     * 查询免审第一页信息 tutor_noinspect
     * @param applyId
     * @return
     */
    NoFirstPage getNoFirstPage(String applyId) throws Exception;

    /**
     * 保存免审第一页信息 tutor_no_inspect
     * @param noFirstPage
     * @param request
     * @return
     * @throws Exception
     */
    int saveNoFirstPage(NoFirstPage noFirstPage, HttpServletRequest request) throws Exception;

    /**
     * 存储 apply 表
     * @param apply 申请信息
     * @return 返回主键
     */
    int saveNoApplyInfo(Apply apply);
}
