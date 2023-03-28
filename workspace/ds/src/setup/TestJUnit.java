package setup;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class TestJUnit {

	@Rule
	public Timeout globalTimeout = Timeout.seconds(1);

	@BeforeClass
	public static void printMessage() {
		System.out.println("Testing JUnit");
	}
	
	@Test
	public void testPass() {
		Adder a = new Adder();
		assertEquals(0, a.getTotal());
		a.add(10);
		assertEquals(10, a.getTotal());
	}
	
	@Test
	public void testFail() {
		Adder a = new Adder();
		assertEquals(0, a.getTotal());
		a.add(10);
		assertEquals(11, a.getTotal());
	}
	
	@Test
	public void testException() {
		Adder a = new Adder();
		assertEquals(0, a.getTotal());
		a.divideBy(0);
		assertEquals(0, a.getTotal());
	}
}
