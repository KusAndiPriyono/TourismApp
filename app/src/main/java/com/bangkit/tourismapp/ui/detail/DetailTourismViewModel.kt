package com.bangkit.tourismapp.ui.detail

import androidx.lifecycle.ViewModel
import com.bangkit.tourismapp.core.data.TourismRepository
import com.bangkit.tourismapp.core.data.source.local.entity.TourismEntity
import com.bangkit.tourismapp.core.domain.model.Tourism

class DetailTourismViewModel(private val tourismRepository: TourismRepository) : ViewModel() {

    fun setFavoriteTourism(tourism: Tourism, newStatus: Boolean) =
        tourismRepository.setFavoriteTourism(tourism, newStatus)
}