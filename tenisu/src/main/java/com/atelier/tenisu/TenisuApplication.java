package com.atelier.tenisu;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.atelier.tenisu.model.Player;
import com.atelier.tenisu.service.PlayerService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class TenisuApplication {

	public static void main(String[] args) {
		SpringApplication.run(TenisuApplication.class, args);
	}

	/**
	 * @param playerService
	 * @return
	 */
	@Bean
    CommandLineRunner runner(PlayerService playerService) {
        return args -> {
            // read json and write to db
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Player>> typeReference = new TypeReference<List<Player>>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/headtohead.json");
            try {
                List<Player> players = mapper.readValue(inputStream,typeReference);
                playerService.save(players);
                System.out.println("Players Saved!");
            } catch (IOException e){
                System.out.println("Unable to save players: " + e.getMessage());
            }
        };
	}

}
