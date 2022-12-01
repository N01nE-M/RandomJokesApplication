package acn.gasendo.randomjokesapplication.domain.repository

import kotlinx.coroutines.flow.Flow
import acn.gasendo.randomjokesapplication.common.Resource
import acn.gasendo.randomjokesapplication.datasource.remotemodel.PostDto
import acn.gasendo.randomjokesapplication.domain.model.JokeModel

interface JokesRepository {

    fun getPosts(): Flow<Resource<List<JokeModel>>>

    fun postPost(post: PostDto): Flow<Resource<PostDto>>
}