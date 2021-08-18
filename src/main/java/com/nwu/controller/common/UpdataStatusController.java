package com.nwu.controller.common;

import com.nwu.entities.query.updateStatus;
import com.nwu.results.Result;
import com.nwu.service.common.ApplyService;
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
        System.out.println("++++"+list);
//        String number = "202032972";
//        Integer applyId = 3;
//       Integer status = 12;
//        int i = applyService.updateApplyStatus(number,applyId,status);
        if (list.size() > 0) {
            for (updateStatus s: list) {
                System.out.println(s);
                String number = s.getNumber_1();
                Integer applyId = s.getApplyId_1();
                Integer status = s.getStatus_1();
                int i = applyService.updateApplyStatus(number,applyId,status);
            }
        }
        return Result.SUCCESS();
    }
}
