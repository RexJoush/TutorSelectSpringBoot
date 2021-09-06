package com.nwu.service.admin.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nwu.entities.Apply;
import com.nwu.entities.tutor.ApplyDisplay;
import com.nwu.mapper.admin.ApplyMapper;
import com.nwu.service.admin.ApplyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ApplyServiceImpl extends ServiceImpl<ApplyMapper, Apply> implements ApplyService {

    @Resource
    private ApplyMapper applyMapper;

    @Override
    public int updateApplyStatusAndTime(Integer applyId, Integer status, String time) {
        return applyMapper.updateApplyStatusAndTime(applyId,status,time);
    }

    @Override
    public int updateApplyStatus(Integer id, Integer status, String commit) {
        applyMapper.updateApplyStatus(id,status,commit);
        return 1;
    }

    @Override
    public List<ApplyDisplay> getApplyList(String tutorId) {
        return null;
    }
}
