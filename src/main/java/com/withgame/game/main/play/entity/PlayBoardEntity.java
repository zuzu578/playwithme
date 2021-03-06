package com.withgame.game.main.play.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "taiko_play_board") // table name
public class PlayBoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    @Column(name = "donder_name")
    private String donderName;

    @Column(name = "location")
    private String location;

    @Column(name = "danwi")
    private String danwi;

    @Column(name = "contents")
    private String contents;

    @Column(name = "created_time")
    private String createdTime;

    @Column(name = "deleted_time")
    private String deletedTime;

    @Column(name = "password")
    private String password;

    @Column(name = "danwi_rank")
    private String danwiRank;

    @Column(name = "twitter_account")
    private String twitterAccount;

    @Column(name = "mydon_Image")
    private String mydonImage;

    public String getMydonImage() {
        return mydonImage;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setMydonImage(String mydonImage) {
        this.mydonImage = mydonImage;
    }

    public String getTwitterAccount() {
        return twitterAccount;
    }

    public void setTwitterAccount(String twitterAccount) {
        this.twitterAccount = twitterAccount;
    }

    public String getDanwiRank() {
        return danwiRank;
    }

    public void setDanwiRank(String danwiRank) {
        this.danwiRank = danwiRank;
    }

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

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
