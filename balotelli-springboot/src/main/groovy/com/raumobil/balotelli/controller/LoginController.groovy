package com.raumobil.balotelli.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.servlet.view.RedirectView

@Controller
class LoginController {

    @GetMapping("/signin")
    RedirectView Login() {
        return new RedirectView("/login") // Benutzer auf eine andere Seite leiten
    }
}
