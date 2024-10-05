package edu.iesam.movies.data.remote

import edu.iesam.movies.domain.Movie

class MovieMockRemoteDataSource {

    private val movies = listOf(
        Movie("1", "title1", "caratula1"),
        Movie("2", "title2", "caratula2"),
        Movie("3", "title3", "caratula3"),
        Movie("4", "title4", "caratula4")
    )

    fun getMovies(): List<Movie> {
        return movies
    }

    fun getMovie(movieId: String): Movie? {
        return movies.firstOrNull { movie ->
            movie.id == movieId
        }
    }
}