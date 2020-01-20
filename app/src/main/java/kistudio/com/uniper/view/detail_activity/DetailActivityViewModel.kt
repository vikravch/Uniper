package kistudio.com.uniper.view.detail_activity

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kistudio.com.uniper.model.entities.Movie

class DetailActivityViewModel : ViewModel() {

    val title = MutableLiveData<String>()
    val rate = MutableLiveData<String>()
    val detailed = MutableLiveData<String>()
    val banner = MutableLiveData<String>()

    fun setMovie(inMovie: Movie) {
        Log.d("Uniper","movie - $inMovie")
        this.title.value = inMovie.title
        this.rate.value = "Vote average: ${inMovie.voteAverage}"
        this.detailed.value = inMovie.overview
        this.banner.value = inMovie.provideFullImageUrl()
    }
}