package com.example.demo1.serviceImpl;

import com.example.demo1.bean.Article;
import com.example.demo1.bean.ArticleTag;
import com.example.demo1.dao.ArticleTagDao;
import com.example.demo1.service.ArticleTagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticleTagServiceImpl implements ArticleTagService {
   private ArticleTagDao articleTagDao;
   @Resource
    public void setArticleTagDao(ArticleTagDao articleTagDao) {
       this.articleTagDao = articleTagDao;
   }
    public List<ArticleTag> getArticleTag(int id){
       return articleTagDao.getArticleTag(id);
    }

    @Override
    public boolean insertArticleTag(ArticleTag articleTag) {
        return articleTagDao.insertArticleTag(articleTag);
    }

}
