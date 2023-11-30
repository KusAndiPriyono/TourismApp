package com.bangkit.tourismapp.core.data

import androidx.lifecycle.LiveData
import com.bangkit.tourismapp.core.data.source.local.LocalDataSource
import com.bangkit.tourismapp.core.data.source.local.entity.TourismEntity
import com.bangkit.tourismapp.core.data.source.remote.RemoteDataSource
import com.bangkit.tourismapp.core.data.source.remote.network.ApiResponse
import com.bangkit.tourismapp.core.data.source.remote.response.TourismResponse
import com.bangkit.tourismapp.core.utils.AppExecutors
import com.bangkit.tourismapp.core.utils.DataMapper

class TourismRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) {

    companion object {

        @Volatile
        private var instance: TourismRepository? = null

        fun getInstance(
            remoteData: RemoteDataSource,
            localData: LocalDataSource,
            appExecutors: AppExecutors
        ): TourismRepository = instance ?: synchronized(this) {
            instance ?: TourismRepository(remoteData, localData, appExecutors)
        }
    }

    fun getAllTourism(): LiveData<Resource<List<TourismEntity>>> =
        object : NetworkBoundResource<List<TourismEntity>, List<TourismResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<TourismEntity>> {
                return localDataSource.getAllTourism()
            }

            override fun createCall(): LiveData<ApiResponse<List<TourismResponse>>> =
                remoteDataSource.getAllTourism()

            override fun saveCallResult(data: List<TourismResponse>) {
                val tourismList = DataMapper.mapResponseToEntities(data)
                localDataSource.insertTourism(tourismList)
            }

            override fun shouldFetch(data: List<TourismEntity>?): Boolean =
                data.isNullOrEmpty()
        }.asLiveData()

    fun getFavoriteTourism(): LiveData<List<TourismEntity>> {
        return localDataSource.getFavoriteTourism()
    }

    fun setFavoriteTourism(tourism: TourismEntity, state: Boolean) {
        appExecutors.diskIO().execute { localDataSource.setFavoriteTourism(tourism, state) }
    }
}