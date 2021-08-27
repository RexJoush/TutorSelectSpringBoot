package com.nwu.controller.tutor.doctorTutorInspect;

import com.nwu.entities.TutorInspect;
import com.nwu.results.Result;

import com.nwu.service.TutorInspectService;
import com.nwu.service.tutor.common.MainBoardService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zjz
 * @since 2021-08-16
 */
@RestController
@ApiModel("首次申请博士导师岗位")
@RequestMapping("/tutor/firstApplyDoctor")
public class FirstApplyDoctorController {
    // saveOrUpdate() 这个方法是更新或者插入，有主键就执行更新，如果没有主键就执行插入。
//    @Resource
//    private FirstApplyDoctorService firstApplyDoctorService;
    // 申请表
    @Resource
    private MainBoardService mainBoardService;
    // 导师申请表
    @Resource
    private TutorInspectService tutorInspectService;


    public static String tutorId="202032978";
    @ApiOperation("保存博士基本信息和申请类别表")
    @PostMapping("/saveBaseInfo/{applyId}/{applyCondition}")
    public Result SaveOrUpdateApplyDoctor(@RequestBody TutorInspect tutorInspect, @PathVariable("applyId") Integer applyId, @PathVariable("applyCondition") Integer applyCondition) {

        // 没有申请过和正在申请中都进来 根据applyCondition判断是插入还是修改apply
        if (applyCondition == 102) {
            // 1.apply表插入，教师表插入
            System.out.println(applyCondition);

        } else if (applyCondition == 101) {
            // 2.根据apply表去修改教师申请表
            // 根据tutor_id和status查出与apply对应的tutor_inspect的id
            int id = mainBoardService.getApplyIdByTutorIdAndStatus(tutorId, 0);
            tutorInspect.setTutorId("13");
            System.out.println(tutorInspect);
            // tutorInspectService.updateTutorInspect(tutorInspect);


        }
        return Result.FAIL();


    }


}
