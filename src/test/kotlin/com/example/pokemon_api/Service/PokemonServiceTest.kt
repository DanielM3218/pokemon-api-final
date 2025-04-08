package com.example.pokemon_api.Service

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class PokemonServiceTest {

    private val pokemonService = PokemonService()

    @Test
    fun `should return all pokemons`() {
        val result = pokemonService.getAllPokemons()

        assertThat(result).isNotEmpty
        assertThat(result).hasSize(2)

        assertThat(result[0].name).isEqualTo("Bulbasaur")
        assertThat(result[1].name).isEqualTo("Ivysaur")
    }

    @Test
    fun `should return pokemon by id`() {
        val result = pokemonService.getPokemonById(1)

        assertThat(result).isNotNull
        assertThat(result?.name).isEqualTo("Bulbasaur")

        val nonExistentPokemon = pokemonService.getPokemonById(999)

        assertThat(nonExistentPokemon).isNull()
    }
}