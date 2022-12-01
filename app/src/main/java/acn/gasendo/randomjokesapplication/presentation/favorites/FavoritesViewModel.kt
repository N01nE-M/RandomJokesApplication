package acn.gasendo.randomjokesapplication.presentation.favorites

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import acn.gasendo.randomjokesapplication.common.Resource
import acn.gasendo.randomjokesapplication.domain.repository.JokesRepository
import acn.gasendo.randomjokesapplication.presentation.JokesState
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(repository: JokesRepository) : ViewModel() {

    private val _state = mutableStateOf(JokesState())
    val state: State<JokesState> = _state

    init {
        repository.getPosts().onEach { result ->
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