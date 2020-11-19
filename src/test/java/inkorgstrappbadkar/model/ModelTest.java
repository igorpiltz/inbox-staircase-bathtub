package inkorgstrappbadkar.model;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ModelTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	private Model model;

	@Before
	public void setUp() throws Exception {
		model = new Model();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void startStopGametest() {
		model.startGame(new Game(new Date(), 7, 0));
		assertEquals(model.getOldGames().size(), 0);
		
		model.endCurrentGame();
		assertEquals(model.getOldGames().size(), 1);
		assertNull(model.getCurrentGame());
		
	}

}
