package com.fit2081.irene33624658.dao

import androidx.room.*
import com.fit2081.irene33624658.models.NutriCoachTip
import kotlinx.coroutines.flow.Flow

@Dao
interface NutriCoachTipDao {

    @Insert
    suspend fun insertTip(tip: NutriCoachTip)

    @Query("SELECT * FROM nutri_coach_tips WHERE userId = :userId ORDER BY createdAt DESC")
    fun getTipsForUser(userId: String): Flow<List<NutriCoachTip>>

    @Query("DELETE FROM nutri_coach_tips WHERE userId = :userId")
    suspend fun deleteAllTipsForUser(userId: String)
}
