package com.raumobil.balotelli;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SpringRestController {

    @GetMapping("/connect")
    public void connect(){
        System.out.println("Spring Boot Application Connected.");
    }

}