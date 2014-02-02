package pl.ktif.ttlz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.ktif.ttlz.model.Bet;
import pl.ktif.ttlz.model.Game;
import pl.ktif.ttlz.model.Tournament;

@Repository
public interface BetDAO extends JpaRepository<Bet, Integer> {

	List<Bet> findByTournamentAndGame(Tournament tournament, Game game);

}
