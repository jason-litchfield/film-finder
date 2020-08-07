package com.example.filmfinder.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.filmfinder.data.Movie
import com.example.filmfinder.data.MovieRepository

/**
 * [ViewModel] for supporting the dashboard and detail views.
 */
class MovieViewModel @ViewModelInject constructor(movieRepository: MovieRepository) : ViewModel() {
    val selected = MutableLiveData<Movie>()
    val popularMovies = movieRepository.getPopularMovies()
}