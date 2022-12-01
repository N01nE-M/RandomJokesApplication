package acn.gasendo.randomjokesapplication.datasource.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import acn.gasendo.randomjokesapplication.common.Resource
import acn.gasendo.randomjokesapplication.datasource.api.JokesApi
import acn.gasendo.randomjokesapplication.datasource.remotemodel.PostDto
import acn.gasendo.randomjokesapplication.datasource.remotemodel.toPost
import acn.gasendo.randomjokesapplication.domain.model.JokeModel
import acn.gasendo.randomjokesapplication.domain.repository.JokesRepository

class JokesRepositoryImpl(private val api: JokesApi) : JokesRepository {

    override fun getPosts(): Flow<Resource<List<JokeModel>>> = flow {
        try {
            emit(Resource.Loading())
            val posts = api.getPosts().map { it.toPost() }
            emit(Resource.Success(data = posts))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.message ?: "Error"))
        }
    }

    override fun postPost(post: PostDto): Flow<Resource<PostDto>> = flow {
        try {
            emit(Resource.Loading())
            val postResult = api.postPost(post)!!
            emit(Resource.Success(data = postResult))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "Error"))
        }
    }
}