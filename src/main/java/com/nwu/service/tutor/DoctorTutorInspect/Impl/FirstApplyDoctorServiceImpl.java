package com.nwu.service.tutor.DoctorTutorInspect.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nwu.entities.TutorInspect;
import com.nwu.mapper.DoctorTutorInspectMapper.FirstApplyDoctorMapper;
import com.nwu.service.tutor.DoctorTutorInspect.FirstApplyDoctorService;
import org.springframework.stereotype.Service;

@Service
public class FirstApplyDoctorServiceImpl  extends ServiceImpl<FirstApplyDoctorMapper, TutorInspect> implements FirstApplyDoctorService {
}
