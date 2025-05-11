
package com.fit2081.irene33624658.repositories
import com.fit2081.irene33624658.dao.PatientDao
import com.fit2081.irene33624658.models.MotivationalMessage
import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.Date

class GeminiRepository(private val patientDao: PatientDao) {
    private val generativeModel = GenerativeModel(
        modelName = "gemini-pro",
        apiKey = "YOUR_API_KEY" // Replace with your actual API key
    )

    suspend fun generateMotivationalMessage(userId: String): String {
        return withContext(Dispatchers.IO) {
            try {
                val prompt = "Generate a short motivational message about healthy eating and nutrition, keep it under 50 words."
                val response = generativeModel.generateContent(prompt)
                val message = response.text ?: "Stay motivated on your healthy eating journey!"

                // Save to database
                patientDao.insertMotivationalMessage(
                    MotivationalMessage(
                        userId = userId,
                        message = message
                    )
                )

                message
            } catch (e: Exception) {
                "Error generating message: ${e.message}"
            }
        }
    }
}