package com.cubidevs.moviedb.list

import com.cubidevs.moviedb.model.Result

interface ListContract {
    interface view {
        fun showErrorLoadMovies(message: String?)
        fun moviesLoaded(results: List<Result>?)

    }

    interface presenter {
        fun loadMovies()
        fun showErrorLoadMovies(message: String?)
        fun moviesLoaded(results: List<Result>?)

    }

    interface model {
        fun loadMovies()
        fun showErrorLoadMovies(message: String?)
        fun moviesLoaded(results: List<Result>?)

    }
}