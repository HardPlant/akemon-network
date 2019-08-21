package io.hardplant.matchmaker.service.impl;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

public class MatchmakerServiceImplTest {

	@Test
	public void testRegister() {
		MatchmakerServiceImpl matchmakerService = new MatchmakerServiceImpl();
		Map<String, MatchRoom> roomPool = matchmakerService.roomPool;
		String session = "a";
		
		matchmakerService.register(session);
		
		assertEquals(1, roomPool.size());
		
		matchmakerService.register("b");
		
		assertEquals(roomPool.get("a"),roomPool.get("b"));
		
		matchmakerService.register("c");
		
		assertNotEquals(roomPool.get("a"),roomPool.get("c"));
		assertNotEquals(roomPool.get("b"),roomPool.get("c"));
		
	}

	public class MultiService implements Runnable {

		private MatchmakerServiceImpl matchmakerService;

		public MultiService(MatchmakerServiceImpl mms) {
			this.matchmakerService = mms;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
		
	}
}
