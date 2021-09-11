package com.nwu.controller.tutor.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nwu.entities.Apply;
import com.nwu.entities.tutor.FirstPage;
import com.nwu.entities.tutor.TeacherInfo;
import com.nwu.entities.tutor.noInspect.NoFirstPage;
import com.nwu.results.Result;
import com.nwu.results.ResultCode;
import com.nwu.service.TutorInspectService;
import com.nwu.service.tutor.common.DeleteFileService;
import com.nwu.service.tutor.common.MainBoardService;
import com.nwu.service.tutor.common.TeacherInfoService;
import com.nwu.service.tutor.noInspectApply.NoFirstService;
import com.nwu.util.ResultClient;
import com.nwu.util.UpLoadFile;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.converter.StringHttpMessageConverter;
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
    //免审第一页
    @Resource
    private NoFirstService noFirstService;
    //删除文件
    @Resource
    private DeleteFileService deleteFileService;

    /**
     * 首次博士，首次学硕，首次专硕
     *
     * @param applyTypeId 申请类别Id
     * @return data
     */
    @ApiOperation("是否申请过此岗位")
    @GetMapping("/tutor/firstApply/{applyTypeId}")
    public Result firstApply(@PathVariable("applyTypeId") int applyTypeId) {
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

    /**
     * 增列博士，增列学硕，增列专硕，免审
     *
     * @param applyTypeId 申请类别Id
     * @return applyId applyCondition
     */
    @ApiOperation("是否申请申请过此类型岗位")
    @GetMapping("/tutor/addNoInspectApply/{applyTypeId}")
    public Result addApply(@PathVariable("applyTypeId") int applyTypeId) {
        //status == 0
        Apply apply = mainBoardService.getApplyByTutorIdAndApplyTypeIdAndStatus(tutorId, applyTypeId);
        HashMap<String, Object> map = new HashMap<>();
        if (apply != null) {
            // 申请过此岗位 status == 0 信息还没有填写完整 主键也返回
            map.put("applyId", apply.getApplyId());
            map.put("applyCondition", 101);
        } else {
            // 没有申请过此岗位
            map.put("applyId", -1);
            map.put("applyCondition", 102);
        }
        return new Result(ResultCode.SUCCESS, map);
    }


    /**
     * 获取导师基本信息  导师免审
     *
     * @param applyTypeId    申请类别Id
     * @param applyCondition
     * @return firstPage
     */
    @GetMapping("/tutor/getTeacherInfo/{applyTypeId}/{applyCondition}")
    public Result getTeacherInfo(@PathVariable("applyTypeId") Integer applyTypeId, @PathVariable("applyCondition") Integer applyCondition) {
        FirstPage firstPage;
        NoFirstPage noFirstPage;
        try {
            if (applyCondition == 102) {
                //未申请过 查找teacherInfo
                firstPage = teacherInfoService.getTeacherInfo(tutorId);
                return new Result(ResultCode.SUCCESS, firstPage);
            } else if (applyCondition == 101) {
                //已申请过 查询对应的主键 导师增列
                int applyId = mainBoardService.getApplyId(tutorId, applyTypeId, 0);
                if (applyTypeId == 3 || applyTypeId == 6) {
                    //导师免审 查询tutor_no_inspect
                    noFirstPage = noFirstService.getNoFirstPage(String.valueOf(applyId));
                    return new Result(ResultCode.SUCCESS, noFirstPage);
                } else {
                    //查询tutorInspect
                    firstPage = tutorInspectService.getFirstPage(String.valueOf(applyId));
                    return new Result(ResultCode.SUCCESS, firstPage);
                }
            } else {
                return Result.FAIL();
            }
        } catch (Exception e) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", 1201);
            jsonObject.put("message", "您不在此系统中，请联系系统管理员");
            jsonObject.put("errorMessage", e.getMessage());
            return new Result(ResultCode.SUCCESS, jsonObject);
        }
    }


    //导师增列
    @GetMapping("/tutor/getFirstPage/{applyCondition}/{applyId}")
    public Result getFirstPage(@PathVariable("applyCondition") Integer applyCondition, @PathVariable("applyId") Integer applyId) {
        FirstPage firstPage;
        if (applyCondition == 102) {
            //未申请过 查找teacherInfo
            firstPage = teacherInfoService.getTeacherInfo(tutorId);
        } else if (applyCondition == 101) {
            //查询tutorInspect
            firstPage = tutorInspectService.getFirstPage(String.valueOf(applyId));
        } else {
            return Result.FAIL();
        }
        return new Result(ResultCode.SUCCESS, firstPage);
    }

    /**
     * 导师免审
     * @param applyTypeId
     * @param applyCondition
     * @param applyId
     * @return
     */
    @GetMapping("/tutor/getNoFirstPage/{applyTypeId}/{applyCondition}/{applyId}")
    public Result getNoFirstPage(@PathVariable("applyTypeId") int applyTypeId, @PathVariable("applyCondition") Integer applyCondition, @PathVariable("applyId") Integer applyId) {
        FirstPage firstPage;
        NoFirstPage noFirstPage;
        try {
            if (applyCondition == 102) {
                //未申请过 查找teacherInfo
                firstPage = teacherInfoService.getTeacherInfo(tutorId);
                return new Result(ResultCode.SUCCESS, firstPage);
            }
            else if (applyCondition == 101) {
                //已申请过 查询对应的主键 导师增列
                if (applyTypeId == 3 || applyTypeId == 6) {
                    //导师免审 查询tutor_no_inspect
                    noFirstPage = noFirstService.getNoFirstPage(String.valueOf(applyId));
                    return new Result(ResultCode.SUCCESS, noFirstPage);
                } else {
                    //查询tutorInspect
                    firstPage = tutorInspectService.getFirstPage(String.valueOf(applyId));
                    return new Result(ResultCode.SUCCESS, firstPage);
                }
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
    }

    /**
     * 文件上传controller
     *
     * @param uploadFile
     * @param typeId     上传文件类别 学术论文/科研奖励等  11=博士首次申请+学术论文 41=硕士首次申请+学术论文
     * @param req
     * @return path路径
     */
    @ApiOperation("文件上传")
    @PostMapping("/user/upload/{typeId}")
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
                case 7: {
                    typeName = typeName + "免审资料";
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
                map.put("fileType", typeId);
                map.put("path", path);
                return new Result(ResultCode.SUCCESS, map);
            } else {   //路径为空
                return Result.FAIL();
            }
        }
        return Result.FAIL();
    }

    /**
     * 文件删除
     *
     * @param httpPath
     * @return Result.SUCCESS();  .FAIL()
     * @throws UnsupportedEncodingException
     */
    @ApiOperation("文件删除")
    @PostMapping("/user/delFile")
    public Result delFile(@RequestBody String httpPath) throws UnsupportedEncodingException {
        String s = deleteFileService.delFile(httpPath);
        if ("ok".equals(s)) {
            return Result.SUCCESS();
        }
        return Result.FAIL();
    }

}
