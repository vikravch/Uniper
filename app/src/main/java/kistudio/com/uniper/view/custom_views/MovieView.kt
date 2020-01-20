package kistudio.com.uniper.view.custom_views

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import com.bumptech.glide.Glide
import kistudio.com.uniper.R
import kistudio.com.uniper.model.entities.Movie

open class MovieView : ImageUrlView {

    lateinit var movie:Movie

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs : AttributeSet) : super(context,attrs)
    constructor(context: Context,  attrs: AttributeSet , defStyleAttr : Int) : super(context, attrs, defStyleAttr)
}