package pl.ktif.ttlz.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.ktif.ttlz.dao.BetDAO;
import pl.ktif.ttlz.dao.TournamentDAO;
import pl.ktif.ttlz.model.Bet;
import pl.ktif.ttlz.model.Game;
import pl.ktif.ttlz.model.Tournament;
import pl.ktif.ttlz.model.dto.BetDTO;
import pl.ktif.ttlz.model.dto.BetGameDTO;
import pl.ktif.ttlz.model.dto.GameDTO;
import pl.ktif.ttlz.model.dto.TournamentDTO;
import pl.ktif.ttlz.pointsystem.PointSystem;
import pl.ktif.ttlz.pointsystem.PointSystemFactory;

@Service
@Transactional
public class TournamentService {
	@Autowired
	private TournamentDAO tournamentDao;
	
	@Autowired
	private BetDAO betDAO;
	
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
			BetGameDTO betGameDTO = toBetGameDTO(game, tournament.getBets());
			if (game.getStartTime().before(new Date())) { //TODO: only after the game, so to add 2+ hours...
				calculateBetsGamePoints(betGameDTO, tournament.getPointSystem());
			}
			betGames.add(betGameDTO);//TODO: compare performance: betDAO.findByTournamentAndGame(tournament, game)));
		}
		dto.setBetGames(betGames);
		return dto;
	}

	private void calculateBetsGamePoints(BetGameDTO betGameDTO, byte systemId) {
		PointSystem pointSystem = PointSystemFactory.getPointSystem(systemId);
		GameDTO game = betGameDTO.getGame();
		for (BetDTO bet : betGameDTO.getBets()) {
			byte score = pointSystem.calculateGamePoints(game.getScoreA(), game.getScoreB(), bet.getBetA(), bet.getBetB());
			bet.setScore(score);
		}
	}

	private BetGameDTO toBetGameDTO(Game game, List<Bet> bets) {
		BetGameDTO dto = new BetGameDTO();
		dto.setGame(toGameDTO(game));
		List<BetDTO> betDTOs = new ArrayList<BetDTO>();
		for (Bet bet : bets) {
			if (bet.getGame().equals(game)) {
				betDTOs.add(toBetDTO(bet));
			}
		}
		dto.setBets(betDTOs);
		return dto;
	}

	private BetDTO toBetDTO(Bet bet) {
		BetDTO dto = new BetDTO();
		dto.setBetId(bet.getId());
		dto.setBetA(bet.getBetA());
		dto.setBetB(bet.getBetB());
		dto.setUserId(bet.getUser().getId());
		return dto;
	}

	private GameDTO toGameDTO(Game game) {
		GameDTO dto = new GameDTO();
		dto.setScoreA(game.getScoreA());
		dto.setScoreB(game.getScoreB());
		dto.setStartTime(new SimpleDateFormat("dd.MM.yyyy HH:mm").format(game.getStartTime()));
		dto.setTeamA(game.getTeamA().getName());
		dto.setTeamB(game.getTeamB().getName());
		return dto;
	}
}
