package pl.ktif.ttlz.model;

import java.util.Date;

public class Game {
	private int id;
	private int tournamentId;
	private String espnId;
	private String descripton;
	private Team teamA;
	private Team teamB;
	private byte scoreA;
	private byte scoreB;
	private String location;
	private Date startTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTournamentId() {
		return tournamentId;
	}
	public void setTournamentId(int tournamentId) {
		this.tournamentId = tournamentId;
	}
	public String getEspnId() {
		return espnId;
	}
	public void setEspnId(String espnId) {
		this.espnId = espnId;
	}
	public String getDescripton() {
		return descripton;
	}
	public void setDescripton(String descripton) {
		this.descripton = descripton;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Team getTeamA() {
		return teamA;
	}
	public void setTeamA(Team teamA) {
		this.teamA = teamA;
	}
	public Team getTeamB() {
		return teamB;
	}
	public void setTeamB(Team teamB) {
		this.teamB = teamB;
	}
}
