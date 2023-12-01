package com.bangkit.tourismapp.core.di

import com.bangkit.tourismapp.core.data.TourismRepository
import com.bangkit.tourismapp.core.domain.repository.ITourismRepository
import dagger.Binds
import dagger.Module

@Module(includes = [NetworkModule::class, DatabaseModule::class])
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(tourismRepository: TourismRepository): ITourismRepository
}