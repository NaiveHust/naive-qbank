package com.naive.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.naive.domain.Paper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YechenGu
 * @date 2021/6/28 4:25 下午
 */
@Repository
public interface PaperMapper extends BaseMapper<Paper> {
    @Select("select pro_no from paperpro where paper_no=#{paperNo}")
    List<Integer> findQuestions(@Param("paperNo") int paperNo);

    @Insert("insert into paperpro values (#{paperNo},#{proNo})")
    int addQuestion(@Param("paperNo")int paperNo,@Param("proNo")int proNo);

    @Delete("delete from paperpro where paper_no=#{paperNo} and pro_no=#{proNo}")
    int deleteQuestion(@Param("paperNo")int paperNo,@Param("proNo")int proNo);

    @Delete("delete from paperpro where paper_no=#{paperNo}")
    int deleteQuestions(@Param("paperNo")int paperNo);
}
