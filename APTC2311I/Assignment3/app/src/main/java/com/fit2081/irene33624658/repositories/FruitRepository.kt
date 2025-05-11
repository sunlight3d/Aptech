package com.fit2081.irene33624658.repositories

import com.fit2081.irene33624658.apis.RetrofitClient
import com.fit2081.irene33624658.models.Fruit

// repositories/FruitRepository.kt
class FruitRepository {
    private val api = RetrofitClient.api

    // Trả về toàn bộ đối tượng Fruit
    suspend fun loadAll(): List<Fruit> {
        return api.getAllFruits()
    }

    suspend fun loadDetail(name: String): Fruit {
        return api.getFruitByName(name)
    }
}
