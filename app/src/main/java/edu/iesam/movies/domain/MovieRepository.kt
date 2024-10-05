package edu.iesam.movies.domain

interface MovieRepository {

    fun getMovies(): List<Movie>
    fun getMovie(movieId: String): Movie?
}