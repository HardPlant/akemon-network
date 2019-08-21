package io.hardplant.baseball.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import io.hardplant.baseball.service.BaseballService;

public class BaseballServiceImplTest {

	
	@Test
	public void testNewGame() {
		BaseballService baseballService = new BaseballServiceImpl();
		
		String[] playerToken = new String[] {"1", "2"};
		
		BaseballGame newGame = baseballService.newGame(playerToken);
		
		assertNotNull(newGame);
		
		assertTrue(Arrays.equals(newGame.getPlayerToken(), playerToken));
	}
	
	@Test
	public void testFindGameByToken() {
		BaseballService baseballService = setService();
		
		BaseballGame game1 = baseballService.findGameByToken("1");
		BaseballGame game2 = baseballService.findGameByToken("2");
		
		assertEquals(game1, game2);
	}

	@Test
	public void testSetNumberForToken() {
		BaseballService baseballService = setService();
		
		BaseballGame game = baseballService.findGameByToken("1");
		
		baseballService.setNumberForToken("1", "123");
		baseballService.setNumberForToken("2", "456");
		
		assertNull(baseballService.setNumberForToken("3", "456"));
		
		assertEquals(game.getPlayerNumber(0), "123");
		assertEquals(game.getPlayerNumber(1), "456");
	}
	
	@Test
	public void testGuess() {
		BaseballService baseballService = setService();
		setGuessNumber(baseballService);

		Map<String, Object>  result;
		
		result = baseballService.guess("1", "123");
		
		assertNotNull(result.get("result"));
		
		assertEquals(((Map)result.get("result")).get("strike"), 0);
		assertEquals(((Map)result.get("result")).get("ball"), 0);
		
		assertEquals(result.get("sourceToken"), "1");
		assertEquals(result.get("targetToken"), "2");
		
		assertFalse(baseballService.findGameByToken("1").isEnded);
		
		result = baseballService.guess("1", "546");
		
		assertNotNull(result.get("result"));
		
		assertEquals(((Map)result.get("result")).get("strike"), 1);
		assertEquals(((Map)result.get("result")).get("ball"), 2);
		
		assertEquals(result.get("sourceToken"), "1");
		assertEquals(result.get("targetToken"), "2");
		
		assertFalse(baseballService.findGameByToken("1").isEnded);
		
		result = baseballService.guess("2", "123");
		
		assertNotNull(result.get("result"));
		
		assertEquals(((Map)result.get("result")).get("strike"), 3);
		assertEquals(((Map)result.get("result")).get("ball"), 0);
		
		assertEquals(result.get("sourceToken"), "2");
		assertEquals(result.get("targetToken"), "1");
		
		assertTrue(baseballService.findGameByToken("1").isEnded);
	}
	
	private BaseballService setService() {
		BaseballService baseballService = new BaseballServiceImpl();
		
		String[] playerToken = new String[] {"1", "2"};
		
		baseballService.newGame(playerToken);
		
		return baseballService;
	}
	
	private BaseballService setGuessNumber(BaseballService service) {

		service.setNumberForToken("1", "123");
		service.setNumberForToken("2", "456");
		
		return service;
	}
}
