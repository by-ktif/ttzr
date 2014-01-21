package pl.ktif.ttlz.model.dto;

import java.util.List;

public class BetGameDTO {

	private GameDTO game;
	private List<BetDTO> bets;
	
	public GameDTO getGame() {
		return game;
	}
	public void setGame(GameDTO game) {
		this.game = game;
	}
	public List<BetDTO> getBets() {
		return bets;
	}
	public void setBets(List<BetDTO> bets) {
		this.bets = bets;
	}
	
}
