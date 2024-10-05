package edu.iesam.movies.presentation

import androidx.lifecycle.ViewModel
import edu.iesam.movies.domain.GetMovieUseCase
import edu.iesam.movies.domain.Movie

class MovieDetailViewModel(
    private val getMovieUseCase: GetMovieUseCase
): ViewModel() {

    fun viewCreated(movieId: String): Movie? {
        return getMovieUseCase.invoke(movieId)
    }
}