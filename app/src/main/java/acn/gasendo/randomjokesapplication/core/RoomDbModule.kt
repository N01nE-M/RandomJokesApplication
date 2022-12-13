package acn.gasendo.randomjokesapplication.core

import acn.gasendo.randomjokesapplication.core.Constants.Companion.BOOK_TABLE
import acn.gasendo.randomjokesapplication.datasource.database.FavJokeDao
import acn.gasendo.randomjokesapplication.datasource.database.FavJokeDb
import acn.gasendo.randomjokesapplication.datasource.network.FavJokeRepositoryImpl
import acn.gasendo.randomjokesapplication.domain.repository.BookRepository
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class RoomDbModule {
    @Provides
    fun provideBookDb(
        @ApplicationContext
        context : Context
    ) = Room.databaseBuilder(
        context,
        FavJokeDb::class.java,
        BOOK_TABLE
    ).build()

    @Provides
    fun provideBookDao(
        favJokeDb: FavJokeDb
    ) = favJokeDb.bookDao()

    @Provides
    fun provideBookRepository(
        bookDao: FavJokeDao
    ): BookRepository = FavJokeRepositoryImpl(
        bookDao = bookDao
    )
}