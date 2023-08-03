package com.example.football.player;

import com.example.football.player.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepo extends JpaRepository<Player,Integer>, JpaSpecificationExecutor<Player> {
    List<Player> findByTeam(String name);
}
