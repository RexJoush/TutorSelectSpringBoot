package com.nwu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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

    @ApiOperation(value = "获取所有系统用户")
    @PostMapping("/getAll")
    public Result getAll(@RequestBody UserQuery query) {

        System.out.println(query);


        Page<SystemUser> page = systemUserService.getAll(query);
        Map<String, Object> res = new HashMap<>();

        res.put("users", page.getRecords());
        res.put("total", page.getTotal());
        return new Result(ResultCode.SUCCESS, res);
    }

    @ApiOperation("新增系统用户")
    @PostMapping("/addUser")
    public Result saveUser(@RequestBody UserVo userVo) {
        SystemUser user = new SystemUser();
        user.setName(userVo.getUserName());
        user.setTutorId(userVo.getUserId());
        user.setRoleName(userVo.getUserRole());
        user.setCreateTime(TimeUtils.sdf.format(new Date()));
        user.setStatus(0);
        boolean res = systemUserService.save(user);
        String s = "";
        if (res) {
            s = "200";
        } else {
            s = "201";
        }
        return new Result(ResultCode.SUCCESS, s);
    }

    @ApiOperation("修改系统用户状态")
    @PostMapping("/updateUser")
    public Result updateUserStatus(@RequestBody UserVo userVo) {
        SystemUser user = new SystemUser();
        user.setName(userVo.getUserName());
        user.setTutorId(userVo.getUserId());
        user.setRoleId(Integer.parseInt(userVo.getUserRole()));
        user.setCreateTime(userVo.getCreateTime());
        user.setStatus(userVo.getStatus());
        //   boolean res = systemUserService.updateUserByUserId(user);
        boolean res = true;
        String s = "";
        if (res) {
            s = "20000";
        } else {
            s = "20001";
        }
        return new Result(ResultCode.SUCCESS, s);
    }

    @ApiOperation("删除系统用户状态")
    @PostMapping("/delUser/{userId}")
    public Result delUser(@PathVariable String userId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("tutor_id", userId);
        boolean res = systemUserService.remove(queryWrapper);
        String s = "";
        if (res) {
            s = "20000";
        } else {
            s = "20001";
        }
        return new Result(ResultCode.SUCCESS, s);
    }

    @Transactional
    @ApiOperation("删除系统用户状态")
    @PostMapping("/delUsers")
    public Result delUsers(@RequestBody ArrayList<String> userId) {
        boolean res = true;
        for (String id : userId) {
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("tutor_id", id);
            res = systemUserService.remove(queryWrapper);
        }
        String s = "";
        if (res) {
            s = "20000";
        } else {
            s = "20001";
        }
        return new Result(ResultCode.SUCCESS, s);
    }
}

