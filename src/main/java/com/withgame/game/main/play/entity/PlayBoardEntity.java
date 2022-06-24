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
