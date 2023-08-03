package com.example.football.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    PlayerRepo footballRepo;

    public void createPlayer(Player player){
        footballRepo.save(player);
    }
    public List<Player> getAllPlayerByTeamName(String teamName){
        return footballRepo.findByTeam(teamName);
    }

    public List<Player> searchPlayers(PlayerSearch playerSearch){
        PlayerSpec playerSpec =new PlayerSpec(playerSearch);
        return footballRepo.findAll(playerSpec);
    }
}
