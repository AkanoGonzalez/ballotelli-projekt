package com.raumobil.balotelli.service

import com.raumobil.balotelli.model.Users
import com.raumobil.balotelli.repository.UserRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService {
    private final UserRepository userRepository
    private final BCryptPasswordEncoder passwordEncoder

    UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository
        this.passwordEncoder = passwordEncoder
    }

    void registerUser(String email, String password, String displayName) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw new IllegalArgumentException("Email already in use")
        }
        Users user = new Users(email: email, password: passwordEncoder.encode(password), displayName: displayName)
        userRepository.save(user)
    }
}
