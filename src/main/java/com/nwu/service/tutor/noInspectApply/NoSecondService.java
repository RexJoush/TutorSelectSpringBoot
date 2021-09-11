package com.nwu.service.tutor.noInspectApply;

import com.nwu.entities.tutor.noInspect.NoSecondPage;

/**
 * @author zjz
 * @time 2021.08.20 14:48
 */

public interface NoSecondService {

    /**
     * 免审第二页初始化 不查询数据库
     * @return 免审SecondPage
     */
    NoSecondPage getSecondPageInit();

    NoSecondPage getSecondPage(Integer applyId);
}
