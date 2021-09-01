package com.nwu.entities.tutor;

/**
 * @author Rex Joush
 * @time 2021.08.30 11:08
 */

import com.nwu.entities.tutor.childSubject.CourseTeaching;
import com.nwu.entities.tutor.childSubject.DeleteItem;
import com.nwu.entities.tutor.childSubject.GuidingStudent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 添加表格的第四页教学信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FourthPage {

    private List<GuidingStudent> guidingStudents;   // 指导学生列表
    private List<CourseTeaching> courseTeachings;   // 研究生课程列表
    private List<DeleteItem> deleteItems;           // 删除信息

}
