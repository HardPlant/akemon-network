package io.hardplant.matchmaker.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatchRoomTest {

	@Test
	public void testRoomId() {
		MatchRoom room1 = new MatchRoom();
		MatchRoom room2 = new MatchRoom();
		MatchRoom room3 = new MatchRoom();
		
		assertNotEquals(room1.getRoomId(), room2.getRoomId());
		assertNotEquals(room2.getRoomId(), room3.getRoomId());
		assertNotEquals(room1.getRoomId(), room3.getRoomId());
	}

}
