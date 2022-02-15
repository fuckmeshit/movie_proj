package com.example.movie_proj.Controller;

import com.example.movie_proj.model.user;
import com.example.movie_proj.service.Result;
import com.example.movie_proj.service.adminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;
import java.util.Objects;

@Controller
public class LoginController {
    @Autowired
    adminUserService adminUserService;
    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result login(@RequestBody user requestUser) {
        String username = requestUser.getUsername();
        String password=requestUser.getPassword();
        username = HtmlUtils.htmlEscape(username);
        password=HtmlUtils.htmlEscape(password);
        System.out.println(username);
        System.out.println(password);
        if(adminUserService.getByNameandPassword(username,password)!=null){
            return new Result(200);
        }
        else return new Result(400);
        
    }
    @CrossOrigin
    @PostMapping(value = "api/register")
    @ResponseBody
    public Result register(@RequestBody user requestUser){
        String username = requestUser.getUsername();
        String password=requestUser.getPassword();
        username = HtmlUtils.htmlEscape(username);
        password=HtmlUtils.htmlEscape(password);
        System.out.println(username);
        System.out.println(password);
        if (adminUserService.getByName(username)==null){
            adminUserService.add(requestUser);
            return new Result(200);

        }else {
            return new Result(500);
        }
    }


}

