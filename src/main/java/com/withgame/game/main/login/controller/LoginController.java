package com.withgame.game.main.login.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
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
    public HashMap<String, Object> login(@RequestBody LoginVO loginParameters)
            throws FailingHttpStatusCodeException, MalformedURLException, IOException, InterruptedException {
        String id = loginParameters.getUserId();
        String password = loginParameters.getUserPassword();

        HashMap<String, Object> myDonImg = loginService.doLogin(id, password);

        return myDonImg;
    }

}
