package com.withgame.game.main.login.QueryBuilder;

import java.text.SimpleDateFormat;
import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.withgame.game.main.login.entity.QUserEntity;
import com.withgame.game.main.login.entity.UserEntity;
import com.withgame.game.main.login.repository.LoginRepository;

@Service
public class LoginQuery {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    LoginRepository loginRepository;

    public UserEntity selectUser(String id, String password) {
        QUserEntity user = new QUserEntity("user");
        JPAQueryFactory queryBuilder = new JPAQueryFactory(entityManager);
        try {
            UserEntity userInfo = queryBuilder
                    .select(user)
                    .from(user)
                    .where(user.userId.eq(id).and(user.userPassword.eq(password)))
                    .fetchOne();

            return userInfo;
        } catch (Exception e) {
            return null;
        }

    }

    public void insertUser(HashMap<String, Object> userData) {

        UserEntity userEntity = new UserEntity();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format_time2 = format.format(System.currentTimeMillis());

        userEntity.setDanwi(userData.get("dan").toString());
        userEntity.setUserId(userData.get("id").toString());
        userEntity.setUserPassword(userData.get("password").toString());
        userEntity.setDonderName(userData.get("nickName").toString());
        userEntity.setMydonImage(userData.get("mydon").toString());
        userEntity.setCreatedTime(format_time2);
        loginRepository.save(userEntity);

    }
}
