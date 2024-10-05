package edu.iesam.movies.data.remote

import edu.iesam.movies.domain.Movie

class MovieMockRemoteDataSource {

    private val movies = listOf(
        Movie("1", "title1", "https://pics.filmaffinity.com/the_sting-433653100-mmed.jpg"),
        Movie("2", "title2", "https://pics.filmaffinity.com/the_sting-433653100-mmed.jpg"),
        Movie("3", "title3", "https://pics.filmaffinity.com/the_sting-433653100-mmed.jpg"),
        Movie("4", "title4", "https://pics.filmaffinity.com/the_sting-433653100-mmed.jpg")
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