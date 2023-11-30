package com.bangkit.tourismapp.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bangkit.tourismapp.R
import com.bangkit.tourismapp.core.data.source.local.entity.TourismEntity
import com.bangkit.tourismapp.databinding.ActivityDetailTourismBinding
import com.bangkit.tourismapp.ui.ViewModelFactory
import com.bumptech.glide.Glide

class DetailTourismActivity : AppCompatActivity() {

    private lateinit var detailTourismViewModel: DetailTourismViewModel
    private lateinit var binding: ActivityDetailTourismBinding


    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTourismBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val factory = ViewModelFactory.getInstance(this)
        detailTourismViewModel =
            ViewModelProvider(this, factory)[DetailTourismViewModel::class.java]

        val detailTourism = intent.getParcelableExtra<TourismEntity>(EXTRA_DATA)
        showDetailTourism(detailTourism)

    }

    private fun showDetailTourism(detailTourism: TourismEntity?) {
        detailTourism?.let {
            supportActionBar?.title = detailTourism.name
            binding.content.tvDetailDescription.text = detailTourism.description
            Glide.with(this@DetailTourismActivity)
                .load(detailTourism.image)
                .into(binding.ivDetailImage)

            var statusFavorite = detailTourism.isFavorite
            setStatusFavorite(statusFavorite)
            binding.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detailTourismViewModel.setFavoriteTourism(detailTourism, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageResource(R.drawable.ic_favorite_white)
        } else {
            binding.fab.setImageResource(R.drawable.ic_not_favorite_white)
        }
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}