package com.raumobil.balotelli.model

import jakarta.persistence.*

@Entity
@Table(name = "votes")
class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id

    String respondentName

    String restaurant
}
