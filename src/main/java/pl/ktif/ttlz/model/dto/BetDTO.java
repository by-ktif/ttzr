package pl.ktif.ttlz.model.dto;

public class BetDTO {

	private int id;
	private int userId;
	private byte betA;
	private byte betB;
	private byte score;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public int getId() {
		return id;
	}
	public void setBetId(int id) {
		this.id = id;
	}
	public byte getScore() {
		return score;
	}
	public void setScore(byte score) {
		this.score = score;
	}
}
