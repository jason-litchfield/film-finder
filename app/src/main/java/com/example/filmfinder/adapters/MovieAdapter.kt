package com.example.filmfinder.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.filmfinder.data.Movie
import com.example.filmfinder.databinding.ListItemMovieBinding

/**
 * Adapter class to set the view for movie elements in the recycler.
 */
class MovieAdapter : ListAdapter<Movie, RecyclerView.ViewHolder>(MovieDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MovieViewHolder(ListItemMovieBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val movie = getItem(position)
        (holder as MovieViewHolder).bind(movie)
    }

    /**
     * View holder for movie entries in the list.
     *
     * @param binding Data binding template to provide data to.
     */
    class MovieViewHolder(
        private val binding: ListItemMovieBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.movieCard.setOnClickListener {
                // TODO: navigate to the details page
            }
        }

        /**
         * Sets the given movie data into the view.
         *
         * @param movie The movie data to set into the view.
         */
        fun bind(movie: Movie) {
            binding.movieName.text = movie.title
        }
    }
}

private class MovieDiffCallback : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: Movie, newItem: Movie) = oldItem == newItem
}