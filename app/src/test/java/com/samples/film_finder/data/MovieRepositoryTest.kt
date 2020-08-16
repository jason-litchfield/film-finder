package com.samples.film_finder.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.samples.film_finder.api.MovieResult
import com.samples.film_finder.api.MovieWebService
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class MovieRepositoryTest {
    // To support testing with LiveData
    @get:Rule var rule: TestRule = InstantTaskExecutorRule()

    private lateinit var repository: MovieRepository
    private val mockWebService = mock<MovieWebService>()

    @Before
    fun setup() {
        repository = MovieRepository(mockWebService)
    }

    @Test
    fun update_getsPopularMovies_fromWebService() {
        repository.update()
        verify(mockWebService).getPopularMovies()
    }

    @Test
    fun update_getsPoster_fromWebService() {
        val stubMovie = MovieResult("", "", "some/poster/path.jpg")
        whenever(mockWebService.getPopularMovies()).thenReturn(listOf(stubMovie))
        repository.update()
        verify(mockWebService).getImage(eq("some/poster/path.jpg"))
    }

    @Test
    fun getPopularMovies_matches_movieResults() {
        val stubMovie = MovieResult("12345", "Jurassic Park", "")
        whenever(mockWebService.getPopularMovies()).thenReturn(listOf(stubMovie))
        repository.popularMovies.observeForever { movies ->
            Assert.assertEquals(Movie("12345", "Jurassic Park", null), movies.first())
        }
    }
}