package com.example.movie_proj.Controller;

import com.example.movie_proj.model.comment;
import com.example.movie_proj.model.movieList;
import com.example.movie_proj.model.rate;
import com.example.movie_proj.service.MvliService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class movieController {
    @Autowired
    MvliService mvliService;

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
        rate rate1=new rate();
        int score=Integer.parseInt(rate);
        rate1.setMname(mname);
        rate1.setUname(uname);
        rate1.setScore(score);
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
}
