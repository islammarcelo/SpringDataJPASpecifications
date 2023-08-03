package com.example.football.player;

import com.example.football.clothes.Clothes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String team;
    private String position;
    private Integer high;
    private Integer weigh;

    @OneToMany(mappedBy = "playerId", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Clothes> clothes = new HashSet<>();
}
