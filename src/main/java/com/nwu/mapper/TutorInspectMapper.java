package com.nwu.mapper;

import com.nwu.entities.TutorInspect;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nwu.entities.tutor.FirstPage;
import com.nwu.entities.tutor.SecondPage;
import com.nwu.vo.TutorQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  导师非免审信息表 Mapper 接口
 * </p>
 *
 * @author dynamic
 * @since 2021-08-09
 */
@Mapper
public interface TutorInspectMapper extends BaseMapper<TutorInspect> {

    List<TutorInspect> selectByQuery(TutorQuery tutorQuery);

    int saveTutorInspectBaseInfo(@Param("firstPage") FirstPage firstPage);

    SecondPage getTutorInspectSecond(int id);


    int updateTutorInspectSecond(@Param("id") int id, @Param("secondPage") SecondPage secondPage);

}
