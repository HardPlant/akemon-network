package io.hardplant.baseball.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import io.hardplant.baseball.service.BaseballService;

@Service
public class BaseballServiceImpl implements BaseballService {
	
	private static final int BASEBALL_MAX_PLAYERS = 2;
	
	public Map<String, BaseballGame> gamePool; // playerToken, baseballToken
	public Map<String, List<String>> roomPool; // roomToken, playerToken

	public BaseballServiceImpl() {
		
		gamePool = new HashMap<String, BaseballGame>();
		roomPool = new HashMap<String, List<String>>();
	}
	
	public String join(String roomToken, String session) {
		
		if (roomPool.get(roomToken) == null) {
			roomPool.put(roomToken, new ArrayList<String>());
		}
		
		List<String> room = roomPool.get(roomToken);
		
		room.add(session);
		
		if (room.size() == BASEBALL_MAX_PLAYERS) {
			this.newGame(room.toArray(new String[] {}));
			
			for(String token : roomPool.keySet()) {
				roomPool.remove(token);
			}
		}

		return roomToken;
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

