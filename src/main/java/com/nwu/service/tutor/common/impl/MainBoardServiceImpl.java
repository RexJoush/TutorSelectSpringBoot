package com.nwu.service.tutor.common.impl;

import com.nwu.entities.Apply;
import com.nwu.mapper.tutor.common.TutorApplyMapper;
import com.nwu.service.tutor.common.MainBoardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class MainBoardServiceImpl implements MainBoardService {

    @Resource
    private TutorApplyMapper tutorApplyMapper;

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

    @Override
    public int updateApplySubject(int id, int applySubject) {
        return tutorApplyMapper.updateApplySubject(id, applySubject);
    }

    @Override
    public int getId(String tutorId, int applyId, int status) {
        return tutorApplyMapper.getId(tutorId, applyId, status);
    }


    @Override
    public int getApplyIdByTutorIdAndStatus(String tutorId, Integer status) {
        return tutorApplyMapper.getApplyIdByTutorIdAndStatus(tutorId,status);
    }
}
