package io.hardplant.baseball.service.impl;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

public class BaseballGameTest {
	
	@Test
	public void testPlayerStart() {
		BaseballGame game = new BaseballGame(2);

		String playerANumber = "123";
		game.setPlayerNumber(0, playerANumber);
		
		assertEquals(game.getPlayerNumber(0), playerANumber);
		
		String playerBNumber = "456";
		game.setPlayerNumber(1, playerBNumber);
		
		assertEquals(game.getPlayerNumber(1), playerBNumber);
	}
	
	@Test
	public void guessNoBallNoStrike() {
		String guess = "123";
		String answer = "456";
		
		BaseballGame game = new BaseballGame(1);
		
		game.setPlayerNumber(0, answer);
		
		HashMap<String, Integer> result = game.guess(0, guess);
		
		assertEquals(result.get("strike"), new Integer(0));
		assertEquals(result.get("ball"), new Integer(0));
	}
	
	@Test
	public void guess1BallNoStrike() {
		String guess = "123";
		String answer = "516";
		
		BaseballGame game = new BaseballGame(1);
		
		game.setPlayerNumber(0, answer);
		
		HashMap<String, Integer> result = game.guess(0, guess);
		
		assertEquals(result.get("strike"), new Integer(0));
		assertEquals(result.get("ball"), new Integer(1));
	}
	
	@Test
	public void guessNoBall1Strike() {
		String guess = "123";
		String answer = "156";
		
		BaseballGame game = new BaseballGame(1);
		
		game.setPlayerNumber(0, answer);
		
		HashMap<String, Integer> result = game.guess(0, guess);
		
		assertEquals(result.get("strike"), new Integer(1));
		assertEquals(result.get("ball"), new Integer(0));
	}
	
	@Test
	public void guess1Ball1Strike() {
		String guess = "123";
		String answer = "162";

		BaseballGame game = new BaseballGame(1);
		
		game.setPlayerNumber(0, answer);
		
		HashMap<String, Integer> result = game.guess(0, guess);
		
		assertEquals(result.get("strike"), new Integer(1));
		assertEquals(result.get("ball"), new Integer(1));
	}

	@Test
	public void guess0Ball3Strike() {
		String guess = "123";
		String answer = "123";

		BaseballGame game = new BaseballGame(1);
		
		game.setPlayerNumber(0, answer);
		
		HashMap<String, Integer> result = game.guess(0, guess);
		
		assertEquals(result.get("strike"), new Integer(3));
		assertEquals(result.get("ball"), new Integer(0));
	}
}
