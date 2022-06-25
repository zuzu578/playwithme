package com.withgame.game.main.login.entity;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "taiko_user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    @Column(name = "donder_name")
    private String donderName;
    @Column(name = "danwi")
    private String danwi;
    @Column(name = "mydon_image")
    private String mydonImage;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "user_password")
    private String userPassword;
    @Column(name = "created_time")
    private String createdTime;
    @Column(name = "deleted_time")
    private String deletedTime;

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getDonderName() {
        return donderName;
    }

    public void setDonderName(String donderName) {
        this.donderName = donderName;
    }

    public String getDanwi() {
        return danwi;
    }

    public void setDanwi(String danwi) {
        this.danwi = danwi;
    }

    public String getMydonImage() {
        return mydonImage;
    }

    public void setMydonImage(String mydonImage) {
        this.mydonImage = mydonImage;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getDeletedTime() {
        return deletedTime;
    }

    public void setDeletedTime(String deletedTime) {
        this.deletedTime = deletedTime;
    }

}
