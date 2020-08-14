package com.example.demo1.serviceImpl;

import com.example.demo1.bean.Tag;
import com.example.demo1.dao.TagDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TagServiceImpl {
    private TagDao tagDao;
    @Resource
    public  void setTagDao(TagDao tagDao){
        this.tagDao=tagDao;
    }

    public List<Tag> getTag(int id ){
        return  tagDao.getTag( id);
    }

}
