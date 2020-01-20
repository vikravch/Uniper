package kistudio.com.uniper.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import kistudio.com.uniper.model.di_dagger.DaggerViewModelInjector
import kistudio.com.uniper.model.di_dagger.NetworkModule
import kistudio.com.uniper.model.di_dagger.ViewModelInjector
import kistudio.com.uniper.model.entities.Movie
import kistudio.com.uniper.model.repository.PopularFilmsFactory
import kistudio.com.uniper.view.MoviesMainAdapter
import javax.inject.Inject

class MainActivityViewModel : ViewModel() {

    private val networkInjector: ViewModelInjector = DaggerViewModelInjector.builder()
        .networkModule(NetworkModule)
        .build()

    @Inject
    lateinit var popularFilmsFactory: PopularFilmsFactory
    private val config = PagedList.Config.Builder()
        .setPageSize(20)
        .setInitialLoadSizeHint(20)
        .setEnablePlaceholders(false)
        .build()

    val popularMoviesList:LiveData<PagedList<Movie>>
    val moviesMainAdapter:MoviesMainAdapter

    init {
        networkInjector.inject(this)
        popularMoviesList = LivePagedListBuilder(popularFilmsFactory, config).build()
        moviesMainAdapter = MoviesMainAdapter { popularFilmsFactory.newsDataSourceLiveData.value?.retry() }
    }
}