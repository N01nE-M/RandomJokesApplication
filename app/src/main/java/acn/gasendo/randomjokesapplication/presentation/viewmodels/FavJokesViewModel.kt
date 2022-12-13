package acn.gasendo.randomjokesapplication.presentation.viewmodels

import acn.gasendo.randomjokesapplication.core.Constants.Companion.NO_VALUE
import acn.gasendo.randomjokesapplication.domain.model.FavJokeModel
import acn.gasendo.randomjokesapplication.domain.repository.BookRepository
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavJokesViewModel @Inject constructor(
    private val repo: BookRepository
) : ViewModel() {
    var favJokeModel by mutableStateOf(FavJokeModel(0, NO_VALUE, NO_VALUE, NO_VALUE))
        private set

    val books = repo.getBooksFromRoom()

    fun getBook(id: Int) = viewModelScope.launch(Dispatchers.IO) {
        favJokeModel = repo.getBookFromRoom(id)
    }

    fun addBook(favJokeModel: FavJokeModel) = viewModelScope.launch(Dispatchers.IO) {
        repo.addBookToRoom(favJokeModel)
    }

    fun deleteBook(favJokeModel: FavJokeModel) = viewModelScope.launch(Dispatchers.IO) {
        repo.deleteBookFromRoom(favJokeModel)
    }



}