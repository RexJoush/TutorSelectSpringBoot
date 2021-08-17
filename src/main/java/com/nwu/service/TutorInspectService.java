package com.nwu.service;

import com.nwu.entities.TutorInspect;
import com.baomidou.mybatisplus.extension.service.IService;
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
     List<TutorInspect> getTutorByQuery(TutorQuery tutorQuery);
}
