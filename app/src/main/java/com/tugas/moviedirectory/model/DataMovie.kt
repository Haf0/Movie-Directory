package com.tugas.moviedirectory.model

import com.google.gson.annotations.SerializedName

data class DataMovie (
    val results : List<Movie>
)

data class Movie(
    val title:String,

    val overview:String,

    @SerializedName("poster_path")
    val posterpath:String,

    @SerializedName("release_date")
    val releasedate: String,

    @SerializedName("original_title")
    val originaltittle: String,

    val popularity: String,

    val id: Int
)