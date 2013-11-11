package pl.ktif.ttlz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "z_tournaments")
public class Tournament {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="league_id")
	private League league;

	@Column(name = "point_system_code")
	private byte pointSystem;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public League getLeague() {
		return league;
	}

	public void setLeague(League league) {
		this.league = league;
	}

	public byte getPointSystem() {
		return pointSystem;
	}

	public void setPointSystem(byte pointSystem) {
		this.pointSystem = pointSystem;
	}

}
