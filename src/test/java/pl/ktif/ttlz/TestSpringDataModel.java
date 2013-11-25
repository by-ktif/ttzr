package pl.ktif.ttlz;

import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pl.ktif.ttlz.dao.TournamentDAO;
import pl.ktif.ttlz.model.Tournament;
import pl.ktif.ttlz.service.TournamentService;
	
public class TestSpringDataModel extends TestCase {
	
	@Test
	public void testSpringDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-context/context.xml");
		Map<String, TournamentService> beansOfType = context.getBeansOfType(TournamentService.class);
		String json = ((TournamentService) beansOfType.get("tournamentService")).getAllTournamentsJson();
		System.out.println(json);
		assertTrue(true);
	}
	
}
