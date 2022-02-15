package com.example.movie_proj.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.*;

/**
 * @author 25097
 * 设置了movie的id，电影名，电影信息，电影类别等这几个信息，实际数据库后期需要更换
 * @Date 2022/2/1今天尝试完成一些后台的数据返回的工作
 */
@Entity
@Table(name = "movie")
public class movieList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mo_id")
    String id;
    @Column(name = "mo_name")
    String mvname;
    @Column(name = "mo_information")
    String mvinformation;
    @Column(name = "mo_type")
    String mvtype;

    public String getMvmsg() {
        return mvmsg;

    }

    public void setMvmsg(String mvmsg) {
        this.mvmsg = mvmsg;
    }

    @Column(name="mo_msg")
    String mvmsg;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMvname() {
        return mvname;
    }

    public void setMvname(String mvname) {
        this.mvname = mvname;
    }

    public String getMvinformation() {
        return mvinformation;
    }

    public void setMvinformation(String mvinformation) {
        this.mvinformation = mvinformation;
    }

    public String getMvtype() {
        return mvtype;
    }

    public void setMvtype(String mvtype) {
        this.mvtype = mvtype;
    }
}
