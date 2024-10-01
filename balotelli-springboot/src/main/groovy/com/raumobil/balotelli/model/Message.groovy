package com.raumobil.balotelli.model


import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id
    String content
}