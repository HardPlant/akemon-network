package io.hardplant.matchmaker.service.impl;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class MatchRoom {
	
	String roomId;
	List<String> sessions;
	
	int currentPlayer 		= 0;
	int requiredPlayerCount = 2;
	
	public MatchRoom() {
		SecureRandom random = new SecureRandom();
		
		String time = Long.toString(random.nextLong());
		
		this.roomId = Base64.getEncoder().encodeToString(time.getBytes());
		this.sessions = new ArrayList<String>();
	}

	public String getRoomId() {
		return roomId;
	}

	public int getRequiredPlayerCount() {
		return requiredPlayerCount;
	}
	
	public boolean isRegisterable(String session) {
		return currentPlayer < requiredPlayerCount;
	}

	public int getRegisterScore() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public synchronized void register(String session) {
		if (currentPlayer < requiredPlayerCount) {
			this.sessions.add(session);
			currentPlayer++;			
		}			
	}
	
	public void unregister(String session) {
		if ( this.sessions.remove(session) ) {
			currentPlayer--;
		}
	}

	public boolean isMatched() {
		return currentPlayer == requiredPlayerCount;
	}

}
