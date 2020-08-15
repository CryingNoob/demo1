package com.example.demo1.service;

import com.example.demo1.bean.Answer;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AnswerService {
    List<Answer> getAnswer( int questionId);
}
