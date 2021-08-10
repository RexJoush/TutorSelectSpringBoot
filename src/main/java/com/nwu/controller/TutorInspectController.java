package com.nwu.controller;


import com.nwu.entity.Role;
import com.nwu.entity.TutorInspect;
import com.nwu.service.impl.TutorInspectServiceImpl;
import com.nwu.vo.UserVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dynamic
 * @since 2021-08-09
 */
@RestController
@RequestMapping("/tutor-inspect")
public class TutorInspectController {
    @Autowired
    private TutorInspectServiceImpl tutorInspectService;
    @ApiOperation(value = "获取所有用户")
    @GetMapping("/getAll")
    public List<UserVo> getAll() {
        List<TutorInspect>  list = tutorInspectService.list(null);
        List<UserVo> userVos = new ArrayList<>();
        if(list!=null) {
            for (TutorInspect tutorInspect : list) {
                UserVo userVo = new UserVo();
                userVo.setUserId(tutorInspect.getNumber());
                userVo.setUserName(tutorInspect.getName());
                userVo.setUserRole("秘书");
                userVo.setStatus("1");
                userVo.setCreateTime("1");
                userVo.setMr("mr");
                userVo.setOrganization("信科");
                userVos.add(userVo);
            }
        }
        return userVos;
    }
}

