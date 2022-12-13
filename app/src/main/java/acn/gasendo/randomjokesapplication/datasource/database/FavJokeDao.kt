package acn.gasendo.randomjokesapplication.datasource.database

import acn.gasendo.randomjokesapplication.core.Constants.Companion.BOOK_TABLE
import acn.gasendo.randomjokesapplication.domain.model.FavJokeModel
import acn.gasendo.randomjokesapplication.domain.repository.Books
import androidx.room.*
import androidx.room.OnConflictStrategy.IGNORE
import kotlinx.coroutines.flow.Flow


@Dao
interface FavJokeDao {
        @Query("SELECT * FROM $BOOK_TABLE ORDER BY id ASC")
        fun getBooks(): Flow<Books>

        @Query("SELECT * FROM $BOOK_TABLE WHERE id = :id")
        fun getBook(id: Int): FavJokeModel

        @Insert(onConflict = IGNORE)
        fun addBook(favJokeModel: FavJokeModel)

        @Delete
        fun deleteBook(favJokeModel: FavJokeModel)
}
