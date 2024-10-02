package com.raumobil.balotelli

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SpringRestController {

    @GetMapping("/connect")
    void connect(){
        System.out.println("Spring Boot Application Connected.")
    }

}