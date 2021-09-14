package com.nwu.service;

import com.nwu.entities.TutorInspect;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nwu.entities.tutor.FirstPage;

import com.nwu.entities.tutor.ThirdPage;
import com.nwu.vo.QueryDepartmentSecretaryInit;

import com.nwu.entities.tutor.SecondPage;

import com.nwu.vo.TutorQuery;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author dynamic
 * @since 2021-08-09
 */
public interface TutorInspectService extends IService<TutorInspect> {

    /**
     * 获取导师申请信息
     *
     * @param tutorQuery 查询条件
     * @return 信息列表
     */
    List<QueryDepartmentSecretaryInit> getTutorByQuery(TutorQuery tutorQuery);

    /**
     * 根据applyId获取第一页信息
     * @param ApplyId
     * @return FirstPage
     */
    FirstPage getFirstPage(int ApplyId);

    /**
     * 更新第一页申请导师信息
     *
     * @param firstPage 信息
     * @return 修改条数
     */
    int saveTutorInspectBaseInfo(FirstPage firstPage);

    /**
     * 获取第二页的导师信息
     *
     * @param applyId tutor_inspect 表的主键
     * @return 第二页信息
     */
    SecondPage getTutorInspectSecond(int applyId);

    /**
     * 更新第二页的导师信息
     *
     * @param applyId    tutor_inspect 表的主键
     * @param secondPage 信息
     * @return 修改条数
     */
    int updateTutorInspectSecond(int applyId, SecondPage secondPage);


}
