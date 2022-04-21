package com.example.movie_proj.dao;

import com.example.movie_proj.model.rate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MvRateDao extends JpaRepository<rate,Integer> {


}
