package pl.ktif.ttlz.pointsystem;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReykjavikSystemTest {

	@Test
	public void testReykjavikSystem() {
		ReykjavikSystem system = new ReykjavikSystem();
		assertEquals(4, system.calculateGamePoints((byte) 4, (byte) 2, (byte) 4, (byte) 2));
		assertEquals(1, system.calculateGamePoints((byte) 4, (byte) 2, (byte) 4, (byte) 1));
		assertEquals(2, system.calculateGamePoints((byte) 2, (byte) 2, (byte) 0, (byte) 0));
		assertEquals(0, system.calculateGamePoints((byte) 1, (byte) 0, (byte) 1, (byte) 1));
		assertEquals(0, system.calculateGamePoints((byte) 4, (byte) 2, (byte) 2, (byte) 4));
		assertEquals(0, system.calculateGamePoints((byte) 4, (byte) 4, (byte) 2, (byte) 1));
		assertEquals(1, system.calculateGamePoints((byte) 7, (byte) 0, (byte) 4, (byte) 1));
		assertEquals(2, system.calculateGamePoints((byte) 1, (byte) 2, (byte) 0, (byte) 1));
	}

}
