package hw5;

import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class HW5Test {
	@Rule
	public Timeout globalTimeout = Timeout.seconds(1);

	@Test
	public void testContainsEmpty05() {
		TwoThreeTree t = new TwoThreeTree();
		for (int i = 0; i < 200; i++)
			assertFalse(t.contains(i));
	}

	@Test
	public void testContainsSingleNode05() {
		TwoThreeTree t1 = new TwoThreeTree("50");
		TwoThreeTree t2 = new TwoThreeTree("34 102");
		for (int i = 0; i < 200; i++) {
			if (i == 50)
				assertTrue(t1.contains(i));
			else
				assertFalse(t1.contains(i));
			if (i == 34 || i == 102)
				assertTrue(t2.contains(i));
			else
				assertFalse(t2.contains(i));
		}
	}

	@Test
	public void testContainsMultipleNodes10() {
		TwoThreeTree t1 = new TwoThreeTree("7 15,4,10 12,22");
		assertTrue(t1.contains(22));
		assertFalse(t1.contains(48));
		assertTrue(t1.contains(7));
		assertTrue(t1.contains(4));
		assertFalse(t1.contains(63));
		assertTrue(t1.contains(15));
		assertTrue(t1.contains(10));
		assertFalse(t1.contains(9));
		assertTrue(t1.contains(22));
		assertTrue(t1.contains(12));
		assertFalse(t1.contains(13));

		TwoThreeTree t2 = new TwoThreeTree("100 200,50,125 160,307,7 22,63,102,152,188 189,202 250,308");
		assertTrue(t2.contains(202));
		assertFalse(t2.contains(203));
		assertFalse(t2.contains(302));
		assertTrue(t2.contains(307));
		assertTrue(t2.contains(308));
		assertFalse(t2.contains(309));
		assertFalse(t2.contains(48));
		assertFalse(t2.contains(49));
		assertTrue(t2.contains(50));
		assertTrue(t2.contains(152));
		assertTrue(t2.contains(63));
		assertFalse(t2.contains(1));
		assertTrue(t2.contains(7));
		assertFalse(t2.contains(10));
		assertTrue(t2.contains(188));
		for (int i = 90; i < 130; i++) {
			if (i == 100 || i == 102 || i == 125)
				assertTrue(t2.contains(i));
			else
				assertFalse(t2.contains(i));
		}
		assertTrue(t2.contains(189));
	}

	@Test
	public void testHeightEmpty05() {
		TwoThreeTree t = new TwoThreeTree();
		assertEquals(-1, t.height());
	}

	@Test
	public void testHeightSingleNode05() {
		TwoThreeTree t1 = new TwoThreeTree("9345");
		TwoThreeTree t2 = new TwoThreeTree("1 2");
		assertEquals(0, t1.height());
		assertEquals(0, t2.height());
	}

	@Test
	public void testHeightMultipleNodes10() {
		TwoThreeTree t1 = new TwoThreeTree("7 15,4,10 12,22");
		TwoThreeTree t2 = new TwoThreeTree("100 200,50,125 160,307,7 22,63,102,152,188 189,202 250,308");
		TwoThreeTree t3 = new TwoThreeTree("8,4,12,2,6,10,14,1,3,5,7,9,11,13,15");
		assertEquals(1, t1.height());
		assertEquals(2, t2.height());
		assertEquals(3, t3.height());
	}

	@Test
	public void testNodeCountEmpty05() {
		TwoThreeTree t = new TwoThreeTree();
		assertEquals(0, t.nodeCount());
	}

	@Test
	public void testNodeCountSingleNode05() {
		TwoThreeTree t1 = new TwoThreeTree("9345");
		TwoThreeTree t2 = new TwoThreeTree("1 2");
		assertEquals(1, t1.nodeCount());
		assertEquals(1, t2.nodeCount());
	}

	@Test
	public void testNodeCounteNodes10() {
		TwoThreeTree t0 = new TwoThreeTree("10,4,15");
		TwoThreeTree t1 = new TwoThreeTree("7 15,4,10 12,22");
		TwoThreeTree t2 = new TwoThreeTree("100 200,50,125 160,307,7 22,63,102,152,188 189,202 250,308");
		TwoThreeTree t3 = new TwoThreeTree("8,4,12,2,6,10,14,1,3,5,7,9,11,13,15");
		assertEquals(4, t1.nodeCount());
		assertEquals(3, t0.nodeCount());
		assertEquals(11, t2.nodeCount());
		assertEquals(15, t3.nodeCount());
	}

	@Test
	public void testAddFirstKey05() {
		TwoThreeTree t1 = new TwoThreeTree();
		TwoThreeTree t2 = new TwoThreeTree();
		t1.add(8);
		t2.add(0);
		assertEquals(1, t1.nodeCount());
		assertEquals(0, t1.height());
		assertFalse(t1.contains(0));
		assertFalse(t1.contains(1));
		assertTrue(t1.contains(8));
		assertFalse(t1.contains(10));
		assertEquals(1, t2.nodeCount());
		assertEquals(0, t2.height());
		assertTrue(t2.contains(0));
		assertFalse(t2.contains(1));
		assertFalse(t2.contains(8));
		assertFalse(t2.contains(10));
	}

	@Test
	public void testAddSecondKey05() {
		TwoThreeTree t1 = new TwoThreeTree();
		TwoThreeTree t2 = new TwoThreeTree();
		t1.add(8);
		t2.add(8);
		t1.add(4);
		t2.add(14);

		assertEquals(1, t1.nodeCount());
		assertEquals(0, t1.height());
		assertFalse(t1.contains(0));
		assertFalse(t1.contains(1));
		assertTrue(t1.contains(4));
		assertTrue(t1.contains(8));
		assertFalse(t1.contains(14));

		assertEquals(1, t2.nodeCount());
		assertEquals(0, t2.height());
		assertFalse(t2.contains(0));
		assertFalse(t2.contains(1));
		assertTrue(t2.contains(8));
		assertTrue(t2.contains(14));
	}

	@Test
	public void testAddInOrder15() {
		int[] data = { -13, -9, -5, -1, 0, 1, 2, 4, 8, 10, 12, 18, 31, 33, 38 };
		TwoThreeTree t1 = new TwoThreeTree();
		TwoThreeTree t2 = new TwoThreeTree();
		for (int i = 0; i < data.length - 1; i++) {
			t1.add(data[i]);
			t2.add(data[data.length - i - 1]);
		}

		assertEquals(2, t1.height());
		assertEquals(2, t2.height());
		assertEquals(11, t1.nodeCount());
		assertEquals(11, t2.nodeCount());
		assertTrue(t1.contains(-13));
		assertFalse(t2.contains(-13));
		assertFalse(t1.contains(38));
		assertTrue(t2.contains(38));

		t1.add(38);
		t2.add(-13);

		for (int d : data) {
			assertTrue(t1.contains(d));
			assertTrue(t2.contains(d));
		}

		for (int i = -17; i < -9; i++) {
			if (i == -13) {
				assertTrue(t1.contains(i));
				assertTrue(t2.contains(i));
			} else {
				assertFalse(t1.contains(i));
				assertFalse(t2.contains(i));
			}
		}
		assertFalse(t1.contains(3));
		assertFalse(t2.contains(3));
	}
	
	@Test
	public void testAddManyNodes15() {
		String s0 = "57,27 42,75,12,30 36,45,63,93";
		TwoThreeTree t = new TwoThreeTree(s0);
		
		t.add(60);
		String s1 = "57,27 42,75,12,30 36,45,60 63,93";
		TwoThreeTree t1 = new TwoThreeTree(s1);
		assertTrue(t.identical(t1));
		
		t.add(66);
		String s2 = "57,27 42,63 75,12,30 36,45,60,66,93";
		TwoThreeTree t2 = new TwoThreeTree(s2);
		assertTrue(t.identical(t2));
		
		t.add(99);
		String s3 = "57,27 42,63 75,12,30 36,45,60,66,93 99";
		TwoThreeTree t3 = new TwoThreeTree(s3);
		assertTrue(t.identical(t3));
		
		t.add(96);
		String s4 = "57 75,27 42,63,96,12,30 36,45,60,66,93,99";
		TwoThreeTree t4 = new TwoThreeTree(s4);
		assertTrue(t.identical(t4));
		
		t.add(39);
		String s5 = "57,36,75,27,42,63,96,12,30,39,45,60,66,93,99";
		TwoThreeTree t5 = new TwoThreeTree(s5);
		assertTrue(t.identical(t5));
		
		TwoThreeTree smallTree = new TwoThreeTree("30 60,10 20,40 50,70 80");
		smallTree.add(45);
		TwoThreeTree largeTree = new TwoThreeTree("45,30,60,10 20,40,50,70 80");
		assertTrue(smallTree.identical(largeTree));
	}
}
