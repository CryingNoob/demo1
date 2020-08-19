package com.example.demo1.dao;

import com.example.demo1.bean.Collect;
import com.example.demo1.bean.Like;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LikeDao {
    @Select("select * from Like_and_Collect where Article_id =#{articleId} and Like_or_collect  =0")
    List<Like> getLike(int articleId);

    @Insert("insert into like_and_Collect(article_id,userid,like_or_collect) values(articleId,userid,0) ")
    boolean addLike(int articleId, int userid);

    @Delete("delete from like_and_collect  where article_id=#{articleId} and userid = #{userid} and like_or_collect = 0")
    boolean deleteLike(int articleId, int userid);
}
