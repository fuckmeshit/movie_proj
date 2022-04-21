package com.example.movie_proj.service;

import com.example.movie_proj.dao.MvCommentDao;
import com.example.movie_proj.model.comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class commentService {
    @Autowired
    MvCommentDao mvCommentDao;
    public List<comment> findlist(int page,int size,String mvname){
        PageRequest pageable= PageRequest.of(page, size);
        List<comment> list=mvCommentDao.findlist(mvname,"checked",pageable).getContent();
        return list;
    }
}
