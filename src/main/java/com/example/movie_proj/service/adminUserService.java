package com.example.movie_proj.service;

import com.example.movie_proj.dao.adminUserDao;
import com.example.movie_proj.model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class adminUserService {
    @Autowired
    adminUserDao userDAO;

    public boolean isExist(String username) {
        user user = getByName(username);
        return null!=user;
    }

    public user getByName(String username) {
        return userDAO.findByUsername(username);
    }
    public user getByNameandPassword(String name,String password){
        return userDAO.getByUsernameAndPassword(name,password);
    }

//    public user get(String username, String password){
//        return getByUsernameAndPassword(username, password);
//    }

    public void add(user user) {
        userDAO.save(user);
    }

}
