package com.fit2081.irene33624658.dao
import androidx.room.*
import com.fit2081.irene33624658.models.FoodIntake
import com.fit2081.irene33624658.models.Patient
import kotlinx.coroutines.flow.Flow

@Dao
interface MessageDao {
    @Insert
    suspend fun insert(message: Message)

    @Query("SELECT * FROM messages ORDER BY timestamp DESC")
    fun getAllMessages(): Flow<List<Message>>
}