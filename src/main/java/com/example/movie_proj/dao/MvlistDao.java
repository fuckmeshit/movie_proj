package com.example.movie_proj.dao;


import com.example.movie_proj.model.movieList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MvlistDao extends JpaRepository<movieList,String> {
    @Query("select m from movieList m")
    Page<movieList> findmvlist(Pageable pageable);
    movieList findByMvname(String mvna);
    @Query("select m from movieList m where m.mvtype2 like ?1")
    Page<movieList> findtypelist(String type,Pageable pageable);
}
