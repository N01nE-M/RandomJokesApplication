package acn.gasendo.randomjokesapplication.presentation.states

import acn.gasendo.randomjokesapplication.domain.model.JokeModel

data class JokesState(
    val posts: List<JokeModel>? = null,
    val loading: Boolean = false,
    val error: String? = null
)
