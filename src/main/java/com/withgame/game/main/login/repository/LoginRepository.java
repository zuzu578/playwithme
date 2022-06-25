package com.withgame.game.main.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.withgame.game.main.login.entity.UserEntity;

@Repository
public interface LoginRepository extends JpaRepository<UserEntity, Integer> {

}
