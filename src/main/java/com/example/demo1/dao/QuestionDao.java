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

    @Insert("insert into question(question_id,question_author,question_date,question_content)" +
            "values(#{questionId},#{questionAuthor},#{questionDate},#{questionDate},#{questionContent}")
    Boolean addQuestion(Question question);
}
