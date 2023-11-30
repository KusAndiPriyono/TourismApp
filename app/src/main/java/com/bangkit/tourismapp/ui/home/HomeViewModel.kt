package com.bangkit.tourismapp.ui.home

import androidx.lifecycle.ViewModel
import com.bangkit.tourismapp.core.data.TourismRepository

class HomeViewModel(tourismRepository: TourismRepository) : ViewModel() {

    val tourism = tourismRepository.getAllTourism()
}