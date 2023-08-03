package com.example.football.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/player")
public class PlayerController {
    @Autowired
    PlayerService footballService;

    @PostMapping("/create-player")
    public void createPlayer(@RequestBody Player player){
        footballService.createPlayer(player);
    }

    @GetMapping("/get-players")
    public List<Player> getAllPlayerByTeamName(@RequestParam("teamName") String teamName){
        return footballService.getAllPlayerByTeamName(teamName);
    }

    @PostMapping("/search-players")
    public List<Player> searchPlayers(@RequestBody PlayerSearch playerSearch){
        return footballService.searchPlayers(playerSearch);
    }


}
