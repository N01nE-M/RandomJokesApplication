package acn.gasendo.randomjokesapplication.datasource.database

import acn.gasendo.randomjokesapplication.domain.model.FavJokeModel
import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [FavJokeModel::class], version = 1, exportSchema = false)
abstract class FavJokeDb : RoomDatabase() {
    abstract fun bookDao(): FavJokeDao
}