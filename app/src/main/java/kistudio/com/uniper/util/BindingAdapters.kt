package kistudio.com.uniper.util

import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import kistudio.com.uniper.model.entities.Movie
import kistudio.com.uniper.view.custom_views.ImageUrlView
import kistudio.com.uniper.view.custom_views.MovieView

@BindingAdapter("mutableVisibility")
fun setMutableVisibility(view: View, visibility: MutableLiveData<Int>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if(parentActivity != null && visibility != null) {
        visibility.observe(parentActivity, Observer { value -> view.visibility = value?:View.VISIBLE})
    }
}

@BindingAdapter("mutableText")
fun setMutableText(view: TextView,  text: MutableLiveData<String>?) {
    val parentActivity:AppCompatActivity? = view.getParentActivity()
    if(parentActivity != null && text != null) {
        text.observe(parentActivity, Observer { value ->
            Log.d("Uniper","Updated to $value")
            view.text = value?:"aaaaa"})
    }
}


@BindingAdapter("mutableUrl")
fun setMutableUrl(view: ImageUrlView,  url: MutableLiveData<String>?) {
    val parentActivity:AppCompatActivity? = view.getParentActivity()
    if(parentActivity != null && url != null) {
        url.observe(parentActivity, Observer { value ->
            view.url = value?:""})
    }
}

@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
}

@BindingAdapter("movie")
fun setMovie(view: MovieView, movie: Movie) {
    view.movie = movie
}


@BindingAdapter("mutableTitle")
fun setMutableTitle(view: Toolbar, text: MutableLiveData<String>?) {
    val parentActivity:AppCompatActivity? = view.getParentActivity()
    if(parentActivity != null && text != null) {
        text.observe(parentActivity, Observer { value -> view.title = value?:""})
    }
}