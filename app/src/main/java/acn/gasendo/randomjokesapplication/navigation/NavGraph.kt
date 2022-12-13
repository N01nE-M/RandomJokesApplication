package acn.gasendo.randomjokesapplication.navigation


import acn.gasendo.randomjokesapplication.presentation.screens.FavoritesScreen
import acn.gasendo.randomjokesapplication.presentation.screens.MainScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
   NavHost(
       navController = navController,
       startDestination = Screen.Main.route ){
        composable(
            route = Screen.Main.route
        ){
            MainScreen(navController = navController)
        }
       composable(
           route = Screen.Favorites.route
       ){
           FavoritesScreen(navController = navController)
       }
   }
}