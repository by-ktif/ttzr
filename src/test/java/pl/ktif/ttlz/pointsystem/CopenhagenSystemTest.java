package pl.ktif.ttlz.pointsystem;

import static org.junit.Assert.*;

import org.junit.Test;

public class CopenhagenSystemTest {

	@Test
	public void testCopenhagenSystem() {
		CopenhagenSystem system = new CopenhagenSystem();
		assertEquals(8, system.calculateGamePoints((byte) 4, (byte) 2, (byte) 4, (byte) 2));
		assertEquals(3, system.calculateGamePoints((byte) 4, (byte) 2, (byte) 4, (byte) 1));
		assertEquals(0, system.calculateGamePoints((byte) 2, (byte) 2, (byte) 0, (byte) 0));
		assertEquals(-1, system.calculateGamePoints((byte) 1, (byte) 0, (byte) 1, (byte) 1));
		assertEquals(-8, system.calculateGamePoints((byte) 4, (byte) 2, (byte) 2, (byte) 4));
		assertEquals(-5, system.calculateGamePoints((byte) 4, (byte) 4, (byte) 2, (byte) 1));
		assertEquals(0, system.calculateGamePoints((byte) 7, (byte) 0, (byte) 4, (byte) 1));
		assertEquals(2, system.calculateGamePoints((byte) 1, (byte) 2, (byte) 0, (byte) 1));
	}

}
