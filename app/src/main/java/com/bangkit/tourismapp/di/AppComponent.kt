package com.bangkit.tourismapp.di

import com.bangkit.tourismapp.core.di.CoreComponent
import com.bangkit.tourismapp.ui.detail.DetailTourismActivity
import com.bangkit.tourismapp.ui.favorite.FavoriteFragment
import com.bangkit.tourismapp.ui.home.HomeFragment
import dagger.Component

@AppScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [AppModule::class, ViewModelModule::class]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent): AppComponent
    }

    fun inject(fragment: HomeFragment)
    fun inject(fragment: FavoriteFragment)
    fun inject(activity: DetailTourismActivity)
}