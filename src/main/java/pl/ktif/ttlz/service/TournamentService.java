package pl.ktif.ttlz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.ktif.ttlz.dao.TournamentDAO;
import pl.ktif.ttlz.model.Bet;
import pl.ktif.ttlz.model.Game;
import pl.ktif.ttlz.model.Tournament;
import pl.ktif.ttlz.model.dto.BetDTO;
import pl.ktif.ttlz.model.dto.BetGameDTO;
import pl.ktif.ttlz.model.dto.GameDTO;
import pl.ktif.ttlz.model.dto.TournamentDTO;

@Service
@Transactional
public class TournamentService {
	@Autowired
	TournamentDAO tournamentDao;
	
	public List<Tournament> getAllTournaments() {
		return tournamentDao.findAll();
	}

	public Tournament getTournament(int id) {
		return tournamentDao.findById(id);
	}

	public TournamentDTO getTournamentDTO(int id) {
		return toDTO(getTournament(id));
	}
	
	private TournamentDTO toDTO(Tournament tournament) {
		TournamentDTO dto = new TournamentDTO();
		dto.setName(tournament.getName());
		List<BetGameDTO> betGames = new ArrayList<BetGameDTO>();
		for (Game game : tournament.getLeague().getGames()) {
			betGames.add(toBetGameDTO(game));
		}
		dto.setBetGames(betGames);
		return dto;
	}

	private BetGameDTO toBetGameDTO(Game game) {
		BetGameDTO dto = new BetGameDTO();
		dto.setGame(toGameDTO(game));
		List<BetDTO> bets = new ArrayList<BetDTO>();
		for (Bet bet : game.getBets()) {
			bets.add(toBetDTO(bet));
		}
		dto.setBets(bets);
		return dto;
	}

	private BetDTO toBetDTO(Bet bet) {
		BetDTO dto = new BetDTO();
		dto.setBetA(bet.getBetA());
		dto.setBetB(bet.getBetB());
		dto.setUserId(bet.getUser().getId());
		return dto;
	}

	private GameDTO toGameDTO(Game game) {
		GameDTO dto = new GameDTO();
		dto.setScoreA(game.getScoreA());
		dto.setScoreB(game.getScoreB());
		dto.setStartTime(game.getStartTime());
		dto.setTeamA(game.getTeamA().getName());
		dto.setTeamB(game.getTeamB().getName());
		return dto;
	}
}
