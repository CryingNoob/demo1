package com.example.demo1.service;

import com.example.demo1.bean.Collect;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CollectService {
    List<Collect> getCollect(int articleId);
    boolean addCollect(int articleId, int userId);
    boolean deleteCollect(int articleId, int userId);
}
