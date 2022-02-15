package com.example.movie_proj.service;

import com.example.movie_proj.dao.MvlistDao;
import com.example.movie_proj.model.movieList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MvliService {
    @Autowired
    private MvlistDao mvlistDao;
    public List<movieList> findList(int page,int size){
        PageRequest pageable=PageRequest.of(page, size);
        List<movieList> movielist=mvlistDao.findmvlist(pageable).getContent();
        return movielist;
    }
}
