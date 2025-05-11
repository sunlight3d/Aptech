package com.fit2081.irene33624658.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "motivational_messages")
data class MotivationalMessage(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val userId: String,
    val message: String,
    val createdAt: Date = Date()
)