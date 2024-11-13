package com.raumobil.balotelli.controller

import com.raumobil.balotelli.service.VoteService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/vote")
class VoteController {
    private final VoteService voteService

    VoteController(VoteService voteService) {
        this.voteService = voteService
    }

    @PostMapping
    ResponseEntity<?> castVote(@RequestBody Map<String, String> request) {
        String email = request.get("email")
        String voteOption = request.get("voteOption")
        try {
            voteService.castVote(email, voteOption)
            return ResponseEntity.ok("Vote cast successfully")
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage())
        }
    }
}
