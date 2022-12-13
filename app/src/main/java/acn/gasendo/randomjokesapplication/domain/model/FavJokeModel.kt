package acn.gasendo.randomjokesapplication.domain.model

import acn.gasendo.randomjokesapplication.core.Constants.Companion.BOOK_TABLE
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = BOOK_TABLE)
data class FavJokeModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val punchline: String,
    val setup: String,
    val type: String
)