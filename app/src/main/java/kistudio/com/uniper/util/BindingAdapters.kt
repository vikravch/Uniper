package kistudio.com.uniper.util

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import kistudio.com.uniper.model.entities.Movie
import kistudio.com.uniper.util.getParentActivity
import kistudio.com.uniper.view.MovieView

@BindingAdapter("mutableVisibility")
fun setMutableVisibility(view: View, visibility: MutableLiveData<Int>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if(parentActivity != null && visibility != null) {
        visibility.observe(parentActivity, Observer { value -> view.visibility = value?:View.VISIBLE})
    }
}

@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
}

@BindingAdapter("mutableMovie")
fun setMovie(view: MovieView, movie: MutableLiveData<Movie>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if(parentActivity != null && movie!=null) {
        movie.observe(parentActivity, Observer { it?.let{ view.initMovie(it)}} )
    }
}