package com.raumobil.balotelli.enums

enum Restaurant {
    PAVAROTTI(true),
    BORSALINO(false),
    GUTSCHEIN_DOENER(true)

    boolean abholungMöglich

    Restaurant (boolean abholungMöglich) {
        this.abholungMöglich = abholungMöglich
    }

}