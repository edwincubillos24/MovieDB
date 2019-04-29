package com.cubidevs.moviedb.favorites

class FavoritesPresenter: FavoritesContract.presenter {

    private var view: FavoritesContract.view
    private var interactor: FavoritesContract.interactor

    constructor(view: FavoritesContract.view){
        this.view = view
        interactor = FavoritesInteractor(this)
    }
}