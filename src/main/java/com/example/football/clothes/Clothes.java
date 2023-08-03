package com.example.football.clothes;

import com.example.football.player.Player;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clothes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    String size;
    String color;
    @ManyToOne
    @JoinColumn(name="player_id")
    private Player playerId;

}
