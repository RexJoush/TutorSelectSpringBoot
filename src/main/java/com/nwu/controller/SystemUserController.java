package com.nwu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nwu.entities.SystemUser;
import com.nwu.results.Result;
import com.nwu.results.ResultCode;
import com.nwu.service.SystemUserService;
import com.nwu.service.impl.SystemUserServiceImpl;
import com.nwu.util.TimeUtils;
import com.nwu.vo.UserQuery;
import com.nwu.vo.UserVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author dynamic
 * @since 2021-08-10
 */
@RestController
@RequestMapping("/admin/system-user")
public class SystemUserController {

    @Resource
    private SystemUserService systemUserService;

    /**
     * 获取用户，包括查询
     * @param query 查询条件
     */
    @PostMapping("/getAll")
    public Result getAll(@RequestBody UserQuery query) {

        Page<SystemUser> page = systemUserService.getAll(query);
        Map<String, Object> res = new HashMap<>();

        res.put("users", page.getRecords());
        res.put("total", page.getTotal());
        return new Result(ResultCode.SUCCESS, res);
    }

    /**
     * 模糊查询工号
     * @param tutorId 工号
     */
    @GetMapping("/getQueryTutorId/{tutorId}")
    public Result getQueryTutorId(@PathVariable("tutorId") String tutorId) {
        List<String> tutorIds = systemUserService.getQueryTutorId(tutorId);
        return new Result(ResultCode.SUCCESS, tutorIds);
    }

    /**
     * 根据工号获取详细信息
     * @param tutorId 工号
     */
    @GetMapping("/getSystemUserByTutorId/{tutorId}")
    public Result getSystemUserByTutorId(@PathVariable("tutorId") String tutorId) {

        SystemUser user = systemUserService.getSystemUserByTutorId(tutorId);

        return new Result(ResultCode.SUCCESS, user);
    }


    /**
     * 添加用户
     * @param systemUser 用户信息
     * @param roleId 用户角色 id
     */
    @PostMapping("/addSystemUser/{roleId}")
    public Result saveUser(@RequestBody SystemUser systemUser,
                           @PathVariable("roleId") int roleId) {

        System.out.println(systemUser);
        System.out.println(roleId);

        SystemUser user = systemUserService.getById(systemUser.getTutorId());

        if (user != null) {
            // 如果当前查到的用户，status 为 1，则提示已经存在
            if (user.getStatus() == 1) {
                return new Result(ResultCode.FAIL);
            }
            // 否则，表示此用户被删除，将此用户 status 更新为 1
            else {
                UpdateWrapper<SystemUser> wrapper = new UpdateWrapper<>();
                wrapper.set("status", 1);
                wrapper.eq("tutor_id", user.getTutorId());
                systemUserService.update(wrapper);
                return new Result(ResultCode.SUCCESS);
            }
        } else {
            systemUser.setRoleId(roleId);
            switch (roleId) {
                case 1: systemUser.setRoleName("导师"); break;
                case 2: systemUser.setRoleName("院系秘书"); break;
                case 4: systemUser.setRoleName("研究生院专硕管理员"); break;
                case 5: systemUser.setRoleName("研究生院学硕管理员"); break;
                case 6: systemUser.setRoleName("社科处管理员"); break;
                case 7: systemUser.setRoleName("科研处管理员"); break;
            }
            systemUser.setStatus(1);
            systemUser.setCreateTime(TimeUtils.sdf.format(new Date()));
            systemUserService.save(systemUser);
            return new Result(ResultCode.SUCCESS);
        }
    }

    /**
     * 编辑用户的角色
     * @param tutorId 工号
     * @param roleId 新角色 id
     */
    @GetMapping("/editSystemUser/{tutorId}/{roleId}")
    public Result editSystemUser(@PathVariable("tutorId") String tutorId,
                                 @PathVariable("roleId") int roleId){

        UpdateWrapper<SystemUser> wrapper = new UpdateWrapper<>();
        wrapper.set("role_id", roleId);
        wrapper.eq("tutor_id", tutorId);
        switch (roleId) {
            case 1: wrapper.set("role_name", "导师"); break;
            case 2: wrapper.set("role_name", "院系秘书"); break;
            case 4: wrapper.set("role_name", "研究生院专硕管理员"); break;
            case 5: wrapper.set("role_name", "研究生院学硕管理员"); break;
            case 6: wrapper.set("role_name", "社科处管理员"); break;
            case 7: wrapper.set("role_name", "科研处管理员"); break;
        }
        systemUserService.update(wrapper);

        return new Result(ResultCode.SUCCESS);

    }

    /**
     * 删除用户，将此用户的 status 置为 0
     * @param tutorId 工号
     */
    @GetMapping("/deleteSystemUser/{tutorId}")
    public Result deleteSystemUser(@PathVariable("tutorId") String tutorId){

        UpdateWrapper<SystemUser> wrapper = new UpdateWrapper<>();
        wrapper.set("role_name", "导师");
        wrapper.set("role_id", 1);
        wrapper.eq("tutor_id", tutorId);
        systemUserService.update(wrapper);

        return new Result(ResultCode.SUCCESS);

    }

//    @ApiOperation("修改系统用户状态")
//    @PostMapping("/updateUser")
//    public Result updateUserStatus(@RequestBody UserVo userVo) {
//        SystemUser user = new SystemUser();
//        user.setName(userVo.getUserName());
//        user.setTutorId(userVo.getUserId());
//        user.setRoleId(Integer.parseInt(userVo.getUserRole()));
//        user.setCreateTime(userVo.getCreateTime());
//        user.setStatus(userVo.getStatus());
//        //   boolean res = systemUserService.updateUserByUserId(user);
//        boolean res = true;
//        String s = "";
//        if (res) {
//            s = "20000";
//        } else {
//            s = "20001";
//        }
//        return new Result(ResultCode.SUCCESS, s);
//    }
//
//    @ApiOperation("删除系统用户状态")
//    @PostMapping("/delUser/{userId}")
//    public Result delUser(@PathVariable String userId) {
//        QueryWrapper queryWrapper = new QueryWrapper();
//        queryWrapper.eq("tutor_id", userId);
//        boolean res = systemUserService.remove(queryWrapper);
//        String s = "";
//        if (res) {
//            s = "20000";
//        } else {
//            s = "20001";
//        }
//        return new Result(ResultCode.SUCCESS, s);
//    }
//
//    @Transactional
//    @ApiOperation("删除系统用户状态")
//    @PostMapping("/delUsers")
//    public Result delUsers(@RequestBody ArrayList<String> userId) {
//        boolean res = true;
//        for (String id : userId) {
//            QueryWrapper queryWrapper = new QueryWrapper();
//            queryWrapper.eq("tutor_id", id);
//            res = systemUserService.remove(queryWrapper);
//        }
//        String s = "";
//        if (res) {
//            s = "20000";
//        } else {
//            s = "20001";
//        }
//        return new Result(ResultCode.SUCCESS, s);
//    }
}

