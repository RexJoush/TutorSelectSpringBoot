package com.nwu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nwu.entities.AcademicPaper;
import com.nwu.mapper.AcademicPaperMapper;
import com.nwu.service.scientificResearchManager.AcademicPaperService;
import org.springframework.stereotype.Service;

@Service
public class AcademicPaperImpl extends ServiceImpl<AcademicPaperMapper, AcademicPaper> implements AcademicPaperService {
}
