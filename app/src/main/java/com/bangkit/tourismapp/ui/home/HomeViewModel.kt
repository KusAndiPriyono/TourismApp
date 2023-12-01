package com.bangkit.tourismapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.bangkit.tourismapp.core.domain.usecase.TourismUseCase

class HomeViewModel(tourismUseCase: TourismUseCase) : ViewModel() {

    val tourism = tourismUseCase.getAllTourism().asLiveData()
}