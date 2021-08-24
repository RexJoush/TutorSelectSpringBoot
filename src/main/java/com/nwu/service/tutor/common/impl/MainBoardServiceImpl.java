package com.nwu.service.tutor.common.impl;

import com.nwu.entities.Apply;
import com.nwu.mapper.tutor.common.TutorApplyMapper;
import com.nwu.service.tutor.common.MainBoardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class MainBoardServiceImpl implements MainBoardService {

    @Resource
    TutorApplyMapper tutorApplyMapper;

//    @Override
//    public int getApplyByTutorIdService(String tutorId) {
//        return tutorApplyMapper.getApplyByTutorId(tutorId);
//    }

    @Override
    public Apply getApplyInfoByTutorIdAndApplyId(String tutorId, Integer applyId) {
        return tutorApplyMapper.getApplyInfoByTutorIdAndApplyId(tutorId, applyId);
    }

    @Override
    public Apply getApplyByTutorIdAndApplyIdAndStatus(String tutorId, Integer applyId) {
        return tutorApplyMapper.getApplyByTutorIdAndApplyIdAndStatus(tutorId, applyId);
    }

    @Override
    public int saveApplyInfo(Apply apply) {
        return tutorApplyMapper.saveApplyInfo(apply);
    }

//    @Override
//    public int getIdByTutorIdAndApplyId(String tutorId, Integer applyId) {
//        return tutorApplyMapper.getIdByTutorIdAndApplyId(tutorId,applyId);
//    }

    @Override
    public int getApplyIdByTutorIdAndStatus(String tutorId, Integer status) {
        return tutorApplyMapper.getApplyIdByTutorIdAndStatus(tutorId,status);
    }
}
