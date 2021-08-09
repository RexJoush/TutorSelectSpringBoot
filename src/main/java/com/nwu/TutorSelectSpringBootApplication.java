package com.nwu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin // 配置跨域支持
@SpringBootApplication
public class TutorSelectSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(TutorSelectSpringBootApplication.class, args);
    }

}
