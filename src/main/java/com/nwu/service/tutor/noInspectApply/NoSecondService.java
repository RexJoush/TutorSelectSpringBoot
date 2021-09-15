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

    /**
     * 获取第二页信息 查询数据库
     * @param applyId
     * @return
     */
    NoSecondPage getSecondPage(Integer applyId);

    /**
     * 更新第二页信息
     * @param noSecondPage
     * @return
     */
    void updateNoSecondPage(NoSecondPage noSecondPage,Integer applyId);
}
