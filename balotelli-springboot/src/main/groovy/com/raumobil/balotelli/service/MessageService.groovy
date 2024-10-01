package com.raumobil.balotelli.service

import com.raumobil.balotelli.model.Message
import com.raumobil.balotelli.repository.MessageRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MessageService {

    @Autowired
    MessageRepository messageRepository

    List<Message> getAllMessages() {
        messageRepository.findAll()
    }

    void saveMessage(Message message) {
        messageRepository.save(message)
    }
}
