package com.example.playerparticipationapi.service;

import com.example.playerparticipationapi.model.ParticipationRequest;
import com.example.playerparticipationapi.model.ParticipationResponse;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PlayerParticipationService {

    public ParticipationResponse getTopPlayers(ParticipationRequest request) {
        Map<String, Integer> playerParticipationCount = new HashMap<>();

        for (List<String> game : request.getParticipatedPlayers()) {
            Set<String> uniquePlayers = new HashSet<>(game);
            for (String player : uniquePlayers) {
                playerParticipationCount.put(player, playerParticipationCount.getOrDefault(player, 0) + 1);
            }
        }

        List<String> topPlayers = playerParticipationCount
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(request.getRequiredTopPlayers())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return new ParticipationResponse(topPlayers);
    }
}