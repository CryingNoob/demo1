package com.example.demo1.serviceImpl;

import com.example.demo1.bean.Question;
import com.example.demo1.dao.QuestionDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class QuestionServiceImpl {
    private QuestionDao questionDao;
    @Resource
    public void setQuestionDao(QuestionDao questionDao){
        this.questionDao=questionDao;
    }

    public List<Question> getAllQuestion(){
        return  questionDao.getAllQuestion();
    }


}
