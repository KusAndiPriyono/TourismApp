package com.bangkit.tourismapp.maps

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.bangkit.tourismapp.core.domain.usecase.TourismUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MapsViewModel @Inject constructor(tourismUseCase: TourismUseCase) : ViewModel() {
    val tourism = tourismUseCase.getAllTourism().asLiveData()
}