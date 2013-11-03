package pl.ktif.ttlz.utils;

import java.io.IOException;
import java.net.URL;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Deprecated
public class EspnParser {
	public static void main(String[] args) throws JsonParseException, IOException {
		ObjectMapper om = new ObjectMapper();
		URL url = new URL("http://api.espn.com/v1/sports/hockey/nhl/events?apikey=97k9afar2zg92nc4tt233sww");
		//File url = new File("/home/alexey/temp.json");
		JsonNode root = om.readValue(url.openStream(), JsonNode.class);
	
		//System.out.println(root.get("sports").get(0).get("leagues").get(0).get("uid"));
		JsonNode events = root.get("sports").get(0).get("leagues").get(0).get("events");
		for (int j=0; j<events.size(); j++) {
			JsonNode game = events.get(j).get("competitions").get(0);
			String date = game.get("date").asText();
			JsonNode compets = game.get("competitors");
			String home = compets.get(0).get("team").get("nickname").asText();
			String away = compets.get(1).get("team").get("nickname").asText();
			String homeScore = compets.get(0).get("score").asText();
			String awayScore = compets.get(1).get("score").asText();
			System.out.println(date + " - " + home + " vs " + away + "   ==   " + homeScore + ":" + awayScore);
		}
	}
}
