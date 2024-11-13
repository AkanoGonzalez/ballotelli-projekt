package com.raumobil.balotelli.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.JdbcUserDetailsManager
import org.springframework.security.web.SecurityFilterChain

import javax.sql.DataSource

@Configuration
class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .requestMatchers("/register", "/login", "/css/**", "/js/**").permitAll() // Erlaubte URLs                .anyRequest().authenticated() // Authentifizierung für alle anderen URLs
                .and()
                .formLogin()
                .loginPage("/login") // Benutzerdefinierte Login-Seite
                .defaultSuccessUrl("/home", true) // Nach dem Login weiterleiten
                .failureUrl("/login?error=true") // Bei Fehler zurück zur Login-Seite
                .permitAll()
                .and()
                .logout()
                .permitAll()

        return http.build()
    }

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder()
    }

    @Bean
    JdbcUserDetailsManager userDetailsService(DataSource dataSource) {
        def manager = new JdbcUserDetailsManager(dataSource)
        manager.setUsersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username = ?")
        manager.setAuthoritiesByUsernameQuery("SELECT username, authority FROM authorities WHERE username = ?")
        return manager
    }

    @Bean
    AuthenticationManager authenticationManager(HttpSecurity http, PasswordEncoder passwordEncoder, JdbcUserDetailsManager userDetailsService) throws Exception {
        AuthenticationManagerBuilder auth = http.getSharedObject(AuthenticationManagerBuilder)
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder)
        return auth.build()
    }
}