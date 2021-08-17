package com.nwu.controller.DoctorTutorInspect;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.nwu.entities.TutorInspect;
import com.nwu.results.Result;
import com.nwu.service.TutorInspectService;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zjz
 * @since 2021-08-16
 */
@RestController
@ApiModel("首次申请博士导师岗位")
@RequestMapping("/doctor")
public class FirstApplyDoctorController {
    //saveOrUpdate() 这个方法是更新或者插入，有主键就执行更新，如果没有主键就执行插入。
    @Autowired
    TutorInspectService tutorInspectService;

    @ApiOperation("保存或更新博士基本信息")
    @PostMapping("")
    public Result SaveOrUpdateApplyDoctor(){
        UpdateWrapper<TutorInspect> updateWrapper=new UpdateWrapper();


        return null;
    }


}
