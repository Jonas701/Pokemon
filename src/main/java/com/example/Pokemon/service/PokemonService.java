package com.example.Pokemon.service;

import java.util.List;
import java.util.UUID;

import com.example.Pokemon.exception.PokemonNotFoundException;
import com.example.Pokemon.model.Pokemon;
import com.example.Pokemon.repository.PokemonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokemonService {
    @Autowired
    private final PokemonRepository pokemonRepo;

    @Autowired
    public PokemonService(PokemonRepository pokemonRepo) {
        this.pokemonRepo = pokemonRepo;
    }

    public Pokemon addPokemon(Pokemon pokemon) {
        pokemon.setCodePokemon(UUID.randomUUID().toString());
        return pokemonRepo.save(pokemon);
    }

    public List<Pokemon> findAllPokemon() {
        return pokemonRepo.findAll();
    }

    public Pokemon updatePokemon(Pokemon pokemon) {
        return pokemonRepo.save(pokemon);

    }

    public void deletePokemon(Long Id) {
        pokemonRepo.deletePokemonById(Id);
    }

    public Pokemon findPokemonById(Long Id) {
        return pokemonRepo.findPokemonById(Id)
                .orElseThrow(() -> new PokemonNotFoundException("User by id " + Id + " was not found"));
    }
}
