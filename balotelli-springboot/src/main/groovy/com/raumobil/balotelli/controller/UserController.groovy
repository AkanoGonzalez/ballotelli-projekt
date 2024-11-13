package com.raumobil.balotelli.controller

import org.springframework.security.core.userdetails.User
import org.springframework.security.provisioning.JdbcUserDetailsManager
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {

    private final JdbcUserDetailsManager userDetailsManager
    private final PasswordEncoder passwordEncoder

    UserController(JdbcUserDetailsManager userDetailsManager, PasswordEncoder passwordEncoder) {
        this.userDetailsManager = userDetailsManager
        this.passwordEncoder = passwordEncoder
    }

    @PostMapping("/register")
    def registerUser(@RequestBody Map user) {
        String encodedPassword = passwordEncoder.encode(user.password)
        def userDetails = User.builder()
                .username(user.username)
                .password(encodedPassword)
                .roles("USER")
                .build()
        userDetailsManager.createUser(userDetails)
        return "User registered successfully"
    }
}
