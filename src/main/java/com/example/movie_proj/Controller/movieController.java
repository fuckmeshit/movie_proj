package com.example.movie_proj.Controller;

import com.example.movie_proj.model.comment;
import com.example.movie_proj.model.movieList;
import com.example.movie_proj.model.rate;
import com.example.movie_proj.service.MvliService;
import com.example.movie_proj.service.adminUserService;
import com.example.movie_proj.service.recomService;
import org.apache.mahout.cf.taste.common.TasteException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class movieController {
    @Autowired
    adminUserService adminuserService;
    @Autowired
    MvliService mvliService;
    @Autowired
    recomService recomservice;
    @CrossOrigin
    @RequestMapping("/api/mvlist/{page}/{size}")
    public List<movieList> getMovieList(
            @PathVariable("page")Integer page,
            @PathVariable("size")Integer size
            ){
        return mvliService.findList(page,size);
    }
    @CrossOrigin
    @RequestMapping("/api/mvname/{mvna}")
    public movieList getMovie(
            @PathVariable("mvna")String mvna
    ){
        return mvliService.findmv(mvna);
    }
    @CrossOrigin
    @RequestMapping("/api/score")
    public void saveScore(
            @RequestParam("uname") String uname,
            @RequestParam("mname") String mname,
            @RequestParam("rate") String rate
    ){
        String uid=adminuserService.getByName(uname).getId().toString();
        System.out.println(uid);
        String mid=mvliService.findmv(mname).getId().toString();
        System.out.println(mid);

        rate rate1=new rate();
        rate1.setMname(mid);
        rate1.setUname(uid);
        rate1.setScore(rate);
        mvliService.addrate(rate1);
    }
    @CrossOrigin
    @RequestMapping("/api/comment")
    public void saveComment(
            @RequestParam("uname") String uname,
            @RequestParam("mname") String mname,
            @RequestParam("comment")String comment2
    ){
        comment comment1 = new comment();
        comment1.setUname(uname);
        comment1.setMname(mname);
        comment1.setComment(comment2);
        comment1.setIschecked("unchecked");
        mvliService.addcomment(comment1);
    }
    @CrossOrigin
    @RequestMapping("/api/mvtype/{page}/{size}/{type}")
    public List<movieList> gettypelist(
            @PathVariable("page")Integer page,
            @PathVariable("size")Integer size,
            @PathVariable("type")String type
    ){
        type="%"+type+"%";
        System.out.println(type);
        return mvliService.findtypelist(page,size,type);
    }
    @CrossOrigin
    @RequestMapping("/api/mvrecom/{username}")
    public List<movieList> getrecomlist(
            @PathVariable("username")String username

            ) throws TasteException {
        return recomservice.recomlist(username);
    }
    @CrossOrigin
    @RequestMapping("/api/rate/{uname}/{mname}")
    public String getscore(
            @PathVariable("uname") String uname,
            @PathVariable("mname") String mname
    ){
        String uid=adminuserService.getByName(uname).getId().toString();
        String mid=mvliService.findmv(mname).getId().toString();
        System.out.println(uid);
        System.out.println(mid);
        String score=mvliService.getrate(uid,mid);
        System.out.println(score);
        if(score!=null)
            return score;
        else
            return "null";
    }
}
