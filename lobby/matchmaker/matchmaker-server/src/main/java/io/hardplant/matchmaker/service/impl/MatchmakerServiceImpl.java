package io.hardplant.matchmaker.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import io.hardplant.matchmaker.service.MatchmakerSerivce;

@Service
public class MatchmakerServiceImpl implements MatchmakerSerivce {

	Map<String, MatchRoom> roomPool;
	
	public String registerAndMatch(String session) {
		
		Map<Integer, MatchRoom> registerScore = new HashMap<Integer, MatchRoom>(); 
		
		for (MatchRoom room : roomPool.values()) {
			if (room.isRegisterable(session)) {		
				registerScore.put(room.getRegisterScore(), room);
			}
		}
		
		return session;
	}
}
