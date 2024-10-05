package edu.iesam.movies.data.local

import android.content.Context
import com.google.gson.Gson
import edu.iesam.movies.R
import edu.iesam.movies.domain.Movie

class MovieXmlLocalDataSource(private val context: Context) {

    private val sharedPref = context.getSharedPreferences(
        context.getString(R.string.movies_file_xml), Context.MODE_PRIVATE
    )

    private val gson = Gson()

    fun save(movie: Movie) {
        val editor = sharedPref.edit()
        editor.putString(movie.id, gson.toJson(movie))
        editor.apply()
    }

    fun saveAll(movies: List<Movie>) {
        val editor = sharedPref.edit()
        movies.forEach { movie ->
            editor.putString(movie.id, gson.toJson(movie))
        }
        editor.apply()
    }

    fun findById(movieId: String): Movie? {
        return sharedPref.getString(movieId,null)?.let { movie ->
            gson.fromJson(movie, Movie::class.java)
        }
    }

    fun findAll(): List<Movie> {
        val movies = ArrayList<Movie>()
        val mapMovies = sharedPref.all
        mapMovies.values.forEach { jsonMovie ->
            val movie = gson.fromJson(jsonMovie as String, Movie::class.java)
            movies.add(movie)
        }
        return movies
    }

}