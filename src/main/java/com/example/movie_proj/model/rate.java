package com.example.movie_proj.model;

import javax.persistence.*;

@Entity
@Table(name = "score")
public class rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String uname;
    String mname;
    int score;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
