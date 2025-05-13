package com.fit2081.irene33624658.api
import com.fit2081.irene33624658.models.Fruit
import retrofit2.http.GET
import retrofit2.http.Path

interface FruitApi {
    @GET("api/fruit/all")
    suspend fun getAllFruits(): List<Fruit>

    @GET("api/fruit/{name}")
    suspend fun getFruitByName(@Path("name") name: String): Fruit
}