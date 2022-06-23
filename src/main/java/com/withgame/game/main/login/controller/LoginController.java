package com.withgame.game.main.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.withgame.game.main.login.VO.LoginVO;
import com.withgame.game.main.login.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;

    }

    @PostMapping("/login.do")
    public String login(@RequestBody LoginVO loginParameters) {
        String id = loginParameters.getUserId();
        String password = loginParameters.getUserPassword();

        loginService.doLogin(id, password);

        return "test";
    }

}