package com.example.playerparticipationapi.model;

import java.util.List;

public class ParticipationResponse {
    private List<String> mostParticipatedPlayers;

    public ParticipationResponse(List<String> mostParticipatedPlayers) {
        this.mostParticipatedPlayers = mostParticipatedPlayers;
    }

    public List<String> getMostParticipatedPlayers() {
        return mostParticipatedPlayers;
    }

    public void setMostParticipatedPlayers(List<String> mostParticipatedPlayers) {
        this.mostParticipatedPlayers = mostParticipatedPlayers;
    }
}