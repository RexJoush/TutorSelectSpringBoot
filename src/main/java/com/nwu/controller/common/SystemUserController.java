package com.nwu.controller.common;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nwu.entities.SystemUser;
import com.nwu.service.common.impl.SystemUserServiceImpl;
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
 *  前端控制器
 * </p>
 *
 * @author dynamic
 * @since 2021-08-10
 */
@RestController
@RequestMapping("/system-user")
public class SystemUserController {
    @Autowired
    private SystemUserServiceImpl systemUserService;

    @ApiOperation(value = "获取所有系统用户")
    @GetMapping("/getAll")
    public Map<String,Object> getAll(UserQuery query) {
        Page page = new Page();
        QueryWrapper<SystemUser> queryWrapper = new QueryWrapper<>();
        if(query!=null && query.getPageSize()>0 && query.getPageNum()>0) {
            page.setSize(query.getPageSize());
            page.setCurrent(query.getPageNum());
        }
        if(query.getUserName()!=null) {
            queryWrapper.eq("user_name",query.getUserName());
        }
        if(query.getUserRole()!=null) {
            queryWrapper.eq("role_name",query.getUserRole());
        }
        if(query.getUserId()!=null) {
            queryWrapper.eq("number",query.getUserId());
        }
        if(query.getOrganization()!=null) {
            queryWrapper.eq("organization",query.getOrganization());
        }
        if(query.getCreateTime()!=null) {
            queryWrapper.eq("create_time", TimeUtils.sdf.format(new Date(query.getCreateTime())));
        }
        IPage pages = systemUserService.page(page,queryWrapper);
        List<SystemUser> list = pages.getRecords();
        long total = pages.getTotal();
        long pageNum = pages.getCurrent();
        long pageSize = pages.getSize();
        List<UserVo> userVos = new ArrayList<>();
        Map<String,Object> res = new HashMap<>();
        if(list!=null) {
            for (SystemUser systemUser : list) {
                UserVo userVo = new UserVo();
                userVo.setUserId(systemUser.getNumber());
                userVo.setUserName(systemUser.getUserName());
                userVo.setUserRole(systemUser.getRoleName());
                userVo.setStatus(systemUser.getStatus());
                userVo.setCreateTime(systemUser.getCreateTime());
                userVo.setMr("mr");
                userVo.setOrganization(systemUser.getOrganization());
                userVos.add(userVo);
            }
        }
        res.put("users",userVos);
        res.put("pageSize",pageSize);
        res.put("total",total);
        res.put("pageNum",pageNum);
        return res;
    }

    @ApiOperation("新增系统用户")
    @PostMapping("/addUser")
    public String saveUser(@RequestBody UserVo userVo) {
        SystemUser user = new SystemUser();
        user.setUserName(userVo.getUserName());
        user.setNumber(userVo.getUserId());
        user.setRoleName(userVo.getUserRole());
        user.setCreateTime(TimeUtils.sdf.format(new Date()));
        user.setStatus(0);
        boolean res = systemUserService.save(user);
        if(res) {
            return "200";
        }else{
            return "201";
        }
    }
    @ApiOperation("修改系统用户状态")
    @PostMapping("/updateUser")
    public String updateUserStatus(@RequestBody UserVo userVo) {
        SystemUser user = new SystemUser();
        user.setUserName(userVo.getUserName());
        user.setNumber(userVo.getUserId());
        user.setRoleName(userVo.getUserRole());
        user.setCreateTime(userVo.getCreateTime());
        user.setStatus(userVo.getStatus());
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("number",userVo.getUserId());
        boolean res = systemUserService.update(user,queryWrapper);
        if(res) {
            return "200";
        }else{
            return "201";
        }
    }
    @ApiOperation("删除系统用户状态")
    @PostMapping("/delUser/{userId}")
    public String delUser(@PathVariable String userId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("number",userId);
        boolean res = systemUserService.remove(queryWrapper);
        if(res) {
            return "200";
        }else{
            return "201";
        }
    }
    @Transactional
    @ApiOperation("删除系统用户状态")
    @PostMapping("/delUsers")
    public String delUsers(@RequestBody ArrayList<String> userId) {
        boolean res = true;
        for(String id:userId) {
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("number", id);
            res =  systemUserService.remove(queryWrapper);
        }
        if(res) {
            return "200";
        }else{
            return "201";
        }
    }
}

