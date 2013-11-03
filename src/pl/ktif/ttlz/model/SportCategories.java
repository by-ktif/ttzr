package pl.ktif.ttlz.model;

public enum SportCategories {
	FOOTBAL,
	HOCKEY;

	public static SportCategories byEspnCategory(String espnCat) {
		if ("hockey".equals(espnCat)) {
			return HOCKEY;
		}
		return FOOTBAL;
	}
	
	
}
