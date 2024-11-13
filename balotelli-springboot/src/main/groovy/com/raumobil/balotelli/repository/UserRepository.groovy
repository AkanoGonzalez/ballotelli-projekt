package com.raumobil.balotelli.repository

import com.raumobil.balotelli.model.Users
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByEmail(String email)
}
