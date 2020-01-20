package kistudio.com.uniper.model.entities

import android.os.Parcelable
import com.squareup.moshi.Json
import kistudio.com.uniper.model.network.MoviesApi
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(val id:Int,
                 val title:String,
                 @field:Json(name = "vote_average")  val voteAverage:String,
                 val overview:String,
                 @field:Json(name = "release_date") val releaseDate:String,
                 @field:Json(name = "poster_path") val posterPath:String,
                 @field:Json(name = "backdrop_path") val backdropPath:String,
                 val popularity:String,
                 @field:Json(name = "vote_count") val voteCount:Int):Parcelable{

    fun provideFullImageUrl() = "${MoviesApi.IMAGE_URL}$posterPath"

    constructor():this(0,"","","","",
        "","","",0)
}