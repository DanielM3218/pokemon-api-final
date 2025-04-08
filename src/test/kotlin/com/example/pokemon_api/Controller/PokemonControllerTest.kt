package com.example.pokemon_api.Controller


import com.example.pokemon_api.Model.Pokemon
import com.example.pokemon_api.Service.PokemonService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.http.HttpStatus

@ExtendWith(MockitoExtension::class)
class PokemonControllerTest {

    @Mock
    private lateinit var pokemonService: PokemonService

    private lateinit var pokemonController: PokemonController

    private val bulbasaur = Pokemon(
        1,
        "Bulbasaur",
        listOf("Grass", "Poison"),
        1,
        "https://img.pokemondb.net/artwork/large/bulbasaur.jpg"
    )

    private val ivysaur = Pokemon(
        2,
        "Ivysaur",
        listOf("Grass", "Poison"),
        2,
        "https://img.pokemondb.net/artwork/large/ivysaur.jpg"
    )

    @BeforeEach
    fun setUp() {
        pokemonController = PokemonController(pokemonService)
    }

    @Test
    fun `listAllPokemons should return all pokemons from service`() {
        val expectedPokemons = listOf(bulbasaur, ivysaur)
        `when`(pokemonService.getAllPokemons()).thenReturn(expectedPokemons)

        val result = pokemonController.listAllPokemons()

        assertThat(result).isNotNull
        assertThat(result).hasSize(2)
        assertThat(result).isEqualTo(expectedPokemons)
    }

    @Test
    fun `getPokemonById should return pokemon when it exists`() {
        val pokemonId = 1
        `when`(pokemonService.getPokemonById(pokemonId)).thenReturn(bulbasaur)

        val response = pokemonController.getPokemonById(pokemonId)

        assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(response.body).isNotNull
        assertThat(response.body).isEqualTo(bulbasaur)
    }

    @Test
    fun `getPokemonById should return not found when pokemon does not exist`() {
        val nonExistentId = 999
        `when`(pokemonService.getPokemonById(nonExistentId)).thenReturn(null)

        val response = pokemonController.getPokemonById(nonExistentId)

        assertThat(response.statusCode).isEqualTo(HttpStatus.NOT_FOUND)
        assertThat(response.body).isNull()
    }
}