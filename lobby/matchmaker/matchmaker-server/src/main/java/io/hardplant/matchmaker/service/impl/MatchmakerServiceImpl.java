package io.hardplant.matchmaker.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import io.hardplant.matchmaker.service.MatchmakerSerivce;

@Service
public class MatchmakerServiceImpl implements MatchmakerSerivce {

	Map<String, MatchRoom> roomPool;
	
	
	public MatchmakerServiceImpl() {
		roomPool = new HashMap<String, MatchRoom>();
	}

	public String register(String session) {
		
		Map<Integer, MatchRoom> registerScore = new HashMap<Integer, MatchRoom>(); 
		MatchRoom matchedRoom;
		
		for (MatchRoom room : roomPool.values()) {
			if (room.isRegisterable(session)) {		
				registerScore.put(room.getRegisterScore(), room);
			}
		}
		
		if (registerScore.size() == 0) {
			MatchRoom newRoom = new MatchRoom();
			
			roomPool.put(session, newRoom);
			registerScore.put(Integer.MAX_VALUE, newRoom);
		}
		
		Integer[] scoreArray = registerScore.keySet().toArray(new Integer[]{});
		Arrays.sort(scoreArray);
		
		matchedRoom = registerScore.get(scoreArray[scoreArray.length - 1]);
		
		matchedRoom.register(session);
		roomPool.put(session, matchedRoom);
		
		return matchedRoom.getRoomId();
	}
	
	public MatchRoom match(String session) throws InterruptedException {
		
		MatchRoom matchedRoom = roomPool.get(session);
		
		if (matchedRoom == null) {
			return null;
		}
		
		while ( !matchedRoom.isMatched() ) {
			Thread.sleep(100);
		}
			
		return matchedRoom;
	}
}
