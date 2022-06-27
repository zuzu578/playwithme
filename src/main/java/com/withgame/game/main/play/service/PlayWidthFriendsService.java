package com.withgame.game.main.play.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.withgame.game.main.play.entity.PlayBoardEntity;
import com.withgame.game.main.play.entity.QPlayBoardEntity;
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
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format_time2 = format.format(System.currentTimeMillis());
        parameter.setCreatedTime(format_time2);
        playBoardRepository.save(parameter);
    }

    public List<PlayBoardEntity> selectList(HashMap<String, Object> paramMap) {
        List<PlayBoardEntity> result = new ArrayList<PlayBoardEntity>();

        QPlayBoardEntity play = new QPlayBoardEntity("p1");
        JPAQueryFactory queryBuilder = new JPAQueryFactory(entityManager);

        if (paramMap.isEmpty()) {
            result = queryBuilder
                    .select(play)
                    .from(play)
                    .offset(0)
                    .limit(10)
                    .fetch();
        } else {
            result = queryBuilder
                    .select(play)
                    .from(play)
                    .offset(0)
                    .limit(10)
                    .fetch();
        }

        return result;
    }
}
