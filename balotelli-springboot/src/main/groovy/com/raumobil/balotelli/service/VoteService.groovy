package com.raumobil.balotelli.service

import com.raumobil.balotelli.model.Vote
import com.raumobil.balotelli.repository.VoteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class VoteService {
    @Autowired
    VoteRepository voteRepository

    void saveOrUpdateVote(Vote vote) {
        Vote existingVote = voteRepository.findByUserName(vote.username).orElse(null)

        if (existingVote) {
            existingVote.restaurant = vote.restaurant
        } else {
            existingVote = vote
        }

        voteRepository.save(existingVote)
    }

    List<Vote> getAllVotes() {
        return voteRepository.findAll()
    }

    void clearVotes() {
        voteRepository.deleteAll()
    }

    boolean isRespondentNameExists(String respondentName) {
        return voteRepository.existsByDisplayName(respondentName)
    }
}
