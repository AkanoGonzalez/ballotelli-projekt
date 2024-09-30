package com.raumobil.balotelli.MessagingController

import com.raumobil.balotelli.model.Message
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class MessageController {

    private List<Message> messages = []

    @GetMapping("/message")
    String showMessagePage(Model model) {
        model.addAttribute("newMessage", new Message())
        model.addAttribute("messages", messages)
        return "message"
    }

    @PostMapping("/message")
    String submitMessage(Message message) {
        messages.add(message)
        return "redirect:/message"
    }
}