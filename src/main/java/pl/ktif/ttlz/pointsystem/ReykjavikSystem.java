package pl.ktif.ttlz.pointsystem;

public class ReykjavikSystem implements PointSystem {

	public byte calculateGamePoints(byte actualA, byte actualB, byte betA, byte betB) {
		if (actualA == betA && actualB == betB) {
			return 4;
		}
		if (actualA - actualB == betA - betB) {
			return 2;
		}
		if (Integer.signum(actualA - actualB) == Integer.signum(betA - betB)) {
			return 1; 
		}
		return 0;
	}

}
