package com.samples.film_finder.data

import androidx.lifecycle.MutableLiveData
import com.samples.film_finder.api.MovieWebService

class MovieRepository(private val webService: MovieWebService) {

    val popularMovies = MutableLiveData<List<Movie>>()

    fun update() {
        popularMovies.postValue(mutableListOf<Movie>().also { list ->
            webService.getPopularMovies().forEach { result ->
                list.add(
                    Movie(
                        result.id,
                        result.title,
                        result.posterPath?.let { webService.getImage(it) })
                )
            }
        })
    }
}