package com.nwu.service.common;

import com.nwu.entities.TutorInspect;

public interface MyTutorInspectService {
    /**
     * 根据主键id更新tutorInspect
     * @param tutorInspect
     * @return
     */
    int updateTutorInspectById(TutorInspect tutorInspect);

    /**
     * 更新导师基本信息
     * @param inspect
     * @return
     */
    int updateTutorInspect(TutorInspect inspect);
}
