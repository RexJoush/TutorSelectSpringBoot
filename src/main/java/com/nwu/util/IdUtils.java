package com.nwu.util;

/**
 * @author Rex Joush
 * @time 2021.09.16 16:03
 */

import javax.servlet.http.HttpServletRequest;

/**
 * 获取统一认证中教师的工号
 */
public class IdUtils {

    /**
     * 获取统一身份认证所提供的工号
     * @param request request 的请求对象
     * @return 工号
     */
    public static String getTutorId(HttpServletRequest request) {
        return "20131723";
    }

}
