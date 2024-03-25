package com.atelier.tenisu.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.atelier.tenisu.exception.MethodArgumentException;
import com.atelier.tenisu.model.Player;
import com.atelier.tenisu.service.PlayerService;

@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    public PlayerController(PlayerService playerService){
        this.playerService = playerService;
    }

    /**
	 * Read - Get all players
	 * @return - An Iterable object of Player full filled
	 */
    @GetMapping("/players")
    public Iterable<Player> getPlayers() {
        return playerService.getPlayers();
    }

    /**
	 * Read - Get one player 
	 * @param id The id of the player
	 * @return An Player object full filled
	 */
	@GetMapping("/player/{id}")
	public ResponseEntity<Optional<Player>> getPlayer(@PathVariable("id") int id) {
		try {
        	Optional<Player> player = playerService.getPlayer(id);
        	return ResponseEntity.ok(player);
    	} catch (NumberFormatException ex) {
        	throw new MethodArgumentException("Invalid player ID format");
    	}
	}


    /**
	 * Read - Get all players sorted by rank
	 * @return - An Iterable object of Player full filled
	 */
    @GetMapping("/playersByRank")
    public Iterable<Player> getPlayerByRank() {
        return playerService.getPlayerByRank();
    }

	/**
	 * Read - Get country with higher wins ratio
	 * @return - An String country code
	 */
    @GetMapping("/BestCountry")
	public String getCountryWithHigherRatio() {
		Iterable<Player> players = playerService.getPlayers();
		return playerService.getCountryWithHighestRatio(players);
	}

	/**
	 * Read - Get imc for each player
	 * @return - An  Map object
	 */
    @GetMapping("/imcPlayers")
	public Map<String, Float> getImc() {
		Iterable<Player> players = playerService.getPlayers();
		return playerService.getIMC(players);
	}

	/**
	 * Read - Get imc average
	 * @return - A float value
	 */
    @GetMapping("/imcAverage")
	public float getAverageImc() {
		Iterable<Player> players = playerService.getPlayers();
		return playerService.getAverageIMC(players);
	}

	/**
	 * Read - Get median height
	 * @return - A float value
	 */
    @GetMapping("/median")
	public float getMedianHeight() {
		Iterable<Player> players = playerService.getPlayers();
		return playerService.getMedianHeight(players);
	}

}
