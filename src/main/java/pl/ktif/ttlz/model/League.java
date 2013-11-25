package pl.ktif.ttlz.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "z_leagues")
public class League {
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="league_id")
	private List<Game> games;
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="league_id")
	private List<Tournament> tournaments;
	
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

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	public List<Tournament> getTournaments() {
		return tournaments;
	}

	public void setTournaments(List<Tournament> tournaments) {
		this.tournaments = tournaments;
	}

}
