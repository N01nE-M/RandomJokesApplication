package acn.gasendo.randomjokesapplication.presentation.components

import acn.gasendo.randomjokesapplication.domain.model.FavJokeModel
import acn.gasendo.randomjokesapplication.domain.repository.Books
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
@ExperimentalMaterialApi
fun BooksContent(
    padding: PaddingValues,
    books: Books,
    deleteBook: (favJokeModel: FavJokeModel) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(padding)
    ) {
        items(
            items = books
        ) { book ->
            BookCard(
                favJokeModel = book
            ) {
                deleteBook(book)
            }
        }
    }
}