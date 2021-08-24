package com.nwu.service;

import com.nwu.entities.TutorInspect;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nwu.entities.tutor.FirstPage;
import com.nwu.vo.TutorQuery;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dynamic
 * @since 2021-08-09
 */
public interface TutorInspectService extends IService<TutorInspect> {

     /**
      * 获取导师申请信息
      * @param tutorQuery 查询条件
      * @return 信息列表
      */
     List<TutorInspect> getTutorByQuery(TutorQuery tutorQuery);

     /**
      * 更新申请导师信息
      * @param firstPage 信息
      * @return 修改条数
      */
     int saveTutorInspectBaseInfo(FirstPage firstPage);
}
