package edu.iesam.movies.presentation

import androidx.lifecycle.ViewModel
import edu.iesam.movies.domain.GetMoviesUseCase
import edu.iesam.movies.domain.Movie

class MoviesViewModel(
    private val getMoviesUseCase: GetMoviesUseCase
): ViewModel() {

    fun viewCreated(): List<Movie> {
        return getMoviesUseCase.invoke()
    }
}