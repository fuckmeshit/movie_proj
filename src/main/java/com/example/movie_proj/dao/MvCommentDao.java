package com.example.movie_proj.dao;

import com.example.movie_proj.model.comment;
import com.example.movie_proj.model.movieList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MvCommentDao extends JpaRepository<comment, String> {
    @Query("select c from comment c where c.mname=?1 and c.ischecked=?2")
    Page<comment> findlist(String mvname,String ischecked,Pageable pageable);
}
