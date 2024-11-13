package com.raumobil.balotelli.service

import com.raumobil.balotelli.model.Users
import com.raumobil.balotelli.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository

    @Autowired
    WhitelistedUserService whitelistedUserService

    @Override
    UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = userRepository.findByEmail(email)
                .orElseThrow { new UsernameNotFoundException("User not found with email: $email") }

        if (!whitelistService.isWhitelisted(email)) {
            throw new UsernameNotFoundException("User not authorized: $email")
        }

        return new org.springframework.security.core.userdetails.User(
                user.email,
                user.password,
                [new SimpleGrantedAuthority(user.role)]
        )
    }
}
