package com.example.demo1.dao;

import com.example.demo1.bean.Answer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AnswerDao {

    @Select("select * from answer where question_id = #{questionId}")

    List<Answer> getAnswer( int questionId);
    //int answerId,userid,questionId;
    //    String answerContent,answerDate,username;

    @Insert("insert into answer(answer_id,userid,question_id,answer_content,answer_date) " +
            "values(#{answerId},#{userid},#{questionId},#{answerContent})")
    boolean addAnswer(Answer answer);
}
