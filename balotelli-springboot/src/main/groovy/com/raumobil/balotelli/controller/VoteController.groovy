package com.raumobil.balotelli.controller

import com.raumobil.balotelli.model.Vote
import com.raumobil.balotelli.repository.VoteRepository
import com.raumobil.balotelli.service.WhitelistedUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/votes")
class VoteController {

    @Autowired
    WhitelistedUserService whitelistedUserService

    @Autowired
    VoteRepository voteRepository

    @PostMapping
    Vote addVote(@RequestBody Vote vote) {
        if (!whitelistedUserService.isWhitelisted(vote.respondentName)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "User is not authorized to vote")
        }
        return voteRepository.save(vote)
    }

    @GetMapping
    List<Vote> getVotes() {
        return voteRepository.findAll()
    }

    @DeleteMapping
    void deleteVotes() {
        voteRepository.deleteAll()
    }
}
