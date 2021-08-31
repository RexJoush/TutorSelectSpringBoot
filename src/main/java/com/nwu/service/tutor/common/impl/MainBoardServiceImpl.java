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
    public Apply getApplyInfoByTutorIdAndApplyId(String tutorId, Integer applyTypeId) {
        return tutorApplyMapper.getApplyInfoByTutorIdAndApplyTypeId(tutorId, applyTypeId);
    }

    @Override
    public Apply getApplyByTutorIdAndApplyTypeIdAndStatus(String tutorId, Integer applyTypeId) {
        return tutorApplyMapper.getApplyByTutorIdAndApplyTypeIdAndStatus(tutorId, applyTypeId);
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
    public int getApplyId(String tutorId, int applyTypeId, int status) {
        return tutorApplyMapper.getApplyId(tutorId, applyTypeId, status);
    }


    @Override
    public int getApplyIdByTutorIdAndStatus(String tutorId, Integer status) {
        return tutorApplyMapper.getApplyIdByTutorIdAndStatus(tutorId,status);
    }
}
