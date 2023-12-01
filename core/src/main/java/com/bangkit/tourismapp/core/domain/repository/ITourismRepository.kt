package com.bangkit.tourismapp.core.domain.repository

import com.bangkit.tourismapp.core.data.Resource
import com.bangkit.tourismapp.core.domain.model.Tourism
import kotlinx.coroutines.flow.Flow

interface ITourismRepository {
    fun getAllTourism(): Flow<com.bangkit.tourismapp.core.data.Resource<List<Tourism>>>

    fun getFavoriteTourism(): Flow<List<Tourism>>

    fun setFavoriteTourism(tourism: Tourism, state: Boolean)
}