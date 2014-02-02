package pl.ktif.ttlz.pointsystem;

public abstract class PointSystemFactory {

	//TODO: improve singleton
	private final static CopenhagenSystem copSystem = new CopenhagenSystem();
	private final static ReykjavikSystem rejSystem = new ReykjavikSystem();
	
	public static PointSystem getPointSystem(byte id) {
		switch (id) {
		case 1:
			return copSystem;
		default:
			return rejSystem;
		}
	}

}
