package kistudio.com.uniper.model

data class Movie(val id:Int,val title:String,val voteAverage:String,val overview:String,
                 val releaseDate:String,val posterPath:String,val backdropPath:String,
                 val popularity:Int,val voteCount:Int)