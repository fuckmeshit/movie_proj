package com.example.movie_proj.dao;

import com.example.movie_proj.model.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface adminUserDao extends JpaRepository<user,String> {
    /**根据用户名和id查询**/
    user findByUsernameAndId(String username,String id);
    /**根据账号和密码查询**/
    user findByIdAndPassword(String id,String password);
    user findByUsername(String username);
    user getByUsernameAndPassword(String username,String password);
}
