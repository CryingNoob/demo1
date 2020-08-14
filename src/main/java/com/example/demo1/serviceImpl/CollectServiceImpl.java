package com.example.demo1.serviceImpl;

import com.example.demo1.bean.Collect;
import com.example.demo1.dao.CollectDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CollectServiceImpl {
    private CollectDao collectDao;
    @Resource
    public void setCollectDao(CollectDao collectDao){
        this.collectDao = collectDao;
    }
    List<Collect> getCollect(int article){
        return collectDao.getAllCollect(article);
    }
}
