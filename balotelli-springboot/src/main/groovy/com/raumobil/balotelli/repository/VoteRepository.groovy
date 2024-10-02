package com.raumobil.balotelli.repository

import com.raumobil.balotelli.model.Vote
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface VoteRepository extends JpaRepository<Vote, Long> {

    List<Vote> findByRestaurant(String restaurant)

    List<Vote> findByRespondentName(String respondentName)
}