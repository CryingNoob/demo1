package com.example.demo1.dao;

import com.example.demo1.bean.Collect;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CollectDao {
    @Select("select * from Like_and_Collect where Article_id =#{articleId} and Like_or_collect  =1")
    List<Collect> getCollect( int articleId);

    @Insert("insert into like_and_Collect(article_id,user_id,like_or_collect) values(articleId,userId,1) ")
    boolean addCollect(int articleId, int userId);

    @Delete("delete from like_and_collect  where article_id=#{articleId} and user_id = #{userId} and like_or_collect = 1")
    boolean deleteCollect(int articleId, int userId);
}
