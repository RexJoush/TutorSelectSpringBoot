package com.nwu.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/user")
public class TestController {

    @PostMapping("/login")
    public String login() {
        HashMap<String, Object> response = new HashMap<>();
        HashMap<String, Object> responseData = new HashMap<>();
        responseData.put("token", "admin");
        response.put("code", 20000);
        response.put("msg", "登录成功");
        response.put("data", responseData);
        System.out.println("****************");
        return JSON.toJSONString(response);
    }

    @GetMapping("/info")
    public String info() {
        HashMap<String, Object> responseInfo = new HashMap<>();
        HashMap<String, Object> responseData = new HashMap<>();
        responseData.put("roles", "[admin]");
        responseData.put("name", "zjz");
        responseData.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif?imageView2/1/w/80/h/80");
        responseInfo.put("data", responseData);
        responseData.put("roles", "admin");
        responseData.put("name", "Super admin");
        responseData.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        responseInfo.put("code", 20000);
        responseInfo.put("msg", "登录成功");
        responseInfo.put("data", responseData);
        return JSON.toJSONString(responseInfo);
    }
}
