package com.tugas.moviedirectory.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.tugas.moviedirectory.R
import com.tugas.moviedirectory.model.Movie
import com.tugas.moviedirectory.viewmodel.MovieViewModel

@Composable
fun HomeScreen(movieViewModel: MovieViewModel,navController: NavController) {
    Scaffold(
        topBar = { TopBarApp(navController = navController)},
        content = {
            Column() {
                Spacer(modifier = Modifier.height(15.dp))
                Detaillist(movie = movieViewModel.listMovie, navController = navController, movieViewModel = movieViewModel)
            }
        }
    )
}

@Composable
fun Detaillist(movie: List<Movie>, navController: NavController, movieViewModel: MovieViewModel) {
    if(movie.size >0){
        LazyColumn{
            itemsIndexed(items=movie){
                    _, 
                    item -> DetailCard(data = item, navController = navController, movieViewModel = movieViewModel )
            }
        }
    }
}


@Composable
fun DetailCard(data:Movie, navController: NavController,movieViewModel:MovieViewModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable {
                movieViewModel.getdetailMovie(data.id)
                navController.navigate("detailScreen/${data.id}")
            },
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp,
    ) {
        Box(
            modifier = Modifier
                .height(200.dp)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Image(
                    painter = rememberImagePainter("https://themoviedb.org/t/p/w500/${data.posterpath}"),
                    contentDescription = data.title,
                    contentScale = ContentScale.FillWidth
                )
            }
            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 400f
                    )
                )
            )
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(text = data.title,style = TextStyle(color = Color.White, fontSize = 16.sp))
            }
        }

    }
}

@Composable
fun TopBarApp(navController: NavController) {
    TopAppBar(
        title = { Text(text = stringResource(R.string.homebar))},
        actions = {
            IconButton(
                onClick = {
                    navController.navigate("profilScreen")
                }
            ) {
                androidx.compose.material.Icon(Icons.Filled.AccountCircle, contentDescription = "Profil")
            }

        }
    )
}
