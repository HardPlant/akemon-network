package io.hardplant.matchmaker.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class ELORatingTest {
	
	public class SampleKFactor implements KFactor {

		@Override
		public double getKFactor() {
			return 15;
		}
		
	}
	
	@Test
	public void test() {
		int A = 800;
		int B = 800;
		
		ELORating elo = new ELORating(new SampleKFactor());
		
		// A Wins B
		
		int tempA = A;
		int tempB = B;
		
		A = elo.getWinningRate(tempA, tempB);
		B = elo.getLosingRate(tempA, tempB);
		
		assertNotEquals(tempA, A);
		assertNotEquals(tempB, B);
		
		assertTrue(A > B);
	}

}
