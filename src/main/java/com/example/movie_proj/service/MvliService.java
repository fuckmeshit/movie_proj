package com.example.movie_proj.service;

import com.example.movie_proj.dao.MvCommentDao;
import com.example.movie_proj.dao.MvRateDao;
import com.example.movie_proj.dao.MvlistDao;
import com.example.movie_proj.model.comment;
import com.example.movie_proj.model.movieList;
import com.example.movie_proj.model.rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MvliService {
    @Autowired
    private MvlistDao mvlistDao;
    @Autowired
    private MvRateDao mvRateDao;
    @Autowired
    private MvCommentDao mvCommentDao;

    public List<movieList> findList(int page,int size){
        PageRequest pageable=PageRequest.of(page, size);
        List<movieList> movielist=mvlistDao.findmvlist(pageable).getContent();
        return movielist;
    }
    public List<movieList> findtypelist(int page,int size,String type){
        PageRequest pageable=PageRequest.of(page,size);
        List<movieList>movieLists=mvlistDao.findtypelist(type,pageable).getContent();
        return movieLists;
    }
    public movieList findmv(String mvna){
        return mvlistDao.findByMvname(mvna);
    }
    public void addcomment(comment comment){
        mvCommentDao.save(comment);
    }
    public void addrate(rate rate){
        String mid=rate.getMname();
        String score=rate.getScore();
        String uid=rate.getUname();
        if(mvRateDao.findByMnameAndUname(mid,uid)==null)
        mvRateDao.save(rate);
        else{
            mvRateDao.Update(score,mid,uid);
        }
    }
    public String getrate(String uname,String mname){
        rate rate=mvRateDao.findByMnameAndUname(mname,uname);
        String score= rate.getScore();
        System.out.println(score);
        return score;
    }

}
