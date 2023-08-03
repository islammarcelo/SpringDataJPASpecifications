package com.example.football.player;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerSearch {
    private String team;
    private Integer high;
    private Integer weigh;
    private String position;
    private String clothesSize;
    private String clothesColor;
}
