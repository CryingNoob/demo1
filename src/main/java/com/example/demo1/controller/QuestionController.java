package com.example.demo1.controller;

import com.example.demo1.bean.*;
import com.example.demo1.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class QuestionController {
    private AnswerService answerService;
    @Resource
    public void setAnswerService(AnswerService answerService) {
        this.answerService = answerService;
    }

    private TagService tagService;
    @Resource
    public void setTagService(TagService tagService) {
        this.tagService = tagService;
    }

    private QuestionTagService questionTagService;
    @Resource
    public void setQuestionTagService(QuestionTagService questionTagService) {
        this.questionTagService = questionTagService;
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
//int questionId;
//    String questionAuthor;
//    String questionContent;
//    String questionDate;
//    int answerNumber;
//    List<Tag> questionTag;
//    List<Answer> answerContent;

    @GetMapping("question/getAllQuestions")
    List<Question> getAllQuestions(){
        List<Question> res=null;
        List<Tag> tag=new ArrayList<Tag>();
        List<Answer> answerContent=new ArrayList<Answer>();
        try{

            res = questionService.getAllQuestion();

            for(Question question : res){

                List<QuestionTag> questionTagList = questionTagService.getQuestionTag(question.getQuestionId());
                for(QuestionTag tag1 : questionTagList){

                    tag.add(tagService.getTag(tag1.getTagId()));

                }

                question.setQuestionTag(tag);

                answerContent = answerService.getAnswer(question.getQuestionId());
                for(Answer answer : answerContent){
                   // System.out.println(answer.toString());
                    User tempUser = new User();
                    tempUser= userService.getUser(answer.getuserid());
                   // System.out.println(answer.getuserid());
                   // System.out.println(tempUser.toString());
                    String tmpname = tempUser.getusername();
                    answer.setusername(tmpname);
                }

                question.setAnswerContent(answerContent);
            }

        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        System.out.println(res.toString());
        return res;
    }

    @PostMapping("question/writeAnswer")
    public boolean writeAnswer(@RequestBody Answer answer){

        boolean res=false;
        try{
            res=answerService.addAnswer(answer);
        }catch ( Exception e){
            System.out.println("error at WriteAnswer");
            e.printStackTrace();

        }
        return res;

    }


}
