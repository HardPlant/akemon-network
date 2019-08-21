package io.hardplant.baseball.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import io.hardplant.baseball.service.BaseballService;

@Service
public class BaseballServiceImpl implements BaseballService {
	
	private static final int BASEBALL_MAX_PLAYERS = 2;
	
	public Map<String, BaseballGame> gamePool;

	public BaseballServiceImpl() {
		
		gamePool = new HashMap<String, BaseballGame>();
	}
	
	public BaseballGame newGame(String[] playerTokens) {
		
		for (String playerToken : playerTokens) {
			
			if (gamePool.get(playerToken) != null)
				return null;
		}
		
		BaseballGame newGame = new BaseballGame(BASEBALL_MAX_PLAYERS);
		
		newGame.setPlayerToken(playerTokens);
		
		for (String playerToken : playerTokens) {
			
			gamePool.put(playerToken, newGame);
		}
		
		return newGame;
	}
	
	public BaseballGame findGameByToken(String token) {
		
		return gamePool.get(token); 
	}
	
	public BaseballGame setNumberForToken(String token, String number) {
		
		BaseballGame game = gamePool.get(token);
		
		if (game == null)
			return null;
		
		game.setPlayerNumber(game.getPlayerIndex(token), number);
		
		return game;
	}
	
	public Map<String, Object> guess(String guesserToken, String number) {
		
		BaseballGame game = gamePool.get(guesserToken);
		
		Map<String, Object> response = new HashMap<String, Object>();
		
		if (game == null)
			return null;
		
		HashMap<String, Integer> result = game.guess(game.getPlayerIndex(guesserToken) + 1 , number);
		
		response.put("result", result);
		response.put("sourceToken", guesserToken);
		response.put("targetToken", game.getGuessTargetToken(guesserToken));
		
		return response;
	}
}

