package com.example.filmfinder.data

import android.util.LruCache
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyZeroInteractions
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Before
import org.junit.Test

class MovieRepositoryTest {
    private val mockMovieDB: TMDBService = mock()
    private val mockDataStore: LruCache<String, Movie> = mock()
    private lateinit var movieRepository: MovieRepository

    @Before
    fun setup() {
        movieRepository = MovieRepository(mockMovieDB, mockDataStore)
    }

    @Test
    fun getPopular_callsMovieDB_onFirstInvocation() {
        movieRepository.getPopularMovies()
        verify(mockMovieDB).getPopular()
    }

    @Test
    fun movieRepo_cachesResults() {
        val jp = Movie("102034", "Jurassic Park")
        whenever(mockMovieDB.getPopular()).thenReturn(mutableListOf(jp))
        movieRepository.getPopularMovies()
        verify(mockDataStore).put("102034", jp)
    }

    @Test
    fun getPopular_cacheIsNotEmpty_remoteIsNotCalled() {
        whenever(mockDataStore.size()).thenReturn(1)
        movieRepository.getPopularMovies()
        verifyZeroInteractions(mockMovieDB)
    }
}