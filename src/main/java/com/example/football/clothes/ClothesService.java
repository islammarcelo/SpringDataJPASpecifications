package com.example.football.clothes;

import com.example.football.player.Player;
import com.example.football.player.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class ClothesService {
    @Autowired
    private ClothesRepo clothesRepo;

    @Autowired
    private PlayerRepo playerRepo;

    public void createClothes(Integer playerId, Clothes clothes){
        Optional<Player> player = playerRepo.findById(playerId);
        if(!player.isPresent()){
            throw new IllegalArgumentException("Player with Id "+ playerId+ " Not Exist");
        }
        clothes.setPlayerId(player.get());
        clothesRepo.save(clothes);
    }
}
