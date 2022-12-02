package acn.gasendo.randomjokesapplication.presentation.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import acn.gasendo.randomjokesapplication.presentation.ui.theme.RandomJokeApplicationTheme
import acn.gasendo.randomjokesapplication.presentation.ui.theme.ThemeState
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext


@AndroidEntryPoint
class HomeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val viewmodel = hiltViewModel<HomeViewModel>()
            val state = viewmodel.state.value

            RandomJokeApplicationTheme {

                val scaffoldState = rememberScaffoldState()
                Surface {
                    Scaffold(
                        topBar = {
                            AppBar()
                        },
                        scaffoldState = scaffoldState,
                        content = {
                            Column(
                                modifier = Modifier
                                    .background(MaterialTheme.colors.background),
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
                                                backgroundColor = Color.White
                                            ) {
                                                Text(
                                                    text = it.setup + "\n\n" + it.punchline + "\n\n" + "Subject: " + it.type,
                                                    modifier = Modifier.padding(10.dp)
                                                )
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

                        },
                    )
                }
            }
        }
    }
}

@Composable
fun AppBar() {

    TopAppBar(
        title = {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly

            ) {
                Button(
                    modifier = Modifier
                        .padding(5.dp)
                        .border(
                            2.dp,
                            color = MaterialTheme.colors.primary,
                            shape = RoundedCornerShape(5.dp)
                        ),
                    onClick = { /*TODO*/ })
                {

                    Text(text = "Reload")
                }
                Button(
                    modifier = Modifier
                        .padding(5.dp)
                        .border(
                            2.dp,
                            color = MaterialTheme.colors.primary,
                            shape = RoundedCornerShape(5.dp)
                        ),
                    onClick = { /*TODO*/ })
                {
                    Text(text = "Favorites")
                }
                Button(
                    modifier = Modifier
                        .padding(5.dp)
                        .border(
                            2.dp,
                            color = MaterialTheme.colors.primary,
                            shape = RoundedCornerShape(5.dp)
                        ),
                    onClick = { ThemeState.isLight = !ThemeState.isLight })
                {
                    Text(text = "Theme")
                }
            }

        }

    )
}