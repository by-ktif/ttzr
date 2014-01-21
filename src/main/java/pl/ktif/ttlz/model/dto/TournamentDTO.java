package pl.ktif.ttlz.model.dto;

import java.util.List;

public class TournamentDTO {

	private String name;
	private List<BetGameDTO> betGames;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<BetGameDTO> getBetGames() {
		return betGames;
	}
	public void setBetGames(List<BetGameDTO> betGames) {
		this.betGames = betGames;
	}
	
}
