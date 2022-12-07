package acn.gasendo.randomjokesapplication.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import acn.gasendo.randomjokesapplication.common.Resource
import acn.gasendo.randomjokesapplication.domain.repository.JokesRepository
import acn.gasendo.randomjokesapplication.presentation.JokesState
import kotlinx.coroutines.delay

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(repository: JokesRepository) : ViewModel() {

    private val _state = mutableStateOf(JokesState())
    val state: State<JokesState> = _state
    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    init{
        loadStuff()
    }

    fun loadStuff() {
        viewModelScope.launch {
            _isLoading.value = true
            delay(300L)
            _isLoading.value = false
        }
    }

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