package pl.ktif.ttlz;

import java.util.Map;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pl.ktif.ttlz.service.TournamentService;

import com.google.gson.Gson;
	
public class TestSpringDataModel extends TestCase {
	
	@Test
	public void testSpringDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-context/context.xml");
		Map<String, TournamentService> beansOfType = context.getBeansOfType(TournamentService.class);
		String json = new Gson().toJson(((TournamentService) beansOfType.get("tournamentService")).getTournamentDTO(1));
		System.out.println(json);
		assertTrue(true);
	}
	
}
