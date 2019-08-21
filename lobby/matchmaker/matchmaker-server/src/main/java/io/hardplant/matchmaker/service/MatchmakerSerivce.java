package io.hardplant.matchmaker.service;

import io.hardplant.matchmaker.service.impl.MatchRoom;

public interface MatchmakerSerivce {

	String register(String session);

	MatchRoom match(String session) throws InterruptedException;

}
