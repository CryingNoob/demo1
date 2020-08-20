package com.example.demo1.dao;

import com.example.demo1.bean.ArticleTag;
import com.example.demo1.bean.QuestionTag;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionTagDao {

    @Select("select * from question_tag where question_id = #{id}")
    List<QuestionTag> getQuestionTag(int id);


    @Insert("insert into question_tag(question_id,tag_id) values(#{questionId},#{tagId})")
    boolean insertArticleTag(QuestionTag questionTag);
}
