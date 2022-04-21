package com.example.movie_proj.model;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String uname;
    String mname;
    String comment;

    public String getIschecked() {
        return ischecked;
    }

    public void setIschecked(String ischecked) {
        this.ischecked = ischecked;
    }

    String ischecked;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
