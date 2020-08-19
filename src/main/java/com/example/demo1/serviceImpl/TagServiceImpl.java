package com.example.demo1.serviceImpl;

import com.example.demo1.bean.Tag;
import com.example.demo1.dao.TagDao;
import com.example.demo1.service.TagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TagServiceImpl  implements TagService {
    private TagDao tagDao;
    @Resource
    public  void setTagDao(TagDao tagDao){
        this.tagDao=tagDao;
    }

    public Tag getTag(int tagId ){
        return  tagDao.getTag( tagId);
    }

}
