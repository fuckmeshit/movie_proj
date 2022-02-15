package com.example.movie_proj.Controller;

import com.example.movie_proj.model.movieList;
import com.example.movie_proj.service.MvliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        System.out.println(page+"   "+size);
        System.out.println(mvliService.findList(page,size));
        return mvliService.findList(page,size);
    }

}
