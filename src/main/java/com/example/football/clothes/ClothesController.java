package com.example.football.clothes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clothes")
public class ClothesController {
    @Autowired
    private ClothesService clothesService;
    @PostMapping("/create-clothes")
    public void createClothes(@RequestParam(value = "playerId") Integer playerId,
                              @RequestBody Clothes clothes){
        clothesService.createClothes(playerId,clothes);
    }

}
