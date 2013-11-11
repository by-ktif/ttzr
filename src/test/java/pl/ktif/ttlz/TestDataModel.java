package pl.ktif.ttlz;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import pl.ktif.ttlz.model.Bet;
import pl.ktif.ttlz.model.Game;
import pl.ktif.ttlz.utils.HibernateUtils;
import junit.framework.TestCase;
	
public class TestDataModel extends TestCase {
	
	@SuppressWarnings("unchecked")
	@Test
	public void testHibernate() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Query createQuery = session.createQuery("from Game");
		List<Game> games = createQuery.list();
		for (Game game : games) {
			System.out.println(game.getLeague().getName() + ", " + game.getStartTime() + ": " + game.getTeamA().getName() + " - " + game.getTeamB().getName() + " (" + game.getScoreA()+":"+game.getScoreB()+")");
			List<Bet> bets = session.createQuery("from Bet b where b.game.id = " + game.getId()).list();
			for (Bet bet : bets) {
				System.out.println("\t" + bet.getUser().getName() + ": " + bet.getBetA() + ":" + bet.getBetB()); 
			}
		}
		
		transaction.commit();
		
		assertTrue(true);
	}
	
}
