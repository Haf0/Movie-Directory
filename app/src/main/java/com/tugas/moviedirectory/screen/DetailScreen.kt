package com.tugas.moviedirectory.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.tugas.moviedirectory.R
import com.tugas.moviedirectory.model.Movie
import com.tugas.moviedirectory.viewmodel.MovieViewModel

@Composable
fun DetailScreen(model: MovieViewModel, id:Int) {
    model.getdetailMovie(id=id)
    val data: Movie = model.movie!!

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(top = 20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(painter = rememberImagePainter("https://themoviedb.org/t/p/w500/${data.posterpath}") ,contentDescription = null)
        }

        Divider(color = androidx.compose.ui.graphics.Color.LightGray, thickness = 2.dp,modifier = Modifier.padding(vertical = 20.dp))
        TextRow(jenisnya = stringResource(R.string.detailjudul), isinya = ": ${data.originaltittle}" )
        TextRow(jenisnya = stringResource(R.string.detailrilis), isinya = ": ${data.releasedate}")
        TextRow(jenisnya = stringResource(R.string.detailpopularitas), isinya = ": ${data.popularity}")
        Divider(color = androidx.compose.ui.graphics.Color.LightGray, thickness = 1.dp,modifier = Modifier.padding(vertical = 20.dp))
        Text(text = stringResource(R.string.detailsinopsis),
            style = TextStyle(
                fontSize = 30.sp
            )
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Text(text = data.overview)
        Divider(color = androidx.compose.ui.graphics.Color.LightGray, thickness = 1.dp,modifier = Modifier.padding(vertical = 20.dp))


    }

}


@Composable
fun TextRow(jenisnya: String, isinya:String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(modifier = Modifier
            .weight(1.0f)) {
            Text(text = jenisnya)
        }
        Row(modifier = Modifier
            .weight(2.0f)) {
            Text(text = isinya)
        }
    }
}
