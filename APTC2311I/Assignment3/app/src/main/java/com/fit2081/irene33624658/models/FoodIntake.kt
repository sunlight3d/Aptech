package com.fit2081.irene33624658.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

// FoodIntake.kt
@Entity(
    tableName = "food_intakes",
    foreignKeys = [ForeignKey(
        entity = Patient::class,
        parentColumns = ["userId"],
        childColumns = ["patientId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class FoodIntake(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val patientId: String,

    // Lưu dưới dạng string cách nhau bằng dấu phẩy
    val foodCategories: String, // Ví dụ: "Fruits,Vegetables,Seafood"

    val selectedPersona: PersonaType,
    val biggestMealTime: String,
    val sleepTime: String,
    val wakeUpTime: String,
    val createdAt: Long = System.currentTimeMillis()
) {
    enum class PersonaType {
        HEALTH_DEVOTEE, MINDFUL_EATER, WELLNESS_STRIVER,
        BALANCE_SEEKER, HEALTH_PROCRASTINATOR, FOOD_CAREFREE;

        override fun toString() = name
    }

    // Hàm tiện ích để chuyển foodCategories thành List
    fun getFoodCategoriesList(): List<String> {
        return if (foodCategories.isBlank()) emptyList()
        else foodCategories.split(",").map { it.trim() }
    }
}