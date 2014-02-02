package pl.ktif.ttlz.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "z_games")
public class Game {
	@Id
	@GeneratedValue
	private int id;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="league_id")
	private League league;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="teamA_id")
	private Team teamA;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="teamB_id")
	private Team teamB;

	@Column(name = "scoreA")
	private byte scoreA;

	@Column(name = "scoreB")
	private byte scoreB;

	@Column(name = "starttime")
	private Date startTime;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public League getLeague() {
		return league;
	}

	public void setLeague(League league) {
		this.league = league;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
