package acn.gasendo.randomjokesapplication.presentation.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import acn.gasendo.randomjokesapplication.common.Resource
import acn.gasendo.randomjokesapplication.domain.repository.JokesRepository
import acn.gasendo.randomjokesapplication.presentation.states.JokesState
import kotlinx.coroutines.flow.*


import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(repository: JokesRepository) : ViewModel() {

    private val _state = mutableStateOf(JokesState())
    val state: State<JokesState> = _state


   init{
        repository.getJokes().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = JokesState(posts = result.data!!, loading = false, error = null)
                }

                is Resource.Loading -> {
                    _state.value = JokesState(posts = null, loading = true, error = null)
                }

                is Resource.Error -> {
                    _state.value = JokesState(posts = null, loading = false, error = result.message)
                }
            }
        }.launchIn(viewModelScope)
    }


}