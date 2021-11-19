package com.tugas.moviedirectory

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.constraintlayout.utils.widget.MockView
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.tugas.moviedirectory.model.DataMovie
import com.tugas.moviedirectory.model.Movie
import com.tugas.moviedirectory.screen.DetailScreen
import com.tugas.moviedirectory.screen.HomeScreen
import com.tugas.moviedirectory.screen.ProfileScreen
import com.tugas.moviedirectory.ui.theme.MovieDirectoryTheme
import com.tugas.moviedirectory.viewmodel.MovieViewModel

class MainActivity() : ComponentActivity() {
    private val modelViewModel by viewModels<MovieViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            MovieDirectoryTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize()) {
                    NavHost(navController = navController, startDestination = "homeScreen"){
                        composable("homeScreen"){
                            HomeScreen(movieViewModel = modelViewModel, navController = navController)
                        }
                        composable("profilScreen"){
                            ProfileScreen()
                        }
                        composable("detailScreen/{id}",
                            arguments = listOf(navArgument("id"){type= NavType.IntType})
                        ){
                                navBackStackEntry -> DetailScreen(model = modelViewModel, id = navBackStackEntry.arguments?.getInt("id")!!)
                        }
                    }
                }
            }
        }
    }
}
