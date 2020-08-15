package com.example.demo1.dao;

import com.example.demo1.bean.ArticleTag;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleTagDao {
    @Select("select * from article_tag where article_id = #{id}")
    List<ArticleTag> getArticleTag(int id);
}
