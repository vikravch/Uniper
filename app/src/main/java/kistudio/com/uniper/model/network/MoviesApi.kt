package kistudio.com.uniper.model.network

import io.reactivex.Observable
import kistudio.com.uniper.model.entities.PopularMoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    @GET("$DISCOVER_POPULARITY_MOVIE_PATH&api_key=$API_KEY")
    fun getPopularMovies(): Observable<PopularMoviesResponse>

    @GET("$DISCOVER_POPULARITY_MOVIE_PATH&api_key=$API_KEY")
    fun getPopularMovies(@Query("page") page:Int): Observable<PopularMoviesResponse>

    companion object {
        const val API_URL = "https://api.themoviedb.org/3/"
        private const val API_KEY = "2d15de624c9811db25aabc1b1fe2503e"

        private const val DISCOVER_POPULARITY_MOVIE_PATH = "discover/movie?sort_by=popularity.desc"
    }
}