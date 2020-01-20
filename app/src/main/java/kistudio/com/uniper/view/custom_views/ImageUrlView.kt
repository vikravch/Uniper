package kistudio.com.uniper.view.custom_views

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import com.bumptech.glide.Glide
import kistudio.com.uniper.R

open class ImageUrlView: ImageView {


    var url: String = ""
        set(value){
            field = value
            Glide.with(context).load(value).into(this)
        }

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs : AttributeSet) : super(context,attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr : Int) : super(context, attrs, defStyleAttr){
        val array = context.obtainStyledAttributes(attrs, R.styleable.MovieView)
        val url = array.getString(R.styleable.MovieView_url)
        if(url!=null){
            Glide.with(context).load(url).into(this)
        }
        array.recycle()
    }
}