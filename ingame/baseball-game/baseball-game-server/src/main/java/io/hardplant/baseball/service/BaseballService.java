package io.hardplant.baseball.service;

import java.util.Map;

import io.hardplant.baseball.service.impl.BaseballGame;

public interface BaseballService {

	String join(String roomToken, String session);
	
	BaseballGame newGame(String[] playerToken);

	BaseballGame findGameByToken(String token);

	BaseballGame setNumberForToken(String token, String number);

	Map<String, Object> guess(String guesserToken, String number);

}
