package com.example.demo1.service;

import com.example.demo1.bean.Collect;

import java.util.List;

public interface CollectService {
    List<Collect> getAllCollect(int articleId);
}
