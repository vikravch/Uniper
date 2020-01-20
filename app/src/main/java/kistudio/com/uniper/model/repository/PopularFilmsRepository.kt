package kistudio.com.uniper.model.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Action
import io.reactivex.schedulers.Schedulers
import kistudio.com.uniper.model.entities.Movie
import kistudio.com.uniper.model.network.MoviesApi

class PopularFilmsRepository(
    private val mMoviesApi: MoviesApi,
    private val mCompositeDisposable: CompositeDisposable
) : PageKeyedDataSource<Int, Movie>() {

    var state: MutableLiveData<State> = MutableLiveData()
    private var mRetryCompletable: Completable? = null

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Movie>
    ) {
        updateState(State.LOADING)
        mCompositeDisposable.add(
            mMoviesApi.getPopularMovies()
                .subscribe(
                    { response ->
                        updateState(State.DONE)
                        //Log.d("Uniper", "done - $response")
                        callback.onResult(response.results, null, 2)
                    },
                    {
                        updateState(State.ERROR)
                        setRetry(Action { loadInitial(params, callback) })
                        //Log.d("Uniper", "Error - $it")
                    }
                )
        )
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
        updateState(State.LOADING)
        mCompositeDisposable.add(
            mMoviesApi.getPopularMovies(params.key)
                .subscribe(
                    { response ->
                        updateState(State.DONE)
                        callback.onResult(
                            response.results,
                            params.key + 1
                        )
                    },
                    {
                        updateState(State.ERROR)
                        setRetry(Action { loadAfter(params, callback) })
                    }
                )
        )
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {}

    private fun updateState(state: State) {
        this.state.postValue(state)
    }

    fun retry() {

        if (mRetryCompletable != null) {
            mCompositeDisposable.add(mRetryCompletable!!
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {},
                    { err -> Log.d("Uniper", "Error - $err") }
                ))
        }
    }

    private fun setRetry(action: Action?) {
        mRetryCompletable = if (action == null) null else Completable.fromAction(action)
    }
}

enum class State {
    DONE, LOADING, ERROR
}