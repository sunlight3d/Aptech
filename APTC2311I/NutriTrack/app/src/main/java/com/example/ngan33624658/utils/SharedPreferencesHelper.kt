// Tạo file mới SharedPreferencesHelper.kt
package com.example.ngan33624658.utils

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesHelper(context: Context) {
    private val sharedPref: SharedPreferences =
        context.getSharedPreferences("FoodIntakePrefs", Context.MODE_PRIVATE)

    //save data to SharedPref
    fun saveFoodPreferences(selectedFoods: List<String>) {
        val editor = sharedPref.edit()
        editor.putStringSet("selected_foods", selectedFoods.toSet())
        editor.apply()
    }

    fun savePersona(persona: String) {
        sharedPref.edit().putString("selected_persona", persona).apply()
    }

    fun saveTimings(biggestMeal: String, sleepTime: String, wakeUpTime: String) {
        sharedPref.edit().apply {
            putString("biggest_meal_time", biggestMeal)
            putString("sleep_time", sleepTime)
            putString("wake_up_time", wakeUpTime)
            apply()
        }
    }

    //read data from SharedPref
    fun getSelectedFoods(): Set<String> {
        return sharedPref.getStringSet("selected_foods", emptySet()) ?: emptySet()
    }

    fun getSelectedPersona(): String {
        return sharedPref.getString("selected_persona", "") ?: ""
    }

    fun getBiggestMealTime(): String {
        return sharedPref.getString("biggest_meal_time", "00:00") ?: "00:00"
    }

    fun getSleepTime(): String {
        return sharedPref.getString("sleep_time", "00:00") ?: "00:00"
    }

    fun getWakeUpTime(): String {
        return sharedPref.getString("wake_up_time", "00:00") ?: "00:00"
    }
    fun clearAllData() {
        sharedPref.edit().clear().apply()
    }
}