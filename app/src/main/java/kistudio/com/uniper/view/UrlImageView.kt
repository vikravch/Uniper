package kistudio.com.uniper.view

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import com.bumptech.glide.Glide
import kistudio.com.uniper.R

open class UrlImageView : ImageView {

    var url: String = ""
        set(value){
            field = value
            Glide.with(this).load(value).into(this)
        }

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs : AttributeSet) : super(context,attrs){
        val array = context.obtainStyledAttributes(attrs, R.styleable.UrlImageView)
        val url = array.getString(R.styleable.UrlImageView_url)
        if(url!=null){
            Glide.with(this).load(url).into(this)
        }
        array.recycle()
    }

    constructor(context: Context,  attrs: AttributeSet , defStyleAttr : Int) : super(context, attrs, defStyleAttr)
}