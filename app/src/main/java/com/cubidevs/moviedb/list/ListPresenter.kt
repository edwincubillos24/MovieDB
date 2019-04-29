package com.cubidevs.moviedb.list

import com.cubidevs.moviedb.model.Result

class ListPresenter: ListContract.presenter {


    private var view: ListContract.view
    private var interactor: ListContract.model

    constructor(view: ListContract.view){
        this.view = view
        interactor = ListInteractor(this)
    }

    override fun loadMovies() {
        interactor.loadMovies()
    }

    override fun showErrorLoadMovies(message: String?) {
        view.showErrorLoadMovies(message)
    }

    override fun moviesLoaded(results: List<Result>?) {
        view.moviesLoaded(results)
    }

}