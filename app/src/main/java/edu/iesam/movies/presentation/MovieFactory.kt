package edu.iesam.movies.presentation

import android.content.Context
import edu.iesam.movies.data.MovieDataRepository
import edu.iesam.movies.data.local.MovieXmlLocalDataSource
import edu.iesam.movies.data.remote.MovieMockRemoteDataSource
import edu.iesam.movies.domain.GetMovieUseCase
import edu.iesam.movies.domain.GetMoviesUseCase

class MovieFactory(private val context: Context) {
    private val movieMockRemote = MovieMockRemoteDataSource()
    private val movieLocal = MovieXmlLocalDataSource(context)
    private val movieDataRepository = MovieDataRepository(movieLocal, movieMockRemote)
    private val getMoviesUseCase = GetMoviesUseCase(movieDataRepository)
    private val getMovieUseCase = GetMovieUseCase(movieDataRepository)

    fun buildViewModel(): MoviesViewModel {
        return MoviesViewModel(getMoviesUseCase)
    }

    fun buildMovieDetailViewModel(): MovieDetailViewModel {
        return MovieDetailViewModel(getMovieUseCase)
    }
}