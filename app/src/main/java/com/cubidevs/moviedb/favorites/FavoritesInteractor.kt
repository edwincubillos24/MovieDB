package com.cubidevs.moviedb.favorites

class FavoritesInteractor: FavoritesContract.interactor {

    private var presenter: FavoritesContract.presenter
    private var repository: IFavoritesRepository

    constructor(presenter: FavoritesContract.presenter){
        this.presenter = presenter
        repository = FavoritesRepository(this)
    }
}