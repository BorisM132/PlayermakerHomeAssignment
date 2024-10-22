package com.example.playerparticipationapi.model;

import java.util.List;

public class ParticipationRequest {
    private int requiredTopPlayers;
    private List<List<String>> participatedPlayers;

    // Getters and setters
    public int getRequiredTopPlayers() {
        return requiredTopPlayers;
    }

    public void setRequiredTopPlayers(int requiredTopPlayers) {
        this.requiredTopPlayers = requiredTopPlayers;
    }

    public List<List<String>> getParticipatedPlayers() {
        return participatedPlayers;
    }

    public void setParticipatedPlayers(List<List<String>> participatedPlayers) {
        this.participatedPlayers = participatedPlayers;
    }
}