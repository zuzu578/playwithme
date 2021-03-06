package com.withgame.game.main.play.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.withgame.game.main.play.entity.PlayBoardEntity;

import com.withgame.game.main.play.service.PlayWidthFriendsService;

@RestController
@RequestMapping("/play")
@CrossOrigin(origins = "http://localhost:3000")

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
    public ResponseEntity<?> selectList(HttpServletRequest req) {
        String location = req.getParameter("location");
        String rank = req.getParameter("danwi");
        HashMap<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("location", location);
        parameter.put("rank", rank);

        try {
            return new ResponseEntity<>(playWidthFriendsService.selectList(parameter), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/delete.do")
    public ResponseEntity<?> delete(@RequestBody HashMap<String, Object> parameter) {
        try {

            return new ResponseEntity<>("success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/update.do")
    public ResponseEntity<?> update(@RequestBody PlayBoardEntity parameter) {
        try {

            return new ResponseEntity<>("success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
