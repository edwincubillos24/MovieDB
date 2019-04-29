package com.cubidevs.moviedb.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cubidevs.moviedb.model.Result

import com.cubidevs.moviedb.R
import com.cubidevs.moviedb.adapters.MoviesAdapter
import kotlinx.android.synthetic.main.fragment_list.view.*

class ListFragment : Fragment(), ListContract.view {


    private lateinit var presenter: ListContract.presenter
    private lateinit var viewFragment: View

    private var listMovies = listOf<Result>()

    private lateinit var recyclerView: RecyclerView
    private lateinit var moviesAdapter: MoviesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewFragment = inflater.inflate(R.layout.fragment_list, container, false)

        presenter = ListPresenter(this)

        presenter.loadMovies()

        return viewFragment
    }

    override fun showErrorLoadMovies(message: String?) {
        Toast.makeText(activity!!.applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    override fun moviesLoaded(results: List<Result>?) {
        this.listMovies = results!!

        recyclerView = viewFragment.recyclerViewList
        recyclerView.layoutManager = LinearLayoutManager(activity!!.applicationContext,
            RecyclerView.VERTICAL, false)

        moviesAdapter = MoviesAdapter(activity!!.applicationContext, listMovies!!)
        recyclerView.adapter = moviesAdapter
    }
}
