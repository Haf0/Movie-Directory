package com.tugas.moviedirectory.Api

import com.tugas.moviedirectory.model.DataMovie
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface ApiService {
    @GET("wew.json")
    suspend fun getMovie() : DataMovie
}

private val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl("https://r3i.my.id/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

object MovieApi{
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}