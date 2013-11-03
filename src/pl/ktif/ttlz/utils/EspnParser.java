package pl.ktif.ttlz.utils;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

import pl.ktif.ttlz.model.Game;
import pl.ktif.ttlz.model.SportCategories;
import pl.ktif.ttlz.model.Team;
import pl.ktif.ttlz.model.Tournament;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EspnParser {
	public static void main(String[] args) throws JsonParseException, IOException {
		new EspnParser().parse();
	}
	
	public void parse() {
		ObjectMapper om = new ObjectMapper();
		//URL url = new URL("http://api.espn.com/v1/sports/hockey/nhl/events?apikey=97k9afar2zg92nc4tt233sww");
		File url = new File("/home/alexey/temp.json");
		JsonNode root = om.readValue(url/*.openStream()*/, JsonNode.class);
	
		//System.out.println(root.get("sports").get(0).get("leagues").get(0).get("uid"));
		
		JsonNode sport = root.get("sports").get(0);
		JsonNode league = sport.get("leagues").get(0);
		Tournament t = new Tournament();
		t.setName(league.get("shortName").textValue());
		t.setEspnId(league.get("uid").textValue());
		t.setSportCategory(SportCategories.byEspnCategory(sport.get("name").asText()));
		
		JsonNode events = league.get("events");
		for (int j=0; j<events.size(); j++) {
			JsonNode gameNode = events.get(j).get("competitions").get(0);
			JsonNode compets = gameNode.get("competitors");
			Game game = new Game();
			String date = gameNode.get("date").asText();
			game.setStartTime(Date.valueOf(date));
			game.setTeamA(getTeam(compets, 0));
			game.setTeamB(getTeam(compets, 1));
			String homeScore = compets.get(0).get("score").asText();
			String awayScore = compets.get(1).get("score").asText();
		}
	}

	private void getTeam(JsonNode compets, int i) {
		JsonNode homeTeamNode = compets.get(i).get("team");
		String homeTeamEspnId = homeTeamNode.get("uid").textValue();
		Team team;
		if ((team = gameDao.findByEspnId(homeTeamEspnId)) == null) {
			String homeTeamName = homeTeamNode.get("name") != null ? homeTeamNode.get("name").asText() : homeTeamNode.get("nickname").asText();
			team = gameDao.create(new Team(homeTeamEspnId, homeTeamName));
		}
		return team;
	}
}
