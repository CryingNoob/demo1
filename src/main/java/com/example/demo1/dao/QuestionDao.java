package com.example.demo1.dao;

import com.example.demo1.bean.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionDao {
    @Select("select * from question")
    List<Question> getAllQuestion();

//    @Insert("insert into question(question_id,question_author,question_date,question_content)" +
//            "values(#{questionId},#{questionAuthor},#{questionDate},#{questionContent})")
//    Boolean addQuestion(Question question);

    @Insert("insert into question(question_author,question_date,question_content,answer_number)" +
            "values(#{questionAuthor},#{questionDate},#{questionContent},#{answerNumber})")
    Boolean addQuestion(Question question);
}
