package com.cubidevs.moviedb.list

import com.cubidevs.moviedb.model.Movies
import com.cubidevs.moviedb.services.MovieDBService
import com.cubidevs.moviedb.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ListRepository: IListRepository {

    private var model: ListContract.model

    constructor(model: ListContract.model){
        this.model = model
    }

    override fun loadMovies() {
        MovieDBService.create()
            .getTopRated(Constants.API_KEY)
            .enqueue(object : Callback<Movies>{
                override fun onFailure(call: Call<Movies>, t: Throwable) {
                    model.showErrorLoadMovies(t.message)
                }

                override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                    if (response.isSuccessful){
                        model.moviesLoaded(response.body()?.results)
                    }
                }

            })

    }


}