package io.hardplant.matchmaker.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import io.hardplant.matchmaker.service.MatchmakerSerivce;

@Service
public class MatchmakerServiceImpl implements MatchmakerSerivce {

	Map<String, MatchRoom> roomPool;
	
	public String register(String session) {
		
		return session;
	}
}
