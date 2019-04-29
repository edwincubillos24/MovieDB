package com.cubidevs.moviedb.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cubidevs.moviedb.R
import com.cubidevs.moviedb.model.Result
import com.squareup.picasso.Picasso

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder> {

    private var listMovies: List<Result>? = null
    private var context: Context? = null

    constructor(context: Context, listMovies: List<Result>){
        this.listMovies = listMovies
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return MoviesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listMovies?.size!!
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.textName?.text = listMovies!![position].originalTitle
        holder.textVote?.text = listMovies!![position].voteAverage.toString()
        Picasso.with(context)
            .load(listMovies!![position].posterPath)
            .into(holder.imagePicture)
    }

    class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textName: TextView? = itemView.findViewById(R.id.tName)
        var textVote: TextView? = itemView.findViewById(R.id.tVote)
        var imagePicture: ImageView? = itemView.findViewById(R.id.iPicture)
    }
}