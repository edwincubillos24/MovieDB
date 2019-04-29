package com.cubidevs.moviedb.favorites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.cubidevs.moviedb.R

class FavoritesFragment : Fragment(), FavoritesContract.view {

    private lateinit var presenter: FavoritesContract.presenter
    private lateinit var viewFragment: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewFragment = inflater.inflate(R.layout.fragment_favorites, container, false)

        presenter = FavoritesPresenter(this)

        return viewFragment
    }


}
