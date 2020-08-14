package com.example.demo1.dao;

import com.example.demo1.bean.Collect;
import com.example.demo1.bean.Like;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LikeDao {
    @Select("select * from Like_and_Collect where Article_id =#{articleId} and Like_or_collect  =0")
    List<Like> getLike(int articleId);
}
