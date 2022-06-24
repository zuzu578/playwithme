package com.withgame.game.main.play.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.withgame.game.main.play.entity.PlayBoardEntity;
import com.withgame.game.main.play.repository.PlayBoardRepository;

@Service
public class PlayWidthFriendsService {
    @PersistenceContext
    EntityManager entityManager;

    PlayBoardRepository playBoardRepository;

    @Autowired
    PlayWidthFriendsService(PlayBoardRepository playBoardRepository) {
        this.playBoardRepository = playBoardRepository;
    }

    public void regist(PlayBoardEntity parameter) {
        playBoardRepository.save(parameter);
    }
}
