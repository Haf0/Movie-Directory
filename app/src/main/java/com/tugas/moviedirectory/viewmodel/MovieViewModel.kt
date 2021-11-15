package com.tugas.moviedirectory.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tugas.moviedirectory.Api.ApiService
import com.tugas.moviedirectory.Api.MovieApi
import com.tugas.moviedirectory.model.DataMovie
import com.tugas.moviedirectory.model.Movie
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {
    private val api: ApiService = MovieApi.retrofitService
    var listMovie : List<Movie> by mutableStateOf(listOf())
    var movie : Movie? =null

    init {
        getListMovie()
    }

    private fun getListMovie(){
        viewModelScope.launch {
            try {
                listMovie = api.getMovie().results
            } catch (e: Exception){
                Log.d("error:", e.message.toString())
            }
        }
    }

    fun getdetailMovie(id: Int){
        viewModelScope.launch {
            try {
                movie = listMovie.first{it.id == id}
            } catch (e: Exception){
                Log.d("error:", e.message.toString())
            }
        }
    }
}