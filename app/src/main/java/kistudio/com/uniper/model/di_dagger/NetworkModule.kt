package kistudio.com.uniper.model.di_dagger

import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kistudio.com.uniper.model.network.MoviesApi
import kistudio.com.uniper.model.repository.PopularFilmsFactory
import kistudio.com.uniper.model.repository.PopularFilmsRepository
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@Suppress("unused")
object NetworkModule {

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRepositoriesApi(retrofit: Retrofit): MoviesApi {
        return retrofit.create(MoviesApi::class.java)
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofitInterface(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(MoviesApi.API_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build()
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun providePopularFilmsRepository(moviesApi: MoviesApi): PopularFilmsRepository {
        return PopularFilmsRepository(moviesApi, CompositeDisposable())
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun providePopularFilmsFactory(moviesApi: MoviesApi): PopularFilmsFactory {
        return PopularFilmsFactory(CompositeDisposable(), moviesApi)
    }
}