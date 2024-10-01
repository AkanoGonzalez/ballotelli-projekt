package com.raumobil.balotelli.controller

import com.raumobil.balotelli.model.Message
import com.raumobil.balotelli.service.MessageService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class MessageController {

    @Autowired
    MessageService messageService

    @GetMapping("/message")
    String showMessagePage(Model model) {
        model.addAttribute("newMessage", new Message())
        model.addAttribute("messages", messageService.getAllMessages())
        return "message"
    }

    @PostMapping("/message")
    String submitMessage(Message message) {
        messageService.saveMessage(message)
        return "redirect:/message"
    }
}
