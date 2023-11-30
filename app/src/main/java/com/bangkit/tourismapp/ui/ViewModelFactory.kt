package com.bangkit.tourismapp.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bangkit.tourismapp.core.data.TourismRepository
import com.bangkit.tourismapp.core.di.Injection
import com.bangkit.tourismapp.ui.detail.DetailTourismViewModel
import com.bangkit.tourismapp.ui.favorite.FavoriteViewModel
import com.bangkit.tourismapp.ui.home.HomeViewModel

class ViewModelFactory private constructor(private val tourismRepository: TourismRepository) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {

        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory = instance ?: synchronized(this) {
            instance ?: ViewModelFactory(
                Injection.provideRepository(context)
            )
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(tourismRepository) as T
            }

            modelClass.isAssignableFrom(DetailTourismViewModel::class.java) -> {
                DetailTourismViewModel(tourismRepository) as T
            }

            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
                FavoriteViewModel(tourismRepository) as T
            }

            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}