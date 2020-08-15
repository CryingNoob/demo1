package com.example.demo1.dao;

import com.example.demo1.bean.Answer;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AnswerDao {

    @Select("select * from answer where question_id = #{questionId}")

    List<Answer> getAnswer( int questionId);
}
