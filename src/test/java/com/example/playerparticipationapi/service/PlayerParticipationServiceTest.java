package com.example.playerparticipationapi.service;

import com.example.playerparticipationapi.model.ParticipationRequest;
import com.example.playerparticipationapi.model.ParticipationResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlayerParticipationServiceTest {

    private PlayerParticipationService playerParticipationService;

    @BeforeEach
    void setUp() {
        playerParticipationService = new PlayerParticipationService();
    }

    @Test
    void testGetTopPlayers() {
        ParticipationRequest request = new ParticipationRequest();
        request.setRequiredTopPlayers(2);
        request.setParticipatedPlayers(Arrays.asList(
                Arrays.asList("Sharon", "Shalom", "Sharon", "Ronaldo"),
                Arrays.asList("Sharon", "Shalom", "Myke", "Ronaldo"),
                Arrays.asList("Yechiel", "Sivan", "Messi", "Ronaldo"),
                Arrays.asList("Yechiel", "Assaf", "Shalom", "Ronaldo")
        ));

        ParticipationResponse response = playerParticipationService.getTopPlayers(request);

        List<String> expectedTopPlayers = Arrays.asList("Ronaldo", "Shalom");
        assertEquals(expectedTopPlayers, response.getMostParticipatedPlayers());
    }

    @Test
    void testGetTopPlayersWithDuplicatesInSingleGame() {
        ParticipationRequest request = new ParticipationRequest();
        request.setRequiredTopPlayers(3);
        request.setParticipatedPlayers(Arrays.asList(
            Arrays.asList("Sharon", "Barak", "Sharon", "Ronaldo"),
            Arrays.asList("Sharon", "Barak", "Myke", "Ronaldo"),
            Arrays.asList("Yechiel", "Sivan", "Messi", "Ronaldo")
        ));

        ParticipationResponse response = playerParticipationService.getTopPlayers(request);

        List<String> expectedTopPlayers = Arrays.asList("Ronaldo", "Sharon", "Barak");
        assertEquals(expectedTopPlayers.size(), response.getMostParticipatedPlayers().size());
        assertTrue(response.getMostParticipatedPlayers().containsAll(expectedTopPlayers));
    }
}