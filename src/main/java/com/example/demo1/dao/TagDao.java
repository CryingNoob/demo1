package com.example.demo1.dao;

import com.example.demo1.bean.Tag;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TagDao {
    @Select("select * from tag where tag_id= #{tagId}")
    Tag getTag( int tagId);
}
