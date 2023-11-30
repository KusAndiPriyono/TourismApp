package com.bangkit.tourismapp.core.di

import android.content.Context
import com.bangkit.tourismapp.core.data.TourismRepository
import com.bangkit.tourismapp.core.data.source.local.LocalDataSource
import com.bangkit.tourismapp.core.data.source.local.room.TourismDatabase
import com.bangkit.tourismapp.core.data.source.remote.RemoteDataSource
import com.bangkit.tourismapp.core.utils.AppExecutors
import com.bangkit.tourismapp.core.utils.JsonHelper

object Injection {

    fun provideRepository(context: Context): TourismRepository {
        val database = TourismDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.tourismDao())
        val appExecutors = AppExecutors()

        return TourismRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}