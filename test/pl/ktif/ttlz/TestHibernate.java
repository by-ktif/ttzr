package pl.ktif.ttlz;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pl.ktif.ttlz.model.Game;
import pl.ktif.ttlz.model.Tournament;
import pl.ktif.ttlz.utils.HibernateUtils;

public class TestHibernate {
	public static void main(String[] args) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		//TestHibernate th = new TestHibernate();
		List<Tournament> leaguesList = session.createQuery("from Tournament").list();
		for (Tournament league : leaguesList) {
			System.out.println(league.getName());
		}
		
		List<Game> games = session.createQuery("from Game").list();
		for (Game game : games) {
			System.out.println(game.getTournament().getName() + ", " + game.getStartTime() + ": " + game.getTeamA().getName() + " - " + game.getTeamB().getName() + " (" + game.getScoreA()+":"+game.getScoreB()+")");
		}
		
		transaction.commit();
	}

}
