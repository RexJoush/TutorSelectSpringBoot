package com.nwu;

import com.alibaba.fastjson.JSON;
import com.nwu.entities.tutor.ThirdPage;
import com.nwu.service.tutor.common.ThirdService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class TutorSelectSpringBootApplicationTests {

    @Resource
    private ThirdService thirdService;

    @Test
    void contextLoads() {

        //ThirdPage thirdPage = thirdService.getThirdPage(66, "20133220");
        //System.out.println(JSON.toJSONString(thirdPage));
        try {
            test();
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
    }

    public void test(){
        try {
            int i = 10 / 0;
        }catch (Exception e){
            throw new RuntimeException("除数为0");
        }
    }

}
