package com.nwu.service.tutor.DoctorTutorInspect.Impl;

import com.nwu.entities.Apply;
import com.nwu.mapper.DoctorTutorInspectMapper.MyApplyMapper;
import com.nwu.service.tutor.DoctorTutorInspect.MyApplyMapperService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class MyApplyMapperServiceImpl implements MyApplyMapperService {

    @Resource
    MyApplyMapper myApplyMapper;

    @Override
    public int GetApplyByTutorIdService(String tutorId) {
        return myApplyMapper.GetApplyByTutorId(tutorId);
    }

    @Override
    public Apply GetApplyInfoByTutorIdAndApplyId(String tutorId, Integer applyId) {
        return myApplyMapper.GetApplyInfoByTutorIdAndApplyId(tutorId, applyId);
    }

    @Override
    public int SaveApplyInfo(Apply apply) {
        return myApplyMapper.SaveApplyInfo(apply);
    }

    @Override
    public int GetIdByTutorIdAndApplyId(String tutorId, Integer applyId) {
        return myApplyMapper.GetIdByTutorIdAndApplyId(tutorId,applyId);
    }
}
