package acn.gasendo.randomjokesapplication.datasource.network

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*
import acn.gasendo.randomjokesapplication.datasource.api.JokesApi
import acn.gasendo.randomjokesapplication.datasource.remotemodel.PostDto

class JokesApiImpl(private val client: HttpClient) : JokesApi {

    override suspend fun getPosts(): List<PostDto> {
        return client.get { url(JokesApi.POSTS_URL) }
    }

    override suspend fun postPost(post: PostDto): PostDto? {
        return client.post {
            url(JokesApi.POSTS_URL)
            contentType(ContentType.Application.Json)
            body = post
        }
    }
}