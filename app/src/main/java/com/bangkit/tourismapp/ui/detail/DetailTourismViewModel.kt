package com.bangkit.tourismapp.ui.detail

import androidx.lifecycle.ViewModel
import com.bangkit.tourismapp.core.domain.model.Tourism
import com.bangkit.tourismapp.core.domain.usecase.TourismUseCase

class DetailTourismViewModel(private val tourismUseCase: TourismUseCase) : ViewModel() {

    fun setFavoriteTourism(tourism: Tourism, newStatus: Boolean) =
        tourismUseCase.setFavoriteTourism(tourism, newStatus)
}