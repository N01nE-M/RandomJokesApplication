package acn.gasendo.randomjokesapplication.domain.repository

import kotlinx.coroutines.flow.Flow
import acn.gasendo.randomjokesapplication.common.Resource
import acn.gasendo.randomjokesapplication.datasource.remotemodel.JokeDto
import acn.gasendo.randomjokesapplication.domain.model.JokeModel

interface JokesRepository {

    fun getJokes(): Flow<Resource<List<JokeModel>>>

    fun postJoke(post: JokeDto): Flow<Resource<JokeDto>>
}