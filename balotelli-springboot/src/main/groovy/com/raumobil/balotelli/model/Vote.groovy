package com.raumobil.balotelli.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
class Vote {
    @Id
    @GeneratedValue
    Long id

    String respondentName
    String restaurant
}
