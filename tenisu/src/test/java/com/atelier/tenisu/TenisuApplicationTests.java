package com.atelier.tenisu;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.atelier.tenisu.model.Country;
import com.atelier.tenisu.model.Data;
import com.atelier.tenisu.model.Player;
import com.atelier.tenisu.repository.PlayerRepository;
import com.atelier.tenisu.service.PlayerService;

@SpringBootTest
@AutoConfigureMockMvc
class TenisuApplicationTests {

	@InjectMocks
	private PlayerService playerService;

	@Mock
    private PlayerRepository playerRepository;

	
	@Test
    public void testGetPlayers() {
        List<Player> players = new ArrayList<>();
        players.add(new Player());
        players.add(new Player());
        when(playerRepository.findAll()).thenReturn(players);
        Iterable<Player> result = playerService.getPlayers();
        assertEquals(players.size(), ((List<Player>) result).size());
    }

    @Test
    public void testGetPlayerById() {
        Player player = new Player();
        player.setId(1);
        player.setFirstname("Jean");
        when(playerRepository.findById(1)).thenReturn(Optional.of(player));

        Optional<Player> result = playerService.getPlayer(1);

        assertEquals(player, result.get());
    }

	@Test
    public void testGetPlayersByRank() {
        List<Player> players = new ArrayList<>();
        players.add(new Player());
        players.add(new Player());
        when(playerRepository.findAllByOrderByDataRankAsc()).thenReturn(players);

        Iterable<Player> result = playerService.getPlayerByRank();

        assertEquals(players.size(), ((List<Player>) result).size());
    }

	@Test
    public void testGetCountryWithHigherRatio() {
        List<Player> players = new ArrayList<>();
        Player player1 = new Player();
        player1.setCountry(new Country("US"));
        int[] last1 = {1, 1, 0, 1, 0};
        player1.setData(new Data(last1));
        Player player2 = new Player();
        player2.setCountry(new Country("FR"));
        int[] last2 = {1, 1, 1, 1, 1};
        player2.setData(new Data(last2));
        players.add(player1);
        players.add(player2);

        String result = playerService.getCountryWithHighestRatio(players);

        assertEquals("FR", result);
    }

    @Test
    public void testGetImc() {
        List<Player> players = new ArrayList<>();
        Player player1 = new Player();
        player1.setShortname("N.DJO");
        player1.setData(new Data(80000, 185));
        Player player2 = new Player();
        player2.setShortname("S.WIL");
        player2.setData(new Data(74000, 180));
        players.add(player1);
        players.add(player2);

        float imc1 = 23.37472f;
        float imc2 = 22.83950f;
		Map<String, Float> imcMap = playerService.getIMC(players);
		assertThat(imcMap.get("N.DJO")).isEqualTo(imc1);
		assertThat(imcMap.get("S.WIL")).isEqualTo(imc2);    
	}

    @Test
    public void testGetMedianHeight() {
        List<Player> players = new ArrayList<>();
        Player player1 = new Player();
        player1.setData(new Data(180));
        Player player2 = new Player();
        player2.setData(new Data(190));
        Player player3 = new Player();
        player3.setData(new Data(170));
        players.add(player1);
        players.add(player2);
        players.add(player3);

        float result = playerService.getMedianHeight(players);
        assertEquals(180, result);
	}
}

