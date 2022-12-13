package acn.gasendo.randomjokesapplication.domain.repository

import acn.gasendo.randomjokesapplication.domain.model.FavJokeModel
import kotlinx.coroutines.flow.Flow


typealias Books = List<FavJokeModel>

interface BookRepository {

    fun getBooksFromRoom(): Flow<Books>

    fun getBookFromRoom(id: Int): FavJokeModel

    fun addBookToRoom(favJokeModel: FavJokeModel)

    fun deleteBookFromRoom(favJokeModel: FavJokeModel)
}