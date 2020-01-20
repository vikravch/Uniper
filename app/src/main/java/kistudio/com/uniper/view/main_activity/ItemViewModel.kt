package kistudio.com.uniper.view.main_activity

import android.view.View
import androidx.lifecycle.ViewModel
import kistudio.com.uniper.model.entities.Movie
import kistudio.com.uniper.view.detail_activity.DetailActivity
import kistudio.com.uniper.view.custom_views.MovieView

class ItemViewModel : ViewModel() {
    lateinit var firstMovie:Movie
    lateinit var secondMovie:Movie

    var firstMovieId = 0
    var secondMovieId = 0
    lateinit var firstMovieBanner:String
    lateinit var secondMovieBanner:String

    fun bind(movieFirst: Movie, movieSecond: Movie) {
        firstMovie = movieFirst
        secondMovie = movieSecond

        firstMovieId = movieFirst.id
        secondMovieId = movieSecond.id
        firstMovieBanner = movieFirst.provideFullImageUrl()
        secondMovieBanner = movieSecond.provideFullImageUrl()
    }

    fun clickOnElement(view: View){
        val movie = (view as MovieView).movie
        DetailActivity.launch(view.context,movie)
//        Toast.makeText(view.context,"Clicked - $movieId",Toast.LENGTH_LONG).show()
    }
}