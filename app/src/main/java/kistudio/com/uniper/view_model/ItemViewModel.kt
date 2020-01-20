package kistudio.com.uniper.view_model

import android.view.View
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kistudio.com.uniper.model.entities.Movie
import kistudio.com.uniper.view.MovieView

class ItemViewModel : ViewModel() {
    val firstMovie = MutableLiveData<Movie>()
    val secondMovie = MutableLiveData<Movie>()

    fun bind(movieFirst: Movie, movieSecond: Movie) {
        firstMovie.value = movieFirst
        secondMovie.value = movieSecond
    }

    fun clickOnElement(view: View){
        val movieId = (view as MovieView).movieId
        Toast.makeText(view.context,"Clicked - $movieId",Toast.LENGTH_LONG).show()
    }
}