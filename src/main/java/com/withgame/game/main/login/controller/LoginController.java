package com.withgame.game.main.login.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.querydsl.core.NonUniqueResultException;
import com.withgame.game.main.login.VO.LoginVO;
import com.withgame.game.main.login.service.LoginService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;

    }

    @PostMapping("/login.do")
    public ResponseEntity<?> login(@RequestBody LoginVO loginParameters)
            throws FailingHttpStatusCodeException, MalformedURLException, IOException, InterruptedException,
            NonUniqueResultException, NoSuchAlgorithmException {

        String id = loginParameters.getUserId();
        String password = loginParameters.getUserPassword();

        try {
            HashMap<String, Object> userData = loginService.doLogin(id, password);
            return new ResponseEntity<>(userData, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
