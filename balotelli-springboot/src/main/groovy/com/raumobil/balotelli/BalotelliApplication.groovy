package com.raumobil.balotelli

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity

@SpringBootApplication
@EnableWebSecurity
class BalotelliApplication {
	static void main(String[] args) {
		SpringApplication.run(BalotelliApplication, args)
	}
}
