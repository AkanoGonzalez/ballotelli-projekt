package com.raumobil.balotelli.service

import com.raumobil.balotelli.model.Vote
import com.raumobil.balotelli.repository.VoteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class VoteService {
    @Autowired
    VoteRepository voteRepository

    void saveVote(Vote vote) {
        voteRepository.save(vote)
    }

    List<Vote> getAllVotes() {
        return voteRepository.findAll()
    }

    void clearVotes() {
        voteRepository.deleteAll()
    }
}
