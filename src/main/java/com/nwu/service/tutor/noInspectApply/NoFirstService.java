package com.nwu.service.tutor.noInspectApply;

import com.nwu.entities.tutor.noInspect.NoFirstPage;

public interface NoFirstService {

    /**
     * 查询免审第一页信息 tutor_noinspect
     * @param applyId
     * @return
     */
    NoFirstPage getNoFirstPage(String applyId);
}
