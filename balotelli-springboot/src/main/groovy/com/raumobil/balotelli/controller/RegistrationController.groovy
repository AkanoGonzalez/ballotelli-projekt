package com.raumobil.balotelli.controller

import com.raumobil.balotelli.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/register")
class RegistrationController {
    private final UserService userService

    RegistrationController(UserService userService) {
        this.userService = userService
    }

    @PostMapping
    ResponseEntity<?> registerUser(@RequestBody Map<String, String> request) {
        String email = request.get("email")
        String password = request.get("password")
        String displayName = request.get("displayName")
        try {
            userService.registerUser(email, password, displayName)
            return ResponseEntity.ok("User registered successfully")
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage())
        }
    }

    @GetMapping("/register")
    String showRegistrationForm() {
        return "register"  // Dies zeigt die Datei register.html im templates-Ordner an
    }
}
