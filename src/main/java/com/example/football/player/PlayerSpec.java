package com.example.football.player;

import com.example.football.clothes.Clothes;
import com.example.football.player.Player;
import com.example.football.player.PlayerSearch;
import jakarta.persistence.criteria.*;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class PlayerSpec implements Specification<Player> {
    private PlayerSearch playerSearch;
    @Override
    public Predicate toPredicate(Root<Player> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) { //where condition :)
        List<Predicate> predicates = new ArrayList<>();
        Join<Player, Clothes> playerClothesJoin= root.join("clothes", JoinType.INNER); //by default innerJoin
        if(playerSearch.getTeam() != null && !playerSearch.getTeam().isEmpty()){
            query.orderBy(criteriaBuilder.asc(root.get("weigh")));
            predicates.add(criteriaBuilder.like(root.get("team"),playerSearch.getTeam()));
        }
        if(playerSearch.getHigh() != null && playerSearch.getHigh() != 0){
            predicates.add(criteriaBuilder.equal(root.get("high"),playerSearch.getHigh()));
        }
        if (playerSearch.getWeigh() != null && playerSearch.getWeigh() != 0){
            predicates.add(criteriaBuilder.equal(root.get("weigh"), playerSearch.getWeigh()));
        }
        if (playerSearch.getPosition() != null && !playerSearch.getPosition().isEmpty()){
            predicates.add(criteriaBuilder.like(root.get("position"),playerSearch.getPosition()));
        }
        if (playerSearch.getClothesSize() != null && !playerSearch.getClothesSize().isEmpty()){
            predicates.add(criteriaBuilder.like(playerClothesJoin.get("size"),playerSearch.getClothesSize()));
        }
        if (playerSearch.getClothesColor() != null && !playerSearch.getClothesColor().isEmpty()){
            predicates.add(criteriaBuilder.like(playerClothesJoin.get("color"),playerSearch.getClothesColor()));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
