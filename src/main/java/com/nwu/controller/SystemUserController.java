package com.nwu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nwu.entities.SystemUser;
import com.nwu.results.Result;
import com.nwu.results.ResultCode;
import com.nwu.service.impl.SystemUserServiceImpl;
import com.nwu.util.TimeUtils;
import com.nwu.vo.UserQuery;
import com.nwu.vo.UserVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    private SystemUserServiceImpl systemUserService;

    @ApiOperation(value = "获取所有系统用户")
    @GetMapping("/getAll")
    public Result getAll(UserQuery query) {
        Page page = new Page();
        QueryWrapper<SystemUser> queryWrapper = new QueryWrapper<>();
        if (query != null && query.getPageSize() > 0 && query.getPageNum() > 0) {
            page.setSize(query.getPageSize());
            page.setCurrent(query.getPageNum());
        }
        if (query.getUserName() != null) {
            queryWrapper.eq("user_name", query.getUserName());
        }
        if (query.getUserRole() != null) {
            queryWrapper.eq("role_name", query.getUserRole());
        }
        if (query.getUserId() != null) {
            queryWrapper.eq("tutor_id", query.getUserId());
        }
        if (query.getOrganization() != null) {
            queryWrapper.eq("organization", query.getOrganization());
        }
        if (query.getCreateTime() != null) {

            queryWrapper.like("create_time", query.getCreateTime());
        }
        IPage pages = systemUserService.page(page, queryWrapper);
        List<SystemUser> list = pages.getRecords();
        long total = pages.getTotal();
        long pageNum = pages.getCurrent();
        long pageSize = pages.getSize();
        List<UserVo> userVos = new ArrayList<>();
        Map<String, Object> res = new HashMap<>();
        if (list != null) {
            for (SystemUser systemUser : list) {
                UserVo userVo = new UserVo();
                userVo.setUserId(systemUser.getTutorId());
                userVo.setUserName(systemUser.getUserName());
                userVo.setUserRole(systemUser.getRoleName());
                userVo.setStatus(systemUser.getStatus());
                userVo.setCreateTime(systemUser.getCreateTime());
                userVo.setMr("mr");
                userVo.setOrganization(systemUser.getOrganization());
                userVos.add(userVo);
            }
        }
        res.put("users", userVos);
        res.put("pageSize", pageSize);
        res.put("total", total);
        res.put("pageNum", pageNum);
        return new Result(ResultCode.SUCCESS,res);
    }

    @ApiOperation("新增系统用户")
    @PostMapping("/addUser")
    public Result saveUser(@RequestBody UserVo userVo) {
        SystemUser user = new SystemUser();
        user.setUserName(userVo.getUserName());
        user.setTutorId(userVo.getUserId());
        user.setRoleName(userVo.getUserRole());
        user.setCreateTime(TimeUtils.sdf.format(new Date()));
        user.setStatus(0);
        boolean res = systemUserService.save(user);
        String s = "";
        if (res) {
           s = "200";
        } else {
           s =  "201";
        }
        return new Result(ResultCode.SUCCESS,s);
    }

    @ApiOperation("修改系统用户状态")
    @PostMapping("/updateUser")
    public Result updateUserStatus(@RequestBody UserVo userVo) {
        SystemUser user = new SystemUser();
        user.setUserName(userVo.getUserName());
        user.setTutorId(userVo.getUserId());
        user.setRoleName(userVo.getUserRole());
        user.setCreateTime(userVo.getCreateTime());
        user.setStatus(userVo.getStatus());
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("tutor_id", userVo.getUserId());
        boolean res = systemUserService.update(user, queryWrapper);
        String s = "";
        if (res) {
            s =  "20000";
        } else {
            s = "20001";
        }
        return new Result(ResultCode.SUCCESS,s);

    }

    @ApiOperation("删除系统用户状态")
    @PostMapping("/delUser/{userId}")
    public Result delUser(@PathVariable String userId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("tutor_id", userId);
        boolean res = systemUserService.remove(queryWrapper);
        String s = "";
        if (res) {
            s =  "20000";
        } else {
            s = "20001";
        }
        return new Result(ResultCode.SUCCESS,s);
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
            s =  "20000";
        } else {
            s = "20001";
        }
        return new Result(ResultCode.SUCCESS,s);
    }
}

