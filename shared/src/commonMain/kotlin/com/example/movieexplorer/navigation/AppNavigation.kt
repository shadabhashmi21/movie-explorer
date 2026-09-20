package com.example.movieexplorer.navigation

import HomeScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.movieexplorer.presentation.details.MovieDetailsScreen

import kotlinx.serialization.Serializable

@Serializable
data object HomeRoute

@Serializable
data class MovieDetailsRoute(
    val movieId: Int
)

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = HomeRoute
    ) {

        composable<HomeRoute> {
            HomeScreen(
                onMovieClick = { movieId ->
                    navController.navigate(
                        MovieDetailsRoute(movieId)
                    )
                }
            )
        }

        composable<MovieDetailsRoute> { backStackEntry ->

            val route = backStackEntry.toRoute<MovieDetailsRoute>()

            MovieDetailsScreen(
                movieId = route.movieId,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}