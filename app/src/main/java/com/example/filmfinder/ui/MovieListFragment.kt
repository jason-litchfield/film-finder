package com.example.filmfinder.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import com.example.filmfinder.adapters.MovieAdapter
import com.example.filmfinder.databinding.FragmentMovieListBinding

/**
 * A [Fragment] for browsing movies.
 * Use the [MovieListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MovieListFragment : Fragment() {
    private val viewModel: MovieViewModel by activityViewModels()

    /**
     * Sets up the view binding and adapter for the movie list to be displayed.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentMovieListBinding.inflate(inflater, container, false)
        val movieAdapter = MovieAdapter()
        binding.movieList.adapter = movieAdapter

        viewModel.popularMovies.observe(viewLifecycleOwner) { movies ->
            movieAdapter.submitList(movies)
        }
        return binding.root
    }

    companion object {
        fun newInstance() = MovieListFragment()
    }
}