package acn.gasendo.randomjokesapplication.presentation.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import acn.gasendo.randomjokesapplication.presentation.ui.theme.PostsKtorClientTheme

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val viewmodel = hiltViewModel<HomeViewModel>()
            val state = viewmodel.state.value

            PostsKtorClientTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.LightGray),
                    verticalArrangement = Arrangement.Center,
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
            }
        }
    }
}