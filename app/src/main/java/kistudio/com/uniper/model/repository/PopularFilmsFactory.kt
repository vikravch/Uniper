package kistudio.com.uniper.model.repository

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import io.reactivex.disposables.CompositeDisposable
import kistudio.com.uniper.model.entities.Movie
import kistudio.com.uniper.model.network.MoviesApi

class PopularFilmsFactory(
    private val compositeDisposable: CompositeDisposable,
    private val gitSearchApi: MoviesApi
) : DataSource.Factory<Int, Movie>() {

    val newsDataSourceLiveData = MutableLiveData<PopularFilmsRepository>()

    override fun create(): DataSource<Int, Movie> {
        val newsDataSource = PopularFilmsRepository(gitSearchApi, compositeDisposable)
        newsDataSourceLiveData.postValue(newsDataSource)
        return newsDataSource
    }
}