package com.bangkit.tourismapp

import android.app.Application
import com.bangkit.tourismapp.core.di.CoreComponent
import com.bangkit.tourismapp.core.di.DaggerCoreComponent
import com.bangkit.tourismapp.di.AppComponent
import com.bangkit.tourismapp.di.DaggerAppComponent

open class MyApplication : Application() {

    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.factory().create(applicationContext)
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(coreComponent)
    }
}