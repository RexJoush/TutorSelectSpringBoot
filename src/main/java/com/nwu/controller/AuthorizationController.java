package com.nwu.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nwu.service.AuthorizationService;
import com.nwu.util.AESUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Rex Joush
 * @time 2021.08.24 20:46
 */

@RestController
@RequestMapping("/user")
public class AuthorizationController {

    @Resource
    private AuthorizationService authorizationService;

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> body) {


        // 获取到登录名
        String username = body.get("username");

        JSONObject object = new JSONObject();
        // 将学号加密后写入 token
        object.put("code", 20000);
        object.put("data", Map.of("token", AESUtil.encode(username)));

        return JSON.toJSONString(object);
    }

    @GetMapping("/info")
    public String info(@RequestParam("token") String token) {

        System.out.println(token);
        // 解密 token 值拿到学号
        String decode = AESUtil.decode(token);

        List<String> roles = new ArrayList<>();

        String authorization = authorizationService.getAuthorization(decode);

        roles.add(authorization);

        JSONObject object = new JSONObject();
        object.put("code", 20000);
        object.put("data", Map.of("roles", roles));

        return JSON.toJSONString(object);

    }

    @PostMapping("/logout")
    public Map<String, Object> logout(){

        Map<String, Object> result = new HashMap<>();

        result.put("code", 20000);
        result.put("data", "success");

        return result;
    }

}
