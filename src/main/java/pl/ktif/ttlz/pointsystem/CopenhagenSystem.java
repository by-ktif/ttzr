package pl.ktif.ttlz.pointsystem;

public class CopenhagenSystem implements PointSystem {

	public byte calculateGamePoints(byte actualA, byte actualB, byte betA, byte betB) {
		if (actualA == betA && actualB == betB) {
			return 8;
		}
		if (Integer.signum(actualA - actualB) == Integer.signum(betA - betB)) {
			return (byte) (4 - Math.abs(actualA - betA) - Math.abs(actualB - betB)); 
		}
		if (actualA == actualB || betA == betB) {
			return (byte) (0 - Math.abs(actualA - betA) - Math.abs(actualB - betB)); 
		}
		return (byte) (-4 - Math.abs(actualA - betA) - Math.abs(actualB - betB));
	}

}
