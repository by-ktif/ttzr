package pl.ktif.ttlz;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pl.ktif.ttlz.model.Bet;
import pl.ktif.ttlz.model.Game;
import pl.ktif.ttlz.utils.HibernateUtils;

public class TestHibernate {
	public static void main(String[] args) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		List<Game> games = session.createQuery("from Game").list();
		for (Game game : games) {
			System.out.println(game.getLeague().getName() + ", " + game.getStartTime() + ": " + game.getTeamA().getName() + " - " + game.getTeamB().getName() + " (" + game.getScoreA()+":"+game.getScoreB()+")");
			List<Bet> bets = session.createQuery("from Bet b where b.game.id = " + game.getId()).list();
			for (Bet bet : bets) {
				System.out.println("\t" + bet.getUser().getName() + ": " + bet.getBetA() + ":" + bet.getBetB()); 
			}
		}
		
		transaction.commit();
	}

}
