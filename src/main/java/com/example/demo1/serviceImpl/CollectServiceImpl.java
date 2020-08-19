package com.example.demo1.serviceImpl;

import com.example.demo1.bean.Collect;
import com.example.demo1.dao.CollectDao;
import com.example.demo1.service.CollectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CollectServiceImpl  implements CollectService {
    private CollectDao collectDao;
    @Resource
    public void setCollectDao(CollectDao collectDao){
        this.collectDao = collectDao;
    }
    public List<Collect> getCollect(int article){
        return collectDao.getCollect(article);
    }
    public boolean addCollect(int articleId, int userid){
        return collectDao.addCollect(articleId, userid);
    }
    public boolean deleteCollect(int articleId, int userid){
        return collectDao.deleteCollect(articleId,userid);
    }
}
