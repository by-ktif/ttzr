package pl.ktif.ttlz.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.ktif.ttlz.dao.TournamentDAO;
import pl.ktif.ttlz.model.Bet;
import pl.ktif.ttlz.model.Game;
import pl.ktif.ttlz.model.Tournament;

@Service
@Transactional
public class TournamentService {
	@Autowired
	TournamentDAO tournamentDao;
	
	public List<Tournament> getAllTournaments() {
		return tournamentDao.findAll();
	}

	public String getAllTournamentsJson() {
		List<Tournament> all = getAllTournaments();
		String res = "";
		Tournament tour = all.get(0);
		for (Bet bet : tour.getBets()) {
			Game game = bet.getGame();
			String team1 = game.getTeamA().getName();
			String team2 = game.getTeamB().getName();
			Date d = game.getStartTime();
			byte score1 = game.getScoreA();
			byte score2 = game.getScoreB();
			String user = bet.getUser().getName();
			byte bet1 = bet.getBetA();
			byte bet2 = bet.getBetB();
			res += String.format("%s (%d:%d): %s %s - %s (%d:%d)\n", user, bet1, bet2, d.toString(), team1, team2, score1, score2);
		}
		return res;
	}
}
