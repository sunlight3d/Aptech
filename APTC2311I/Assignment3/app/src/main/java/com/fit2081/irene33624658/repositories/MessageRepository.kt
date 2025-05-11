package com.fit2081.irene33624658.repositories

import com.fit2081.irene33624658.dao.MessageDao
import kotlinx.coroutines.flow.Flow

class MessageRepository(private val messageDao: MessageDao) {
    suspend fun insertMessage(message: Message) {
        messageDao.insert(message)
    }

    fun getAllMessages(): Flow<List<Message>> {
        return messageDao.getAllMessages()
    }
}