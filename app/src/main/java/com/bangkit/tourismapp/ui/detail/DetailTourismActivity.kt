package com.bangkit.tourismapp.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.tourismapp.R

class DetailTourismActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tourism)
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}