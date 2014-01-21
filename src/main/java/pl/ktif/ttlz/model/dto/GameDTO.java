package pl.ktif.ttlz.model.dto;

import java.util.Date;

public class GameDTO {

	private String teamA;
	private String teamB;
	private byte scoreA;
	private byte scoreB;
	private Date startTime;
	
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
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
}
