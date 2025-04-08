package com.example.pokemon_api.Service

import com.example.pokemon_api.Model.Pokemon
import org.springframework.stereotype.Service

@Service
class PokemonService {
    private val pokemonList = listOf(
        Pokemon(
            1,
            "Bulbasaur",
            listOf("Grass", "Poison"),
            1,
            "https://img.pokemondb.net/artwork/large/bulbasaur.jpg"
        ),
        Pokemon(
            2,
            "Ivysaur",
            listOf("Grass", "Poison"),
            2,
            "https://img.pokemondb.net/artwork/large/ivysaur.jpg"
        )
    )

    fun getAllPokemons(): List<Pokemon> = pokemonList
    fun getPokemonById(id: Int): Pokemon? = pokemonList.find { it.id == id }
}