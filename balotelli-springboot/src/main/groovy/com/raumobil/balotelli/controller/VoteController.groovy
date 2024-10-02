package com.raumobil.balotelli.controller

import com.raumobil.balotelli.model.Vote
import com.raumobil.balotelli.repository.VoteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/votes")
class VoteController {

    @Autowired
    VoteRepository voteRepository

    @PostMapping
    Vote addVote(@RequestBody Vote vote) {
        return voteRepository.save(vote)
    }

    @GetMapping
    List<Vote> getAllVotes() {
        return voteRepository.findAll()
    }

    @GetMapping("/{restaurant}")
    List<Vote> getVotesByRestaurant(@PathVariable String restaurant) {
        return voteRepository.findByRestaurant(restaurant)
    }

    @DeleteMapping
    void deleteAllVotes() {
        voteRepository.deleteAll()
    }
}
