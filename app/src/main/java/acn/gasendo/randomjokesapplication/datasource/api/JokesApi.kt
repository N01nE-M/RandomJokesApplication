package acn.gasendo.randomjokesapplication.datasource.api

import acn.gasendo.randomjokesapplication.datasource.remotemodel.JokeDto

interface JokesApi {

    companion object {
        private const val BASE_URL = "https://official-joke-api.appspot.com"
        const val POSTS_URL = "$BASE_URL/random_ten"
    }

    suspend fun getJokes(): List<JokeDto>

    suspend fun postJoke(post: JokeDto): JokeDto?
}