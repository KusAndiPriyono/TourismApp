package com.bangkit.tourismapp.core.domain.usecase

import com.bangkit.tourismapp.core.data.Resource
import com.bangkit.tourismapp.core.domain.model.Tourism
import kotlinx.coroutines.flow.Flow

interface TourismUseCase {

    fun getAllTourism(): Flow<com.bangkit.tourismapp.core.data.Resource<List<Tourism>>>
    fun getFavoriteTourism(): Flow<List<Tourism>>
    fun setFavoriteTourism(tourism: Tourism, state: Boolean)
}