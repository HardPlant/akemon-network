package io.hardplant.matchmaker.service.impl;

import java.security.SecureRandom;
import java.util.Base64;

public class MatchRoom {
	
	String roomId;
	int requiredPlayerCount;
	
	public MatchRoom() {
		
		SecureRandom random = new SecureRandom();
		
		String time = Long.toString(random.nextLong());
		
		this.roomId = Base64.getEncoder().encodeToString(time.getBytes());
	}

	public String getRoomId() {
		return roomId;
	}

	public int getRequiredPlayerCount() {
		return requiredPlayerCount;
	}

	public void setRequiredPlayerCount(int requiredPlayerCount) {
		this.requiredPlayerCount = requiredPlayerCount;
	}
	
	public boolean isRegisterable(String session) {
		return true;
	}

	public int getRegisterScore() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void register(String session) {
		// TODO Auto-generated method stub
		
	}

	public boolean isMatched() {
		// TODO Auto-generated method stub
		return false;
	}

}
