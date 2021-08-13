package com.nwu.controller;


import com.nwu.entities.SystemTime;
import com.nwu.service.impl.SystemTimeServiceImpl;
import com.nwu.util.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dynamic
 * @since 2021-08-09
 */
@RestController
@RequestMapping("/system-time")
public class SystemTimeController {
    @Autowired
    private SystemTimeServiceImpl systemTimeService;
    @GetMapping("/save/{time}")
    public String saveTime(@PathVariable String time){
        System.out.println(time);
        String[] times = time.split(",");
        SystemTime systemTime = new SystemTime();
        String startTime =TimeUtils.sdf.format(new Date(times[0]));
        String endTime =TimeUtils.sdf.format(new Date(times[0]));
        systemTime.setStartTime(startTime);
        systemTime.setEndTime(endTime);
        boolean res = systemTimeService.save(systemTime);
        if(res)
            return "200";
        else
            return "201";

    }
}

