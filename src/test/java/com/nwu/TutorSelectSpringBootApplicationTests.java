package com.nwu;

import com.nwu.entities.tutor.SecondPage;
import com.nwu.mapper.TutorInspectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class TutorSelectSpringBootApplicationTests {

    @Resource
    private TutorInspectMapper tutorInspectMapper;

    @Test
    void contextLoads() {
        SecondPage tutorInspectSecond = tutorInspectMapper.getTutorInspectSecond(66);
        System.out.println(tutorInspectSecond);
    }

}
