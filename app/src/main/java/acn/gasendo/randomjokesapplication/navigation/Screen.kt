package acn.gasendo.randomjokesapplication.navigation

sealed class Screen(val route: String){
    object Main : Screen(route = "main_screen")
    object Favorites: Screen(route = "favorites_screen")
}
