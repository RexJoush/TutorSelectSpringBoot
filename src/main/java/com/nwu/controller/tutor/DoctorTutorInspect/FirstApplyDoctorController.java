package com.nwu.controller.tutor.DoctorTutorInspect;

import com.alibaba.fastjson.JSON;
import com.nwu.entities.Apply;
import com.nwu.entities.TutorInspect;
import com.nwu.results.Result;
import com.nwu.results.ResultCode;
import com.nwu.service.tutor.DoctorTutorInspect.FirstApplyDoctorService;


import com.nwu.service.tutor.DoctorTutorInspect.Impl.MyApplyMapperServiceImpl;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
@RequestMapping("/tutor/firstapplydoctor")
public class FirstApplyDoctorController {
    //saveOrUpdate() 这个方法是更新或者插入，有主键就执行更新，如果没有主键就执行插入。

    @Autowired
    FirstApplyDoctorService firstApplyDoctorService;

    //申请表
    @Autowired
    MyApplyMapperServiceImpl myapplyMapperService;

    @ApiOperation("是否申请过此岗位")
    @GetMapping("/ifapply")
    public Result IfApply(@RequestParam("tutorId") String tutorId ,@RequestParam("applyId") String applyId){
        System.out.println(tutorId+applyId);
        if (tutorId != "" && applyId != ""){
            //根据tutorId和applyid和status查询是否申请过
            Apply apply = myapplyMapperService.GetApplyInfoByTutorIdAndApplyId(tutorId, Integer.valueOf(applyId));
            if (apply!=null){
                //申请过此岗位
                return new Result(ResultCode.SUCCESS,"100");
            }
            else
            {
                //没有申请过此岗位
                return new Result(ResultCode.SUCCESS,"101");
            }
        }
        //返回失败
        return Result.FAIL();

    }

    @ApiOperation("保存博士基本信息")
    @PostMapping("/savebaseinfo")
    public Result SaveOrUpdateApplyDoctor(@RequestBody List<Map<String,Object>> list){
        //根据tutorId和appply_id先判断apply表里有没有对应的申请的信息，没有就认为是新申请，进行字段添加
//        if (tutorInspect.getTutorId()!=""){
//            Apply apply=myapplyMapperService.GetApplyInfoBytutorIdAndApplyId(tutorInspect.getTutorId(),3);
//            if (apply!=null){
//                //有数据，根据申请的apply_id查询出对应的apply中的id字段，根据id和tutor_id修改教师基本信息
//                UpdateWrapper<TutorInspect> wrapper=new UpdateWrapper();
//                wrapper.eq("tutor_id",apply.getId()).eq("number",apply.getTutorId());
//                boolean save = firstApplyDoctorService.update(tutorInspect,wrapper);
//                if (save)
//                    return Result.SUCCESS();
//                else
//                    return Result.FAIL();
//            }
//            else
//            {   //无数据1.将申请表添加 2.教师基本信息添加
//                Apply apply1 = new Apply();
//                apply1.setTutorId("202032973z");
//                apply1.setApplyId(4);
//                apply1.setStatus(10);
//                //将申请表添加
//                int i = myapplyMapperService.SaveApplyInfo(apply1);
//                if (i>0){
//                    //获取当前的apply中的id值
//                    int id = myapplyMapperService.GetIdByTutorIdAndApplyId(apply1.getTutorId(), apply1.getApplyId());
//                    //根据apply中的id值教师基本信息添加
//                    tutorInspect.setTutorId(String.valueOf(id));
//                    boolean save = firstApplyDoctorService.save(tutorInspect);
//                    if (save)
//                    {
//                        return Result.SUCCESS();
//                    }
//                    else{
//                        return Result.FAIL();
//                    }
//                }
//            }
//        }
        //1.保存 apply表
        //将map集合转为实体类
        Apply apply =JSON.parseObject(JSON.toJSONString(list.get(0)),Apply.class);
        TutorInspect tutorInspect=JSON.parseObject(JSON.toJSONString(list.get(1)),TutorInspect.class);
//        int i = myapplyMapperService.SaveApplyInfo(apply);


        System.out.println(tutorInspect);
//        int i = myapplyMapperService.SaveApplyInfo(apply);
//        if (i>0){
//            //保存成功
//        }

        //2.保存 tutor_inspect表
        return Result.SUCCESS();


    }


}
