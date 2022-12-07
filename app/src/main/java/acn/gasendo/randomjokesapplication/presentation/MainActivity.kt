package acn.gasendo.randomjokesapplication.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import acn.gasendo.randomjokesapplication.ui.theme.RandomJokeApplicationTheme
import acn.gasendo.randomjokesapplication.ui.theme.ThemeState
import androidx.compose.foundation.border
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable


@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {

    val viewmodel = hiltViewModel<MainViewModel>()
    val state = viewmodel.state.value
    val txt = "Favorites"

    RandomJokeApplicationTheme {
        val scaffoldState = rememberScaffoldState()
        Surface {
            Scaffold(
                topBar = {
                    AppBar(txt)
                },
                scaffoldState = scaffoldState,
                content = {
                    Column(
                        modifier = Modifier
                            .background(MaterialTheme.colors.secondary),
                        verticalArrangement = Arrangement.Bottom,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        if (state.posts != null) { // success
                            LazyColumn(modifier = Modifier.fillMaxSize()) {
                                items(state.posts) {
                                    Card(
                                        modifier = Modifier
                                            .padding(horizontal = 7.dp, vertical = 3.dp)
                                            .fillMaxWidth(),
                                        backgroundColor = MaterialTheme.colors.primary
                                    ) {
                                        Column(
                                            horizontalAlignment = Alignment.Start
                                        ) {
                                            Text(
                                                text = "Subject: " + it.type.replaceFirstChar { it.uppercase() } + "\n\n\n" + it.setup + "\n\n" + it.punchline + "\n\n",
                                                modifier = Modifier.padding(10.dp),
                                                color = MaterialTheme.colors.secondary
                                            )
                                            Row(
                                                modifier = Modifier.align(Alignment.End)
                                            ) {
                                                Button(
                                                    modifier = Modifier
                                                        .padding(10.dp),
                                                    colors = ButtonDefaults.buttonColors(
                                                        backgroundColor = MaterialTheme.colors.secondary,
                                                        contentColor = MaterialTheme.colors.primary
                                                    ),
                                                    onClick = { /*TODO*/ })
                                                {
                                                    Text(text = "Add to favorites")
                                                }
                                            }

                                        }
                                    }
                                }
                            }

                        } else {
                            if (state.loading) {
                                CircularProgressIndicator()
                            } else {
                                state.error?.let { Text(text = it) }
                            }
                        }
                    }

                }
            )
        }
    }
}

@Composable
fun FavoritesScreen() {

    val viewmodel = hiltViewModel<MainViewModel>()
    val state = viewmodel.state.value
    val txt = "Home"

    RandomJokeApplicationTheme {
        val scaffoldState = rememberScaffoldState()
        Surface {
            Scaffold(
                topBar = {
                    AppBar(txt)
                },
                scaffoldState = scaffoldState,
                content = {
                    Column(
                        modifier = Modifier
                            .background(MaterialTheme.colors.secondary),
                        verticalArrangement = Arrangement.Bottom,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        if (state.posts != null) { // success
                            LazyColumn(modifier = Modifier.fillMaxSize()) {
                                items(state.posts) {
                                    Card(
                                        modifier = Modifier
                                            .padding(horizontal = 7.dp, vertical = 3.dp)
                                            .fillMaxWidth(),
                                        backgroundColor = MaterialTheme.colors.primary
                                    ) {
                                        Column(
                                            horizontalAlignment = Alignment.Start
                                        ) {
                                            Text(
                                                text = "Subject: " + it.type.replaceFirstChar { it.uppercase() } + "\n\n\n" + it.setup + "\n\n" + it.punchline + "\n\n",
                                                modifier = Modifier.padding(10.dp),
                                                color = MaterialTheme.colors.secondary
                                            )
                                            Row(
                                                modifier = Modifier.align(Alignment.End)
                                            ) {
                                                Button(
                                                    modifier = Modifier
                                                        .padding(10.dp),
                                                    colors = ButtonDefaults.buttonColors(
                                                        backgroundColor = MaterialTheme.colors.secondary,
                                                        contentColor = MaterialTheme.colors.primary
                                                    ),
                                                    onClick = { /*TODO*/ })
                                                {
                                                    Text(text = "Add to favorites")
                                                }
                                            }

                                        }
                                    }
                                }
                            }

                        } else {
                            if (state.loading) {
                                CircularProgressIndicator()
                            } else {
                                state.error?.let { Text(text = it) }
                            }
                        }
                    }

                }
            )
        }
    }
}


@Composable
fun AppBar( textLabel : String) {

    TopAppBar {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colors.primary),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly

        ) {
            Button(
                modifier = Modifier
                    .padding(5.dp)
                    .border(
                        2.dp,
                        color = MaterialTheme.colors.secondary,
                        shape = RoundedCornerShape(2.dp)
                    ),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.secondary,
                    contentColor = MaterialTheme.colors.primary
                ),
                onClick = { /*TODO*/ })
            {
                Text(text = textLabel)
            }
            Button(
                modifier = Modifier
                    .padding(5.dp)
                    .border(
                        2.dp,
                        color = MaterialTheme.colors.secondary,
                        shape = RoundedCornerShape(2.dp)
                    ),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.secondary,
                    contentColor = MaterialTheme.colors.primary
                ),
                onClick = { ThemeState.isLight = !ThemeState.isLight })
            {
                if (ThemeState.isLight) {
                    Text(text = "Dark")
                } else {
                    Text(text = "Light")

                }
            }
        }

    }

}