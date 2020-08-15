package com.example.demo1.dao;

import com.example.demo1.bean.Collect;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CollectDao {
    @Select("select * from Like_and_Collect where Article_id =#{articleId} and Like_or_collect  =1")
    List<Collect> getCollect( int articleId);
}
