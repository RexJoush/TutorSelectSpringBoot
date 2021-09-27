package com.nwu;

import com.alibaba.fastjson.JSON;
import com.nwu.entities.Apply;
import com.nwu.entities.tutor.SecondPage;
import com.nwu.entities.tutor.ThirdPage;
import com.nwu.service.AuthorizationService;
import com.nwu.service.TutorInspectService;
import com.nwu.service.admin.ApplyService;
import com.nwu.service.tutor.common.SecondService;
import com.nwu.service.tutor.common.ThirdService;
import com.nwu.util.AESUtil;
import com.nwu.vo.QueryDepartmentSecretaryInit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@SpringBootTest
class TutorSelectSpringBootApplicationTests {

    @Value("${ImagePath}")
    private String imagePath;
    @Resource
    private TutorInspectService tutorInspectService;

    @Resource
    private ThirdService thirdService;

    @Resource
    private SecondService secondService;

    @Resource
    private ApplyService applyService;

    @Resource
    private AuthorizationService authorizationService;


    @Test
    void contextLoads() throws Exception {
//        "10-15-16-17-18"


//        String hello = AESUtil.encode("hello");
//        System.out.println("hello: " + hello);
//        System.out.println(AESUtil.decode(hello));
//        System.out.println(AESUtil.decode("3c/621Azt7nS/Xgdp2ToMQ=="));


//        SecondPage secondPage = secondService.getSecondPage(102);
//        System.out.println(secondPage);
//        System.out.println(secondPage.getExpertTitlesJson());
//        System.out.println(secondPage.getExpertTitlesJson().equals("[]"));
//
//        System.out.println(secondPage.getGroupsOrPartTimeJobs());
//        System.out.println(secondPage.getGroupsOrPartTimeJobs() == null);

    }

}
