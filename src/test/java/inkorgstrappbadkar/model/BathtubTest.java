package inkorgstrappbadkar.model;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BathtubTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Bathtub tub = new Bathtub(new Date(), 7, 0);
		tub.addPoints(35);
		
		assertEquals(tub.getPeriods().get(0).getBuffer(), 35.0, 0.001);
		assertEquals(tub.getPeriods().get(0).getRunOff(), 0, 0.001);
		assertEquals(tub.getPeriods().get(0).getBufferAfterDiff(), 31.5, 0.001);
				
	}

}
