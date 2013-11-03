package pl.ktif.ttlz.model;

public class Tournament {
	private int id;
	private String name;
	private String espnId;
	private String descripton;
	private SportCategories sportCategory;
	
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
	public SportCategories getSportCategory() {
		return sportCategory;
	}
	public void setSportCategory(SportCategories sportCategory) {
		this.sportCategory = sportCategory;
	}

}
