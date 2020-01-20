package kistudio.com.uniper.view

import android.content.Context
import android.util.AttributeSet
import kistudio.com.uniper.model.entities.Movie

class MovieView:UrlImageView{

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs : AttributeSet) : super(context,attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr : Int) : super(context, attrs, defStyleAttr)

    var movieId = 0

    fun initMovie(movie: Movie){
        url = "https://image.tmdb.org/t/p/w300${movie.backdropPath}"
        movieId = movie.id
    }
}