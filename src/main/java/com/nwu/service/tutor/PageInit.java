package com.nwu.service.tutor;

/**
 * @author Rex Joush
 * @time 2021.09.02 10:25
 */

import com.nwu.entities.tutor.FourthPage;
import com.nwu.entities.tutor.ThirdPage;

import java.util.ArrayList;

/**
 * 获取某些页面的初始化信息
 */
public class PageInit {

    /**
     * 获取第三页的初始化空对象
     * @return 第三页空对象
     */
    public static ThirdPage getThirdPage(){
        ThirdPage thirdPage = new ThirdPage();

        thirdPage.setAcademicPapers(new ArrayList<>());
        thirdPage.setResearchProjects(new ArrayList<>());
        thirdPage.setAcademicWorks(new ArrayList<>());
        thirdPage.setTeachingAwards(new ArrayList<>());
        thirdPage.setInventionPatents(new ArrayList<>());
        thirdPage.setDeleteItems(new ArrayList<>());

        return thirdPage;
    }

    /**
     * 获取第四页的初始化空对象
     * @return 第四页空对象
     */
    public static FourthPage getFourthPage(){
        FourthPage fourthPage = new FourthPage();

        fourthPage.setGuidingStudents(new ArrayList<>());
        fourthPage.setDoctorStudents(new ArrayList<>());
        fourthPage.setAssistDoctorStudents(new ArrayList<>());
        fourthPage.setMasterStudents(new ArrayList<>());
        fourthPage.setAssistMasterStudents(new ArrayList<>());
        fourthPage.setUndergraduateStudents(new ArrayList<>());
        fourthPage.setDeleteItems(new ArrayList<>());

        return fourthPage;
    }

}
