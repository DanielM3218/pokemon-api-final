package com.example.pokemon_api.Model

data class Pokemon(
    val id: Int,
    val name: String,
    val types: List<String>,
    val pokedexNumber: Int,
    val imageUrl: String
)