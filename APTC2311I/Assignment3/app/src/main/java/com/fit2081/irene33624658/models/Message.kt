package com.fit2081.irene33624658.models

import androidx.room.Entity
import androidx.room.PrimaryKey

// Entity
@Entity(tableName = "messages")
data class Message(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val content: String,
    val timestamp: Long
)