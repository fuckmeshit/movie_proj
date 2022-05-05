package com.example.movie_proj.dao;

import com.example.movie_proj.model.rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface MvRateDao extends JpaRepository<rate,Integer> {
    public rate findByMnameAndUname(String mname,String uname);
    @Transactional
    @Modifying
    @Query("update rate r set r.score=?1 where  r.mname=?2 and  r.uname=?3")
    int Update(String score,String mname,String uname);
}
