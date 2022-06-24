package com.withgame.game.main.play.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.withgame.game.main.play.entity.PlayBoardEntity;

@Repository
public interface PlayBoardRepository extends JpaRepository<PlayBoardEntity, Integer> {

}
