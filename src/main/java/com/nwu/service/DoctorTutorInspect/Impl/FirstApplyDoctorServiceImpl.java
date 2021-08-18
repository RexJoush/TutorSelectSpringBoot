package com.nwu.service.DoctorTutorInspect.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nwu.entities.TutorInspect;
import com.nwu.mapper.DoctorTutorInspectMapper.FirstApplyDoctorMapper;
import com.nwu.mapper.TutorInspectMapper;
import com.nwu.service.DoctorTutorInspect.FirstApplyDoctorService;
import com.nwu.service.TutorInspectService;
import org.springframework.stereotype.Service;

@Service
public class FirstApplyDoctorServiceImpl  extends ServiceImpl<FirstApplyDoctorMapper, TutorInspect> implements FirstApplyDoctorService {
}
