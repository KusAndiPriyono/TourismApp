package com.bangkit.tourismapp.core.utils

import com.bangkit.tourismapp.core.data.source.local.entity.TourismEntity
import com.bangkit.tourismapp.core.data.source.remote.response.TourismResponse

object DataMapper {
    fun mapResponseToEntities(input: List<TourismResponse>): List<TourismEntity> {
        val tourismList = ArrayList<TourismEntity>()
        input.map {
            val tourism = TourismEntity(
                tourismId = it.id,
                name = it.name,
                description = it.description,
                address = it.address,
                latitude = it.latitude,
                longitude = it.longitude,
                like = it.like,
                image = it.image,
                isFavorite = false
            )
            tourismList.add(tourism)
        }
        return tourismList
    }
}