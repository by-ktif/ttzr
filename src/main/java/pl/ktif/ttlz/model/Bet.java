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
@Table(name = "z_bets")
public class Bet {
	
	@Id
	@GeneratedValue
	private int id;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="game_id")
	private Game game;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tournament_id")
	private Tournament tournament;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(name = "betA")
	private byte betA;

	@Column(name = "betB")
	private byte betB;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public byte getBetA() {
		return betA;
	}

	public void setBetA(byte betA) {
		this.betA = betA;
	}

	public byte getBetB() {
		return betB;
	}

	public void setBetB(byte betB) {
		this.betB = betB;
	}
	
}
