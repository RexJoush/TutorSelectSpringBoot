package com.nwu.service.DoctorTutorInspect.Impl;

import com.nwu.entities.Apply;
import com.nwu.mapper.DoctorTutorInspectMapper.ApplyMapper;
import com.nwu.service.DoctorTutorInspect.ApplyMapperService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class ApplyMapperServiceImpl implements ApplyMapperService {

    @Resource
    ApplyMapper applyMapper;

    @Override
    public int GetApplyByTutorIdService(String tutorId) {
        return applyMapper.GetApplyByTutorId(tutorId);
    }

    @Override
    public Apply GetApplyInfoBytutorIdAndApplyId(String tutorId, Integer applyId) {
        return applyMapper.GetApplyInfoBytutorIdAndApplyId(tutorId, applyId);
    }

    @Override
    public int SaveApplyInfo(Apply apply) {
        return applyMapper.SaveApplyInfo(apply);
    }

    @Override
    public int GetIdByTutorIdAndApplyId(String tutorId, Integer applyId) {
        return applyMapper.GetIdByTutorIdAndApplyId(tutorId,applyId);
    }
}
