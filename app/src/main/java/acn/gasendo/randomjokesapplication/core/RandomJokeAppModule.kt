package acn.gasendo.randomjokesapplication.core

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import acn.gasendo.randomjokesapplication.datasource.api.JokesApi
import acn.gasendo.randomjokesapplication.datasource.network.JokesApiImpl
import acn.gasendo.randomjokesapplication.datasource.repository.JokesRepositoryImpl
import acn.gasendo.randomjokesapplication.domain.repository.JokesRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RandomJokeAppModule {

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient = HttpClient(Android) {
        install(Logging) {
            level = LogLevel.ALL
        }

        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }

    @Provides
    @Singleton
    fun providePostsApi(client: HttpClient): JokesApi = JokesApiImpl(client)

    @Provides
    fun providePostsRepository(api: JokesApi): JokesRepository = JokesRepositoryImpl(api)
}