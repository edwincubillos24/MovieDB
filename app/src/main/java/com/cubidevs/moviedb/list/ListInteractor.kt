package com.cubidevs.moviedb.list

import com.cubidevs.moviedb.model.Result

class ListInteractor: ListContract.model {


    private var presenter: ListContract.presenter
    private var repository: IListRepository

    constructor(presenter: ListContract.presenter){
        this.presenter = presenter
        repository = ListRepository(this)
    }

    override fun loadMovies() {
        repository.loadMovies()
    }

    override fun showErrorLoadMovies(message: String?) {
        presenter.showErrorLoadMovies(message)
    }

    override fun moviesLoaded(results: List<Result>?) {
        presenter.moviesLoaded(results)
    }


}