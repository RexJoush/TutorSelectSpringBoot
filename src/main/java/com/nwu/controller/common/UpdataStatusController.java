package com.nwu.controller.common;

import com.nwu.vo.updateStatus;
import com.nwu.results.Result;
import com.nwu.service.common.ApplyService;
import io.swagger.models.auth.In;
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
public class UpdataStatusController {
    @Resource
    public ApplyService applyService;
    //更新操作，修改状态
    @PostMapping("/update")
    public Result updateStatusByDepartmentSecretary(@RequestBody List<updateStatus> list)throws Exception{
        System.out.println(list);
        if (list.size() > 0) {
            for (updateStatus s: list) {
                System.out.println(s);
                Integer id = s.getId_1();
                String number = s.getNumber_1();
                Integer applyId = s.getApplyId_1();
                Integer status = s.getStatus_1();
                String commit = s.getCommit_1();
                int i = applyService.updateApplyStatus(number,applyId,status,commit,id);
            }
        }
        return Result.SUCCESS();
    }
}
