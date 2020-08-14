package com.example.demo1.serviceImpl;

import com.example.demo1.bean.Answer;
import com.example.demo1.dao.AnswerDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AnswerServiceImpl {
    private AnswerDao answerDao;
    @Resource
    public void setAnswer(AnswerDao answerDao){
        this.answerDao= answerDao;
    }
    List<Answer> getAnswer(int questionId){
        return answerDao.getAnswer();
    }

}
