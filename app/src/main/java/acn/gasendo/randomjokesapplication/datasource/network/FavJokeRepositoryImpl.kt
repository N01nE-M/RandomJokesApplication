package acn.gasendo.randomjokesapplication.datasource.network

import acn.gasendo.randomjokesapplication.datasource.database.FavJokeDao
import acn.gasendo.randomjokesapplication.domain.model.FavJokeModel
import acn.gasendo.randomjokesapplication.domain.repository.BookRepository


class FavJokeRepositoryImpl(
    private val bookDao: FavJokeDao
) : BookRepository {
    override fun getBooksFromRoom() = bookDao.getBooks()

    override fun getBookFromRoom(id: Int) = bookDao.getBook(id)

    override fun addBookToRoom(favJokeModel: FavJokeModel) = bookDao.addBook(favJokeModel)

    override fun deleteBookFromRoom(favJokeModel: FavJokeModel) = bookDao.deleteBook(favJokeModel)
}