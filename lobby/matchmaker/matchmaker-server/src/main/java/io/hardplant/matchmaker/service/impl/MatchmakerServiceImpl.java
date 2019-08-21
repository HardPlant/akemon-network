package io.hardplant.matchmaker.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import io.hardplant.matchmaker.service.MatchmakerSerivce;

@Service
public class MatchmakerServiceImpl implements MatchmakerSerivce {

	Map<String, MatchRoom> roomPool;
	
	public String registerAndMatch(String session) {
		
		Map<Integer, MatchRoom> registerScore = new HashMap<Integer, MatchRoom>(); 
		MatchRoom matchedRoom;
		
		for (MatchRoom room : roomPool.values()) {
			if (room.isRegisterable(session)) {		
				registerScore.put(room.getRegisterScore(), room);
			}
		}
		
		Integer[] scoreArray = (Integer[]) registerScore.keySet().toArray();
		Arrays.sort(scoreArray);
		
		matchedRoom = registerScore.get(scoreArray[scoreArray.length - 1]);
		
		matchedRoom.register(session);
		
		return matchedRoom.getRoomId();
	}
}
