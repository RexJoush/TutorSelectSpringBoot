package com.nwu.service.impl;

import com.nwu.entities.TutorInspect;
import com.nwu.entities.tutor.FirstPage;
import com.nwu.entities.tutor.SecondPage;
import com.nwu.mapper.TutorInspectMapper;
import com.nwu.service.TutorInspectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nwu.vo.QueryDepartmentSecretaryInit;
import com.nwu.vo.TutorQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dynamic
 * @since 2021-08-09
 */
@Service
public class TutorInspectServiceImpl extends ServiceImpl<TutorInspectMapper, TutorInspect> implements TutorInspectService {

    @Autowired
    private TutorInspectMapper tutorInspectMapper;

    @Override
    public List<QueryDepartmentSecretaryInit> getTutorByQuery(TutorQuery tutorQuery) {
        return tutorInspectMapper.selectByQuery(tutorQuery);
    }

    @Override
    public int saveTutorInspectBaseInfo(FirstPage firstPage) {
        return tutorInspectMapper.saveTutorInspectBaseInfo(firstPage);
    }

    @Override
    public SecondPage getTutorInspectSecond(int applyId) {
        return tutorInspectMapper.getTutorInspectSecond(applyId);
    }

    @Override
    public int updateTutorInspectSecond(int applyId, SecondPage secondPage) {
        return tutorInspectMapper.updateTutorInspectSecond(applyId, secondPage);
    }
}
