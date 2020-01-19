package kistudio.com.uniper.view_model

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kistudio.com.uniper.model.di_dagger.DaggerViewModelInjector
import kistudio.com.uniper.model.di_dagger.NetworkModule
import kistudio.com.uniper.model.di_dagger.ViewModelInjector
import kistudio.com.uniper.model.entities.PopularMoviesResponse
import kistudio.com.uniper.model.network.MoviesApi
import kistudio.com.uniper.model.repository.PopularFilmsFactory
import kistudio.com.uniper.model.repository.PopularFilmsRepository
import javax.inject.Inject

class MainActivityViewModel:ViewModel() {

    private val networkInjector: ViewModelInjector = DaggerViewModelInjector.builder()
        .networkModule(NetworkModule)
        .build()

    @Inject
    lateinit var popularFilmsFactory: PopularFilmsFactory

    val config = PagedList.Config.Builder()
        .setPageSize(50)
        .setInitialLoadSizeHint(50)
        .setEnablePlaceholders(false)
        .build()

    init {
        networkInjector.inject(this)
    }

    fun loadPosts(){
        //popularFilmsRepository.retry()

        //popularFilmsRepository.state.observe()
        /*subscription = moviesApi.getPopularMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {}
            .doOnTerminate {}
            .subscribe(
                { result -> onRetrieveMoviesListSuccess(result) },
                { err -> Log.d("Uniper","Error - $err") }
            )*/
    }

    private fun onRetrieveMoviesListSuccess(result: PopularMoviesResponse?) {
        result?.let {
            Log.d("Uniper", "list - $it")

        }
    }

}