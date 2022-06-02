package dev.hinaka.pokedex.data.repositories

import dev.hinaka.pokedex.data.remote.PokemonRemoteDataSource
import dev.hinaka.pokedex.domain.models.pokemon.Pokemon
import dev.hinaka.pokedex.domain.repositories.PokemonRepository

class PokemonDataRepository(
  private val pokemonRemoteDataSource: PokemonRemoteDataSource,
) : PokemonRepository {
  override suspend fun getPokemons(): List<Pokemon> {
    return pokemonRemoteDataSource.getPokemons()
  }
}