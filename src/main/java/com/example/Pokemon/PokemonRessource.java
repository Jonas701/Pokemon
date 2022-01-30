package com.example.Pokemon;

import java.util.List;

import com.example.Pokemon.model.Pokemon;
import com.example.Pokemon.service.PokemonService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/pokemon")
public class PokemonRessource {

    @Autowired
    private final PokemonService pokemonService;

    public PokemonRessource(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Pokemon>> getAllPokemons() {
        List<Pokemon> pokemons = pokemonService.findAllPokemon();
        return new ResponseEntity<>(pokemons, HttpStatus.OK);
    }

    @GetMapping("/find/{Id}")
    public ResponseEntity<Pokemon> getPokemonbyId(@PathVariable("Id") Long Id) {
        Pokemon pokemon = pokemonService.findPokemonById(Id);
        return new ResponseEntity<>(pokemon, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Pokemon> addPokemon(@RequestBody Pokemon pokemon) {
        Pokemon newPokemon = pokemonService.addPokemon(pokemon);
        return new ResponseEntity<>(newPokemon, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<Pokemon> updatePokemon(@RequestBody Pokemon pokemon) {
        Pokemon updatePokemon = pokemonService.updatePokemon(pokemon);
        return new ResponseEntity<>(updatePokemon, HttpStatus.OK);
    }

    @PostMapping("/delete/{Id}")
    public ResponseEntity<?> deletePokemonbyId(@PathVariable("Id") Long Id) {
        pokemonService.deletePokemon(Id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
