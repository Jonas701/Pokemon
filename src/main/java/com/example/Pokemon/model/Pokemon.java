package com.example.Pokemon.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;
import javax.persistence.GenerationType;

@Entity
public class Pokemon implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long Id;
    @Column(nullable = false)
    public String nom;
    @Column(nullable = false)
    public String type;
    public String evolution;
    @Column(nullable = false)
    public String codePokemon;

    public Pokemon(Long Id, String nom, String type, String evolution, String codePokemon) {
        this.Id = Id;
        this.nom = nom;
        this.type = type;
        this.evolution = evolution;
        this.codePokemon = codePokemon;
    }

    public String getCodePokemon() {
        return this.codePokemon;
    }

    public void setCodePokemon(String codePokemon) {
        this.codePokemon = codePokemon;
    }

    public Pokemon codePokemon(String codePokemon) {
        setCodePokemon(codePokemon);
        return this;
    }

    public Pokemon() {
    }

    public Pokemon(Long Id, String nom, String type, String evolution) {
        this.Id = Id;
        this.nom = nom;
        this.type = type;
        this.evolution = evolution;
    }

    public Long getId() {
        return this.Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEvolution() {
        return this.evolution;
    }

    public void setEvolution(String evolution) {
        this.evolution = evolution;
    }

    public Pokemon Id(Long Id) {
        setId(Id);
        return this;
    }

    public Pokemon nom(String nom) {
        setNom(nom);
        return this;
    }

    public Pokemon type(String type) {
        setType(type);
        return this;
    }

    public Pokemon evolution(String evolution) {
        setEvolution(evolution);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pokemon)) {
            return false;
        }
        Pokemon pokemon = (Pokemon) o;
        return Objects.equals(Id, pokemon.Id) && Objects.equals(nom, pokemon.nom) && Objects.equals(type, pokemon.type)
                && Objects.equals(evolution, pokemon.evolution);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, nom, type, evolution);
    }

    @Override
    public String toString() {
        return "{" +
                " Id='" + getId() + "'" +
                ", nom='" + getNom() + "'" +
                ", type='" + getType() + "'" +
                ", evolution='" + getEvolution() + "'" +
                "}";
    }

}