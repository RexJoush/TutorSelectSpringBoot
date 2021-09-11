package com.nwu.service.admin.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nwu.entities.Apply;
import com.nwu.entities.tutor.ApplyDisplay;
import com.nwu.mapper.admin.ApplyMapper;
import com.nwu.service.admin.ApplyService;
import com.nwu.vo.ApplyDisplayVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ApplyServiceImpl extends ServiceImpl<ApplyMapper, Apply> implements ApplyService {

    @Resource
    private ApplyMapper applyMapper;

    @Override
    public int updateApplyStatusAndTime(Integer applyId, Integer status, String time) {
        return applyMapper.updateApplyStatusAndTime(applyId, status, time);
    }


    @Override
    public int updateApplyStatus(Integer applyId, Integer status, String commit) {
        applyMapper.updateApplyStatusAndCommit(applyId, status, commit);
        return 1;
    }

    //院系秘书初审提交分会页面的更新操作
    @Override
    public int updateApplyStatusSfh(Integer applyId, Integer status, String commit){
        applyMapper.updateApplyStatusAndCommitSfh(applyId, status, commit);
        return 1;
    }

    @Override
    public int updateApplyStatusAndCommitXy(Integer applyId, Integer status, String commit){
        applyMapper.updateApplyStatusAndCommitXy(applyId, status, commit);
        return 1;
    }

    @Override
    public List<ApplyDisplay> getApplyList(String tutorId) {

        List<ApplyDisplay> applyList = new ArrayList<>();

        // 获取非免审的申请
        List<ApplyDisplayVo> inspectApply = applyMapper.getInspectApply(tutorId);

        if (inspectApply != null) {
            for (ApplyDisplayVo display : inspectApply) {
                ApplyDisplay applyDisplay = new ApplyDisplay();

                // 设置基本信息
                applyDisplay.setApplyId(display.getApplyId());
                applyDisplay.setApplyTypeId(display.getApplyTypeId());
                applyDisplay.setApplyName(display.getApplyName());
                applyDisplay.setStatus(display.getStatus());
                applyDisplay.setStatusDisplay(display.getStatusDisplay());
                applyDisplay.setCommit(display.getCommit());

                // 填写申请的专业信息
                switch (display.getApplyTypeId()) {
                    case 1:
                    case 2:
                    case 4:
                    case 5:
                        applyDisplay.setApplyDepartment(display.getDoctoralMasterApplicationSubjectUnit());
                        if (display.getDoctoralMasterSubjectCode() == null){
                            applyDisplay.setApplySubject("");
                        } else {
                            applyDisplay.setApplySubject(display.getDoctoralMasterSubjectCode() + " " + display.getDoctoralMasterSubjectName());
                        }
                        break;
                    case 7:
                    case 8:
                        applyDisplay.setApplyDepartment(display.getProfessionalApplicationSubjectUnit());
                        if (display.getDoctoralMasterSubjectCode() == null){
                            applyDisplay.setApplySubject("");
                        } else {
                            applyDisplay.setApplySubject(display.getProfessionalApplicationSubjectCode() + " " + display.getProfessionalApplicationSubjectName());
                        }
                        break;
                    default:
                        break;
                }
                // 标识非免审
                applyDisplay.setNoInspect(false);
                applyList.add(applyDisplay);
            }
        }


        // 获取免审的申请
        List<ApplyDisplayVo> noInspectApply = applyMapper.getNoInspectApply(tutorId);

        if (noInspectApply != null) {
            for (ApplyDisplayVo display : noInspectApply) {

                ApplyDisplay applyDisplay = new ApplyDisplay();

                // 设置基本信息
                applyDisplay.setApplyId(display.getApplyId());
                applyDisplay.setApplyTypeId(display.getApplyTypeId());
                applyDisplay.setApplyName(display.getApplyName());
                applyDisplay.setStatus(display.getStatus());
                applyDisplay.setStatusDisplay(display.getStatusDisplay());
                applyDisplay.setCommit(display.getCommit());

                // 设置申请的学院和专业
                applyDisplay.setApplyDepartment(display.getAppliedSubjectUnit());
                applyDisplay.setApplySubject(display.getAppliedSubjectCode() + " " + display.getAppliedSubjectName());

                // 标识免审
                applyDisplay.setNoInspect(true);
                applyList.add(applyDisplay);
            }
        }

        // 返回两个列表合并
        return applyList;
    }
}
