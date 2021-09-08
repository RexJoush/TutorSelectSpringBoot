package com.nwu.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nwu.entities.Apply;
import com.nwu.vo.UpdateStatus;
import com.nwu.results.Result;
import com.nwu.service.admin.ApplyService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/*
 *  进行审核操作,更新审核状态
 */
@RestController
@RequestMapping("/update-status")
public class UpdateStatusController {
    @Resource
    public ApplyService applyService;

    //更新操作，修改状态
    @PostMapping("/update")
    public Result updateStatusByDepartmentSecretary(@RequestBody List<UpdateStatus> list) throws Exception {
        System.out.println(list);
        if (list.size() > 0) {
            for (UpdateStatus s : list) {
                System.out.println(s);
                Integer id = s.getId_1();
                Integer status = s.getStatus_1();
                String commit = s.getCommit_1();
                int i = applyService.updateApplyStatus(id, status, commit);
            }
        }
        return Result.SUCCESS();
    }

    //提交按钮后的更新操作，将符合条件以及不符合条件的一起提交给研究生院主管
    @Transactional
    @PostMapping("/submitUpdate")
    public Result updateStatusBySubmit() throws Exception {
            Apply apply = new Apply();
            apply.setStatus(38);
            Apply unApplay = new Apply();
            unApplay.setStatus(39);
            QueryWrapper<Apply> applyQueryWrapper = new QueryWrapper<>();
            applyQueryWrapper .eq("status","388");
            QueryWrapper<Apply> unApplyQueryWrapper = new QueryWrapper<>();
            unApplyQueryWrapper.eq("status","399");
            applyService.update(apply,applyQueryWrapper);
            applyService.update(unApplay,unApplyQueryWrapper);
            return Result.SUCCESS();
    }
}
