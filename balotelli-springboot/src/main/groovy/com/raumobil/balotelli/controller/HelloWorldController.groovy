package com.raumobil.balotelli.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController {

    @GetMapping("/hallo")
    public String helloWorld() {
        return "hello World";
    }
}
