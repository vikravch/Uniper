package kistudio.com.uniper.model.entities

import com.squareup.moshi.Json

data class Movie(val id:Int,
                 val title:String,
                 @field:Json(name = "vote_average")  val voteAverage:String,
                 val overview:String,
                 @field:Json(name = "release_date") val releaseDate:String,
                 @field:Json(name = "poster_path") val posterPath:String,
                 @field:Json(name = "backdrop_path") val backdropPath:String,
                 val popularity:String,
                 @field:Json(name = "vote_count") val voteCount:Int){

    constructor():this(0,"","","","",
        "","","",0)
}