package com.nwu.service.tutor.doctorTutorInspect.Impl;

import com.nwu.entities.Apply;
import com.nwu.mapper.doctorTutorInspectMapper.MyApplyMapper;
import com.nwu.service.tutor.doctorTutorInspect.MyApplyMapperService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class MyApplyMapperServiceImpl implements MyApplyMapperService {

    @Resource
    MyApplyMapper myApplyMapper;

    @Override
    public int getApplyByTutorIdService(String tutorId) {
        return myApplyMapper.getApplyByTutorId(tutorId);
    }

    @Override
    public Apply getApplyInfoByTutorIdAndApplyId(String tutorId, Integer applyId) {
        return myApplyMapper.getApplyInfoByTutorIdAndApplyId(tutorId, applyId);
    }

    @Override
    public Apply getApplyByTutorIdAndApplyIdAndStatus(String tutorId, Integer applyId) {
        return myApplyMapper.getApplyByTutorIdAndApplyIdAndStatus(tutorId, applyId);
    }

    @Override
    public int saveApplyInfo(Apply apply) {
        return myApplyMapper.saveApplyInfo(apply);
    }

    @Override
    public int getIdByTutorIdAndApplyId(String tutorId, Integer applyId) {
        return myApplyMapper.getIdByTutorIdAndApplyId(tutorId,applyId);
    }

    @Override
    public int getApplyIdByTutorIdAndStatus(String tutorId, Integer status) {
        return myApplyMapper.getApplyIdByTutorIdAndStatus(tutorId,status);
    }
}
