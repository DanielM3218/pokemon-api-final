package com.example.pokemon_api.Controller

import com.example.pokemon_api.Model.Pokemon
import com.example.pokemon_api.Service.PokemonService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/pokemon")
class PokemonController(private val service: PokemonService) {

    @GetMapping
    fun listAllPokemons(): List<Pokemon> = service.getAllPokemons()

    @GetMapping("/{id}")
    fun getPokemonById(@PathVariable id: Int): ResponseEntity<Pokemon> {
        val pokemon = service.getPokemonById(id)
        return if (pokemon != null) ResponseEntity.ok(pokemon)
        else ResponseEntity.notFound().build()
    }
}