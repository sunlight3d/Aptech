package com.fit2081.irene33624658.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class SharedPreferencesHelper(context: Context) {
    private val sharedPref: SharedPreferences =
        context.getSharedPreferences("AppPreferences", Context.MODE_PRIVATE)

    fun getSharedPreferences(): SharedPreferences = sharedPref

    fun saveLoginState(userId: String) {
        sharedPref.edit {
            putString("logged_in_user_id", userId)
            putBoolean("is_logged_in", true)
            apply()
        }
    }

    fun clearLoginState() {
        sharedPref.edit {
            remove("logged_in_user_id")
            putBoolean("is_logged_in", false)
            apply()
        }
    }

    fun isUserLoggedIn(): Boolean =
        sharedPref.getBoolean("is_logged_in", false)

    fun getLoggedInUserId(): String? =
        sharedPref.getString("logged_in_user_id", null)

    // === Modified user-based data ===
    fun setFirstRunCompleted() {
        val userId = getLoggedInUserId() ?: return
        sharedPref.edit { putBoolean("${userId}_is_first_run", false) }
    }

    fun isFirstRun(): Boolean {
        val userId = getLoggedInUserId() ?: return true
        return sharedPref.getBoolean("${userId}_is_first_run", true)
    }

    fun saveFoodPreferences(selectedFoods: List<String>) {
        val userId = getLoggedInUserId() ?: return
        sharedPref.edit {
            putStringSet("${userId}_selected_foods", selectedFoods.toSet())
        }
    }

    fun getFoodPreferences(): List<String> {
        val userId = getLoggedInUserId() ?: return emptyList()
        return sharedPref.getStringSet("${userId}_selected_foods", emptySet())?.toList() ?: emptyList()
    }

    fun savePersona(persona: String) {
        val userId = getLoggedInUserId() ?: return
        sharedPref.edit {
            putString("${userId}_selected_persona", persona)
        }
    }

    fun getPersona(): String {
        val userId = getLoggedInUserId() ?: return ""
        return sharedPref.getString("${userId}_selected_persona", "") ?: ""
    }

    fun saveTimings(biggestMeal: String, sleepTime: String, wakeUpTime: String) {
        val userId = getLoggedInUserId() ?: return
        sharedPref.edit().apply {
            putString("${userId}_biggest_meal_time", biggestMeal)
            putString("${userId}_sleep_time", sleepTime)
            putString("${userId}_wake_up_time", wakeUpTime)
            apply()
        }
    }

    fun getBiggestMealTime(): String {
        val userId = getLoggedInUserId() ?: return "00:00"
        return sharedPref.getString("${userId}_biggest_meal_time", "00:00") ?: "00:00"
    }

    fun getSleepTime(): String {
        val userId = getLoggedInUserId() ?: return "00:00"
        return sharedPref.getString("${userId}_sleep_time", "00:00") ?: "00:00"
    }

    fun getWakeUpTime(): String {
        val userId = getLoggedInUserId() ?: return "00:00"
        return sharedPref.getString("${userId}_wake_up_time", "00:00") ?: "00:00"
    }
}