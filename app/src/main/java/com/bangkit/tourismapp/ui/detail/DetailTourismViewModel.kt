package com.bangkit.tourismapp.ui.detail

import androidx.lifecycle.ViewModel
import com.bangkit.tourismapp.core.data.TourismRepository
import com.bangkit.tourismapp.core.data.source.local.entity.TourismEntity

class DetailTourismViewModel(private val tourismRepository: TourismRepository) : ViewModel() {

    fun setFavoriteTourism(tourism: TourismEntity, newStatus: Boolean) =
        tourismRepository.setFavoriteTourism(tourism, newStatus)
}