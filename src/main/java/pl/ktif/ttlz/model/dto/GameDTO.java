package pl.ktif.ttlz.model.dto;


public class GameDTO {

	private String teamA;
	private String teamB;
	private byte scoreA;
	private byte scoreB;
	private String startTime;
	
	public String getTeamA() {
		return teamA;
	}
	public void setTeamA(String teamA) {
		this.teamA = teamA;
	}
	public String getTeamB() {
		return teamB;
	}
	public void setTeamB(String teamB) {
		this.teamB = teamB;
	}
	public byte getScoreA() {
		return scoreA;
	}
	public void setScoreA(byte scoreA) {
		this.scoreA = scoreA;
	}
	public byte getScoreB() {
		return scoreB;
	}
	public void setScoreB(byte scoreB) {
		this.scoreB = scoreB;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
}
