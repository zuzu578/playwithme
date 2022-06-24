package com.withgame.game.main.play.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.withgame.game.main.play.entity.PlayBoardEntity;

import com.withgame.game.main.play.service.PlayWidthFriendsService;

@RestController
@RequestMapping("/play")
public class PlayWithFriendsController {

    private final PlayWidthFriendsService playWidthFriendsService;

    @Autowired
    PlayWithFriendsController(PlayWidthFriendsService playWidthFriendsService) {
        this.playWidthFriendsService = playWidthFriendsService;
    }

    @PostMapping("/regist.do")
    public ResponseEntity<?> regist(@RequestBody PlayBoardEntity parameter) {

        try {
            playWidthFriendsService.regist(parameter);
            return new ResponseEntity<>("success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/selectList.do")
    public ResponseEntity<?> selectList(@RequestBody HashMap<String, Object> paramter) {
        try {
            List<PlayBoardEntity> result = playWidthFriendsService.selectList(paramter);
        } catch (Exception e) {
            return new ResponseEntity<>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return null;

    }

}
