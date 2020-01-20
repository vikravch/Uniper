package kistudio.com.uniper.model.di_dagger

import dagger.Component
import kistudio.com.uniper.view.detail_activity.DetailActivityViewModel
import kistudio.com.uniper.view.main_activity.MainActivityViewModel
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {
    fun inject(mainActivityViewModel: MainActivityViewModel)
    fun inject(mainActivityViewModel: DetailActivityViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector
        fun networkModule(networkModule: NetworkModule): Builder
    }
}