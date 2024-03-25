package com.atelier.tenisu.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atelier.tenisu.model.Player;
import com.atelier.tenisu.repository.PlayerRepository;


@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public Optional<Player> getPlayer(int id){
        
        return playerRepository.findById(id);
    }

    public Iterable<Player> getPlayers(){
        return playerRepository.findAll();
    }

    public Iterable<Player> getPlayerByRank() {
        return playerRepository.findAllByOrderByDataRankAsc();
    }

    public Player save(Player player){
        return playerRepository.save(player);
    }

    public void save(List<Player> players) {
        playerRepository.saveAll(players);
    }

    public String getCountryWithHighestRatio(Iterable <Player> players){
        String countryWithHighestRatio = "";
        float highestRatio = 0;
        float ratio = 0;

        for (Player player : players){
            int [] last = player.getData().getLast();
            int sumWins = 0;
            int sumMatch = last.length;
            for (int l : last){
                sumWins += l;
            }
            ratio = sumWins/sumMatch;
            if(ratio > highestRatio){
                highestRatio = ratio;
                countryWithHighestRatio = player.getCountry().getCode();
            }
            
        }
        return countryWithHighestRatio;
    }

    public Map<String, Float> getIMC(Iterable<Player> players) {
        Map<String,Float> imcPlayers = new HashMap<>();
        for (Player player : players ) {
            float playerWeight = player.getData().getWeight();
            float playerHeight = player.getData().getHeight();
            if(playerHeight != 0) {
                float imc = (playerWeight/(playerHeight*playerHeight)*10);
                imcPlayers.put(player.getShortname(),imc);
            }
        }
        return imcPlayers;
    }

    public float getAverageIMC(Iterable<Player> players) {
        float totalIMC = 0;
        float imc = 0;
        int totalPlayers =0;
        for (Player player : players ) {
            float playerWeight = player.getData().getWeight();
            float playerHeight = player.getData().getHeight();
            if(playerHeight != 0) {
                imc = (playerWeight/(playerHeight*playerHeight)*10);
                totalIMC += imc;
                totalPlayers += 1;
            }
        }
        return totalIMC/totalPlayers;
    }

    public float getMedianHeight(Iterable<Player> players) {
        List<Float> heights = new ArrayList();
        for(Player player : players) {
            heights.add((float) player.getData().getHeight());
        }
        Collections.sort(heights);
        int size = heights.size();
        if (size == 0) {
            return 0; 
        } else if (size % 2 == 0) {
            int indexInf = size / 2 - 1;
            int indexSup = size / 2;
            return (heights.get(indexInf) + heights.get(indexSup)) / 2;
        } else {
            return heights.get(size / 2);
        }
    }
}
