package com.bangkit.tourismapp.ui.favorite

import androidx.lifecycle.ViewModel
import com.bangkit.tourismapp.core.data.TourismRepository

class FavoriteViewModel(tourismRepository: TourismRepository) : ViewModel() {

    val favoriteTourism = tourismRepository.getFavoriteTourism()
}