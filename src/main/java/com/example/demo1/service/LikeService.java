package com.example.demo1.service;

import com.example.demo1.bean.Like;
import org.springframework.stereotype.Service;

import java.util.List;

public interface LikeService {
    List<Like> getLike(int articleId);
}
