package com.example.Pokemon.repository;

import java.util.Optional;

import com.example.Pokemon.model.Pokemon;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

    void deletePokemonById(Long Id);

    Optional<Pokemon> findPokemonById(Long Id);

}