package com.example.demo1.service;

import com.example.demo1.bean.Question;
import org.springframework.stereotype.Service;

import java.util.List;

public interface QuestionService {
    List<Question> getAllQuestion();
}
