import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Peter Mösenthin.
 */
public class BowlingGameKataTest
{

	private BowlingGameKata bgk;

	@Before
	public void setUp() throws Exception {
		bgk = new BowlingGameKata();
	}
	
	private void rollMany(int n, int pins) {
		for (int i = 0; i < n; i++)
			bgk.roll(pins);
	}

	@Test
	public void testGutterGame() throws Exception {
		rollMany(20, 0);
		assertThat(bgk.score(), is(0));
	}

	@Test
	public void testAllOnes() throws Exception {
		rollMany(20,1);
		assertThat(bgk.score(), is(20));
	}

	@Test
	public void testOneSpare() throws Exception {
		rollSpare();
		bgk.roll(3);
		rollMany(17,0);
		assertThat(bgk.score(), is(16));
	}

	@Test
	public void testOneStrike() throws Exception {
		rollStrike();
		bgk.roll(3);
		bgk.roll(4);
		rollMany(16, 0);
		assertThat(bgk.score(), is(24));
	}

	@Test
	public void testPerfectGame() throws Exception {
		rollMany(12,10);
		assertThat(bgk.score(), is(300));
	}

	private void rollStrike() {
		bgk.roll(10);
	}

	private void rollSpare() {
		bgk.roll(5);
		bgk.roll(5);
	}
}