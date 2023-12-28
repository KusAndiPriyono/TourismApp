package com.bangkit.tourismapp.di

import com.bangkit.tourismapp.core.domain.usecase.TourismUseCase
import dagger.Module
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@EntryPoint
@InstallIn(SingletonComponent::class)
interface MapsModuleDependencies {
    fun tourismUseCase(): TourismUseCase
}