package com.raumobil.balotelli.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id
    String email
    String password
    String displayName
}

