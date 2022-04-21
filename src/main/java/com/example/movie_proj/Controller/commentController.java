package com.example.movie_proj.Controller;

import com.example.movie_proj.model.comment;
import com.example.movie_proj.service.commentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class commentController {
    @Autowired
    public commentService commentservice;
    @CrossOrigin
    @RequestMapping("/mvcom/{page}/{size}/{mvname}")
    List<comment> getlist(
            @PathVariable("page")int page,
            @PathVariable("size")int size,
            @PathVariable("mvname")String mvname
    ){
        return commentservice.findlist(page, size, mvname);
    }
}
