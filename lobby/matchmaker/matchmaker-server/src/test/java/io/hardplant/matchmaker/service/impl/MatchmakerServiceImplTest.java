package io.hardplant.matchmaker.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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
	
	@Test
	public void testMatch() throws InterruptedException {
		MatchmakerServiceImpl matchmakerService = new MatchmakerServiceImpl();
		Map<String, MatchRoom> roomPool = matchmakerService.roomPool;
		
		matchmakerService.register("a");
		WaitForMatch wfm = new WaitForMatch(matchmakerService, "a");
		wfm.start();
		
		assertFalse(roomPool.get("a").isMatched());
		
		matchmakerService.register("b");
		WaitForMatch wfmB = new WaitForMatch(matchmakerService, "b");
		wfmB.start();
		
		wfm.join();
		wfmB.join();
		
		assertTrue(roomPool.get("a").isMatched());
		assertTrue(wfm.matched);
		assertTrue(wfmB.matched);
		
	}
	
	@Test
	public void testManyMatch() throws InterruptedException {
		MatchmakerServiceImpl matchmakerService = new MatchmakerServiceImpl();
		Map<String, MatchRoom> roomPool = matchmakerService.roomPool;
		
		matchmakerService.register("a");
		WaitForMatch wfm = new WaitForMatch(matchmakerService, "a");
		wfm.start();
		
		matchmakerService.register("b");
		WaitForMatch wfmB = new WaitForMatch(matchmakerService, "b");
		wfmB.start();
		
		matchmakerService.register("c");
		WaitForMatch wfmC = new WaitForMatch(matchmakerService, "c");
		wfmC.start();
		
		matchmakerService.register("d");
		WaitForMatch wfmD = new WaitForMatch(matchmakerService, "d");
		wfmD.start();
		
		wfm.join();
		wfmB.join();
		
		wfmC.join();
		wfmD.join();
		
		assertTrue(roomPool.get("a").isMatched());
		assertTrue(roomPool.get("b").isMatched());
		assertTrue(wfm.matched);
		assertTrue(wfmB.matched);

		assertTrue(roomPool.get("c").isMatched());
		assertTrue(roomPool.get("d").isMatched());
		assertTrue(wfmC.matched);
		assertTrue(wfmD.matched);
		
		assertNotEquals(roomPool.get("a"), roomPool.get("c"));
		assertNotEquals(roomPool.get("b"), roomPool.get("d"));
	}
	public class WaitForMatch extends Thread {

		private MatchmakerServiceImpl matchmakerService;
		private String session;
		private boolean matched;

		public WaitForMatch(MatchmakerServiceImpl mms, String session) {
			this.matchmakerService = mms;
			this.session = session;
		}

		@Override
		public void run() {
			try {
				this.matchmakerService.match(this.session);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.matched = true;
		}
		
	}
}
