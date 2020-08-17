package com.example.demo1.serviceImpl;

import com.example.demo1.bean.QuestionTag;
import com.example.demo1.dao.QuestionTagDao;
import com.example.demo1.service.QuestionTagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class QuestionTagServiceImpl  implements QuestionTagService {

    private QuestionTagDao questionTagDao;
    @Resource
    public void setQuestionTagDao(QuestionTagDao questionTagDao) {
        this.questionTagDao = questionTagDao;
    }

    @Override
    public List<QuestionTag> getQuestionTag(int id) {
        return questionTagDao.getQuestionTag(id);

    }
}
