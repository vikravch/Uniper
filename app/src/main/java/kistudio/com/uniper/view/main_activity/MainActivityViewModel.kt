package kistudio.com.uniper.view.main_activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import kistudio.com.uniper.model.di_dagger.DaggerViewModelInjector
import kistudio.com.uniper.model.di_dagger.NetworkModule
import kistudio.com.uniper.model.di_dagger.ViewModelInjector
import kistudio.com.uniper.model.entities.Movie
import kistudio.com.uniper.model.repository.PopularFilmsFactory
import javax.inject.Inject

class MainActivityViewModel : ViewModel() {

    private val mNetworkInjector: ViewModelInjector = DaggerViewModelInjector.builder()
        .networkModule(NetworkModule)
        .build()

    @Inject
    lateinit var popularFilmsFactory: PopularFilmsFactory

    private val mConfig = PagedList.Config.Builder()
        .setPageSize(20)
        .setInitialLoadSizeHint(20)
        .setEnablePlaceholders(false)
        .build()

    val popularMoviesList:LiveData<PagedList<Movie>>
    val moviesMainAdapter: MoviesMainAdapter

    init {
        mNetworkInjector.inject(this)

        popularMoviesList = LivePagedListBuilder(popularFilmsFactory, mConfig).build()
        moviesMainAdapter =
            MoviesMainAdapter { popularFilmsFactory.newsDataSourceLiveData.value?.retry() }
    }
}