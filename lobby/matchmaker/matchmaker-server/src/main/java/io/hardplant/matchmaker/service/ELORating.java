package io.hardplant.matchmaker.service;

public class ELORating {

	KFactor kFactor;
	
	public ELORating(KFactor kFactor) {
		this.kFactor = kFactor;
	}

	public int getWinningRate(int A, int B) {
		double winningChance = 1 / (1 + Math.pow(10, (B - A) / 400.0));
		
		double rate = A + kFactor.getKFactor() * (1 - winningChance);
		
		return (int) Math.floor(rate);
	}
	
	public int getLosingRate(int A, int B) {
		double winningChance = 1 / (1 + Math.pow(10, (B - A) / 400.0));
		
		double rate = A + kFactor.getKFactor() * (0 - winningChance);
		
		return (int) Math.floor(rate);
	}
}
