package com.nwu;

import com.alibaba.fastjson.JSON;
import com.nwu.entities.Apply;
import com.nwu.entities.tutor.SecondPage;
import com.nwu.entities.tutor.ThirdPage;
import com.nwu.service.TutorInspectService;
import com.nwu.service.admin.ApplyService;
import com.nwu.service.tutor.common.SecondService;
import com.nwu.service.tutor.common.ThirdService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class TutorSelectSpringBootApplicationTests {

    @Resource
    private TutorInspectService tutorInspectService;

    @Resource
    private ThirdService thirdService;

    @Resource
    private SecondService secondService;

    @Resource
    private ApplyService applyService;

    @Test
    void contextLoads() {

        SecondPage second = tutorInspectService.getTutorInspectSecond(105);
        System.out.println(second.getDoctoralMasterSubjectCode());
        System.out.println(second.getDoctoralMasterSubjectCode() == null);


//        SecondPage secondPage = secondService.getSecondPage(102);
//        System.out.println(secondPage);
//        System.out.println(secondPage.getExpertTitlesJson());
//        System.out.println(secondPage.getExpertTitlesJson().equals("[]"));
//
//        System.out.println(secondPage.getGroupsOrPartTimeJobs());
//        System.out.println(secondPage.getGroupsOrPartTimeJobs() == null);

    }

}
