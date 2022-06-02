package dev.hinaka.pokedex.ui.pokedex

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.hinaka.pokedex.domain.models.pokemon.Pokemon
import dev.hinaka.pokedex.ui.pokedex.usecases.GetPokemonsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PokemonListViewModel(
  private val getPokemonsUseCase: GetPokemonsUseCase,
) : ViewModel() {
  val pokemons = MutableStateFlow<List<Pokemon>>(emptyList())

  init {
    viewModelScope.launch {
      val newPokemons = getPokemonsUseCase()
      pokemons.update {
        newPokemons
      }
    }
  }
}