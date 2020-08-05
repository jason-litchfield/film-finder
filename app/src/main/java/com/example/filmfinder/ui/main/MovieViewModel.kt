package com.example.filmfinder.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.filmfinder.data.Movie
import com.example.filmfinder.data.MovieRepository
import javax.inject.Inject

class MovieViewModel @Inject constructor(private val movieRepository: MovieRepository) : ViewModel() {
    // TODO: potentially accept SavedStateHandle
    // TODO: include LiveData for a selected movie from the list
    val popularMovies: LiveData<List<Movie>> = movieRepository.getPopularMovies()
}