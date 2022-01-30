package com.example.Pokemon.repository;

import java.util.Optional;

import com.example.Pokemon.model.Pokemon;
import org.springframework.context.annotation.Bean;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

    @Bean
    void deletePokemonById(Long Id);

    @Bean
    Optional<Pokemon> findPokemonById(Long Id);

}