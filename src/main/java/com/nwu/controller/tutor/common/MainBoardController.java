package com.nwu.controller.tutor.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nwu.entities.Apply;
import com.nwu.entities.tutor.FirstPage;
import com.nwu.entities.tutor.TeacherInfo;
import com.nwu.results.Result;
import com.nwu.results.ResultCode;
import com.nwu.service.TutorInspectService;
import com.nwu.service.tutor.common.DeleteFileService;
import com.nwu.service.tutor.common.MainBoardService;
import com.nwu.service.tutor.common.TeacherInfoService;
import com.nwu.util.ResultClient;
import com.nwu.util.UpLoadFile;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;

/**
 * @author Rex Joush
 * @time 2021.08.24 20:48
 */
@RestController
@RequestMapping("/tutor")
public class MainBoardController {

    public final String tutorId = "20133220";

    // 申请表
    @Resource
    private MainBoardService mainBoardService;
    //教师基本信息
    @Resource
    private TeacherInfoService teacherInfoService;
    @Resource
    private TutorInspectService tutorInspectService;
    //删除文件
    @Resource
    private DeleteFileService deleteFileService;

    /*
        判断是否第一次申请
        首次博士，首次学硕，首次专硕
    */
    @ApiOperation("是否申请过此岗位")
    @GetMapping("/firstApply/{applyTypeId}")
    public Result firstApply(@PathVariable("applyTypeId") int applyTypeId) {
        if (!"".equals(tutorId)) {
            /*
                根据 tutorId 和 applyId 查询申请信息
                101：已经申请过此岗位，但信息未填写完成
                100：已经申请过此岗位，且信息已提交完成
                102：未申请过此岗位
             */
            Apply apply = mainBoardService.getApplyInfoByTutorIdAndApplyId(tutorId, applyTypeId);
            // 申请过
            if (apply != null) {
                // 申请过此岗位 有数据 但不知道其状态
                if (apply.getStatus() == 0) {
                    return new Result(ResultCode.SUCCESS, 101);
                } else {
                    // 老师已提交 申请过此岗位
                    return new Result(ResultCode.SUCCESS, 100);
                }
            }
            // 未申请
            else {
                return new Result(ResultCode.SUCCESS, 102);
            }
        }
        //返回失败
        return Result.FAIL();

    }

    /*
        判断增列
        增列博士，增列学硕，增列专硕，免审
    */
    @ApiOperation("是否申请申请过此类型岗位")
    @GetMapping("/addApply/{applyTypeId}")
    public Result addApply(@PathVariable("applyTypeId") int applyTypeId) {

        if (!"".equals(tutorId)) {
            //status == 0
            Apply apply = mainBoardService.getApplyByTutorIdAndApplyTypeIdAndStatus(tutorId, applyTypeId);
            HashMap<String, Object> map = new HashMap<>();
            if (apply != null) {
               // 申请过此岗位 status == 0 信息还没有填写完整 主键也返回
                map.put("applyId",apply.getApplyId());
                map.put("applyCondition",101);
            } else {
                // 没有申请过此岗位
                map.put("applyId",-1);
                map.put("applyCondition",102);
            }
            return new Result(ResultCode.SUCCESS, map);
        }
        // 返回失败
        return Result.FAIL();
    }

    /*
        获取导师基本信息
     */
    @GetMapping("/getTeacherInfo/{applyTypeId}/{applyCondition}")
    public Result getTeacherInfo(@PathVariable("applyTypeId") Integer applyTypeId ,@PathVariable("applyCondition") Integer applyCondition){
        FirstPage firstPage;
        try {
            if (applyCondition == 102) {
                //未申请过 查找teacherInfo
                firstPage = teacherInfoService.getTeacherInfo(tutorId);
            }
            else if (applyCondition == 101) {
                //已申请过 查询对应的主键
                int applyId = mainBoardService.getApplyId(tutorId, applyTypeId, 0);
                //查询tutorInspect
                firstPage = tutorInspectService.getFirstPage(String.valueOf(applyId));
            }
            else {
                return Result.FAIL();
            }
        } catch (Exception e) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", 1201);
            jsonObject.put("message", "您不在此系统中，请联系系统管理员");
            jsonObject.put("errorMessage", e.getMessage());
            return new Result(ResultCode.SUCCESS, jsonObject);
        }
        return new Result(ResultCode.SUCCESS, firstPage);
    }

    /**
     * 导师增列
     * @param applyTypeId
     * @param applyCondition
     * @param applyId
     * @return
     */
        @GetMapping("/getFirstPage/{applyTypeId}/{applyCondition}/{applyId}")
        public Result getFirstPage(@PathVariable("applyTypeId") Integer applyTypeId ,@PathVariable("applyCondition") Integer applyCondition,@PathVariable("applyId") Integer applyId)
        {
            FirstPage firstPage;
            if (applyCondition == 102) {
                //未申请过 查找teacherInfo
                firstPage = teacherInfoService.getTeacherInfo(tutorId);
            } else if (applyCondition == 101) {
                //查询tutorInspect 博士增岗
                firstPage = tutorInspectService.getFirstPage(String.valueOf(applyId));
            } else {
                return Result.FAIL();
            }
            return new Result(ResultCode.SUCCESS, firstPage);
        }

        //           ===  校外  ====
//        TeacherInfo teacherInfo = new TeacherInfo();
//        teacherInfo.setXM("吴昊");
//        teacherInfo.setSFZJH("420111197209287319");
//        teacherInfo.setXB("男");
//        teacherInfo.setSJH("13519162128");
//        teacherInfo.setMC("网络和数据中心");
//        teacherInfo.setSHZ("");
//        teacherInfo.setCSRQ("1972-09-28 00:00:00.0");
//        teacherInfo.setZGXW("博士");
//        teacherInfo.setZGH("20133220");
//        teacherInfo.setZCMC("高级工程师");

        // 查不到教师信息
//        if (teacherInfo == null){
//            return Result.FAIL();
//        }
//        return new Result(ResultCode.SUCCESS, teacherInfo);

    /**
     * 文件上传controller
     * @param uploadFile
     * @param typeId 上传文件类别 学术论文/科研奖励等  11=博士首次申请+学术论文 41=硕士首次申请+学术论文
     * @param req
     * @return  path路径
     */
    @ApiOperation("文件上传")
    @PostMapping("/upload/{typeId}")
    public Result uploadFile(@RequestParam("material") MultipartFile uploadFile, @PathVariable("typeId") Integer typeId, HttpServletRequest req) {
        UpLoadFile loadFile = new UpLoadFile();
        String typeName = "";
        if (!"".equals(typeId)) {
            switch (typeId) {
                case 1: {
                    typeName = typeName + "学术论文/社科类论文";
                    break;
                }
                case 2: {
                    typeName = typeName + "学术论文/理工类论文";
                    break;
                }
                case 3: {
                    typeName = typeName + "科研项目";
                    break;
                }
                case 4: {
                    typeName = typeName + "教材或学术著作";
                    break;
                }
                case 5: {
                    typeName = typeName + "科研教学奖励";
                    break;
                }
                case 6: {
                    typeName = typeName + "发明专利";
                    break;
                }
                default: {
                    return Result.FAIL();
                }
            }
            String path = loadFile.upload(uploadFile, req, typeName, tutorId);
            System.out.println(path);
            if (!"".equals(path)) {
                //路径不为空
                HashMap<String, Object> map = new HashMap<>();
                map.put("fileType",typeId);
                map.put("path",path);
                return new Result(ResultCode.SUCCESS, map);
            } else {   //路径为空
                return Result.FAIL();
            }
        }
        return Result.FAIL();
    }

    /**
     * 文件删除
     * @param httpPath
     * @return  Result.SUCCESS();  .FAIL()
     * @throws UnsupportedEncodingException
     */
    @ApiOperation("文件删除")
    @PostMapping("/delFile")
    public Result delFile(@RequestBody String httpPath) throws UnsupportedEncodingException {
        String s = deleteFileService.delFile(httpPath);
        if ("ok".equals(s)){
            return Result.SUCCESS();
        }
        return Result.FAIL();
    }

}
