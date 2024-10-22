package com.example.playerparticipationapi.controller;

import com.example.playerparticipationapi.model.ParticipationRequest;
import com.example.playerparticipationapi.model.ParticipationResponse;
import com.example.playerparticipationapi.service.PlayerParticipationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/player-participation")
public class PlayerParticipationController {

    private final PlayerParticipationService playerParticipationService;

    @Autowired
    public PlayerParticipationController(PlayerParticipationService playerParticipationService) {
        this.playerParticipationService = playerParticipationService;
    }

    @PostMapping("/top-players")
    public ResponseEntity<ParticipationResponse> getTopPlayers(@RequestBody ParticipationRequest request) {
        ParticipationResponse response = playerParticipationService.getTopPlayers(request);
        return ResponseEntity.ok(response);
    }


}