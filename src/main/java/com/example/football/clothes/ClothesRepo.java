package com.example.football.clothes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothesRepo extends JpaRepository<Clothes,Integer> {
}
