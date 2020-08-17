package com.example.demo1.controller;

import com.example.demo1.bean.Question;
import com.example.demo1.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class QuestionController {

    private TagService tagService;
    @Resource
    public void setTagService(TagService tagService) {
        this.tagService = tagService;
    }

    private UserService userService;
    @Resource
    public  void setUserService(UserService userService){
        this.userService = userService;
    }

    private QuestionService questionService;
    @Resource
    public void setQuestionService(QuestionService questionService){
        this.questionService = questionService;

    }

    @PostMapping("question/getAllQuestions")
    List<Question> getAllQuestions(){
        List<Question> res=null;
       res = questionService.getAllQuestion();

        return res;
    }



}
