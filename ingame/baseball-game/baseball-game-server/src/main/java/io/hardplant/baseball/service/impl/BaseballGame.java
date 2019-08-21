package io.hardplant.baseball.service.impl;

import java.lang.reflect.Array;
import java.util.HashMap;

public class BaseballGame {

	String[] playerToken;
	
	String[] playerNumber;
	
	int currentPlayerTurnIndex;
	
	boolean isEnded = false;
	
	public BaseballGame(int length) {
		playerToken = new String[length];
		playerNumber = new String[length];
	}

	public void setPlayerNumber(int playerIndex,String playerNumber) {
		assert(playerIndex < playerToken.length);
		
		this.playerNumber[playerIndex] = playerNumber;
	}
	
	public int getPlayerIndex(String token) {
		for (int i = 0; i < playerToken.length; i++) {
			if (playerToken[i].equals(token)) {
				return i;
			}
		}
		return -1;
	}
	
	public String getGuessTargetToken(String token) {
		return playerToken[(this.getPlayerIndex(token) + 1) % playerToken.length];
	}
	
	public HashMap<String, Integer> guess(int index, String guess) {
		int guessIndex = index % playerToken.length;
		
		String answer = playerNumber[guessIndex];
		
		int ball = getBall(answer, guess);
		int strike = getStrike(answer, guess);
		
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		
		result.put("ball", ball);
		result.put("strike", strike);
		
		if (strike == guess.length()) {
			this.isEnded = true;
		}
		
		return result;
	}
	
	private int getBall(String answerStr, String guessStr) {
		
		char[] answer = answerStr.toCharArray();
		char[] guess = guessStr.toCharArray();
		int ball = 0;	

		for (int i = 0; i < answer.length; i++) {
			for (int j = 0; j < guess.length; j++) {
				if (i == j) continue;

				if (answer[i] == guess[j]) {
					ball++;
				}
			}
		}
		
		return ball;
	}
	
	private int getStrike(String answerStr, String guessStr) {
		
		char[] answer = answerStr.toCharArray();
		char[] guess = guessStr.toCharArray();
		int strike = 0;
		
		for (int i = 0; i < answer.length; i++) {
			
			if (answer[i] == guess[i]) {
				strike++;
			}
		}
		
		return strike;
	}

	public String[] getPlayerToken() {
		return playerToken;
	}


	public void setPlayerToken(String[] playerToken) {
		this.playerToken = playerToken;
	}

	public String getPlayerNumber(int i) {
		return playerNumber[i];
	}


}
