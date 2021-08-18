package com.nwu.service.DoctorTutorInspect.Impl;

import com.nwu.entities.Apply;
import com.nwu.mapper.DoctorTutorInspectMapper.MyApplyMapper;
import com.nwu.service.DoctorTutorInspect.MyApplyMapperService;
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
    public Apply GetApplyInfoBytutorIdAndApplyId(String tutorId, Integer applyId) {
        return myApplyMapper.GetApplyInfoBytutorIdAndApplyId(tutorId, applyId);
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
