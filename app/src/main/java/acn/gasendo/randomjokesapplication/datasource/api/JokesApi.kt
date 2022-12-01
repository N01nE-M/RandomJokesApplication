package acn.gasendo.randomjokesapplication.datasource.api

import acn.gasendo.randomjokesapplication.datasource.remotemodel.PostDto

interface JokesApi {

    companion object {
        private const val BASE_URL = "https://official-joke-api.appspot.com"
        const val POSTS_URL = "$BASE_URL/random_ten"
    }

    suspend fun getPosts(): List<PostDto>

    suspend fun postPost(post: PostDto): PostDto?
}