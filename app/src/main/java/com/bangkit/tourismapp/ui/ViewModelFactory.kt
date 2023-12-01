package com.bangkit.tourismapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bangkit.tourismapp.di.AppScope
import javax.inject.Inject
import javax.inject.Provider

@AppScope

class ViewModelFactory @Inject constructor(private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>) :
    ViewModelProvider.NewInstanceFactory() {

//    companion object {
//
//        @Volatile
//        private var instance: ViewModelFactory? = null
//
//        fun getInstance(context: Context): ViewModelFactory = instance ?: synchronized(this) {
//            instance ?: ViewModelFactory(
//                Injection.provideTourismUseCase(context)
//            )
//        }
//    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val creator = creators[modelClass] ?: creators.entries.firstOrNull {
            modelClass.isAssignableFrom(it.key)
        }?.value ?: throw IllegalArgumentException("Unknown ViewModel class: $modelClass")
        return creator.get() as T
    }
}