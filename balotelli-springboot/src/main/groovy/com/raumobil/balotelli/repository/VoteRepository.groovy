package com.raumobil.balotelli.repository

import com.raumobil.balotelli.model.Vote
import org.springframework.data.jpa.repository.JpaRepository

interface VoteRepository extends JpaRepository<Vote, Long> {
    List<Vote> findByEmail(String email)
}
