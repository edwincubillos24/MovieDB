package com.cubidevs.moviedb.services

import com.cubidevs.moviedb.model.Movies
import com.cubidevs.moviedb.utils.Constants
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieDBService {

    @GET("movie/top_rated")
    fun getTopRated(@Query("api_key") apiKey:String): Call<Movies>

    companion object{
        fun create() : MovieDBService {
            val retrofit = Retrofit.Builder()
                .baseUrl(Constants.URL_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(MovieDBService::class.java)
        }
    }
}