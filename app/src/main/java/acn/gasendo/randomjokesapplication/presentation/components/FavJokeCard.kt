package acn.gasendo.randomjokesapplication.presentation.components

import acn.gasendo.randomjokesapplication.domain.model.FavJokeModel
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
@ExperimentalMaterialApi
fun BookCard(
    favJokeModel: FavJokeModel,
    deleteBook: () -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                start = 8.dp,
                end = 8.dp,
                top = 4.dp,
                bottom = 4.dp
            )
            .fillMaxWidth(),
        elevation = 3.dp
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column {
                Text(
                    text = "Subject: " + favJokeModel.type.replaceFirstChar { it.uppercase() } + "\n\n\n" + favJokeModel.setup + "\n\n" + favJokeModel.punchline + "\n\n"
                )
            }
            Spacer(
                modifier = Modifier.weight(1f)
            )
            DeleteIcon(
                deleteBook = deleteBook
            )
        }
    }
}