package hw5;

import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class PTest {
    // Basic T2 Cases
    @Test 
    public void testRootT2LeftMostT2(){
        TwoThreeTree t0 = new TwoThreeTree("10,5,11"); // Insert into leftmost location
        TwoThreeTree t1 = new TwoThreeTree("10,1,11"); // Insert into rightnost location

        TwoThreeTree s0 = new TwoThreeTree("10,1 5,11"); // insert key in node
        
        t0.add(1);
        t1.add(5);

        assertTrue(t0.contains(5));
        assertTrue(t1.contains(1));

        assertTrue(t0.identical(s0));
        assertTrue(t1.identical(s0));
    }
    @Test 
    public void testRootT2RightMostT2(){
        TwoThreeTree t0 = new TwoThreeTree("10,1,15"); // Insert into leftmost location
        TwoThreeTree t1 = new TwoThreeTree("10,1,11"); // Insert into rightnost location

        TwoThreeTree s0 = new TwoThreeTree("10,1,11 15"); // Corrects t1,2,3
        
        t0.add(11);
        t1.add(15);

        assertTrue(t0.contains(15));
        assertTrue(t1.contains(11));

        assertTrue(t0.identical(s0));
        assertTrue(t1.identical(s0));
    }

    // Overflow T2 Cases
    
    @Test 
    public void testRootT2LeftMostT3(){
        TwoThreeTree t0 = new TwoThreeTree("10,3 5,15"); // Insert into leftmost location
        TwoThreeTree t1 = new TwoThreeTree("10,1 5,15"); // Insert into leftmost location
        TwoThreeTree t2 = new TwoThreeTree("10,1 3,15"); // Insert into rightnost location

        TwoThreeTree s0 = new TwoThreeTree("3 10,1,5,15"); // Corrects t1,2,3
        
        t0.add(1);
        t1.add(3);
        t2.add(5);

        assertTrue(t0.contains(1));
        assertTrue(t1.contains(3));
        assertTrue(t1.contains(5));

        assertTrue(t0.identical(s0));
        assertTrue(t1.identical(s0));
        assertTrue(t2.identical(s0));
    }

    @Test 
    public void testRootT2RightMostT3(){
        TwoThreeTree t0 = new TwoThreeTree("10,1,13 15"); // Insert into leftmost location
        TwoThreeTree t1 = new TwoThreeTree("10,1,11 15"); // Insert into leftmost location
        TwoThreeTree t2 = new TwoThreeTree("10,1,11 13"); // Insert into leftmost location

        TwoThreeTree s0 = new TwoThreeTree("10 13,1,11,15"); // Corrects t1,2,3
        
        t0.add(11);
        t1.add(13);
        t2.add(15);

        assertTrue(t0.contains(11));
        assertTrue(t1.contains(13));
        assertTrue(t1.contains(15));

        assertTrue(t0.identical(s0));
        assertTrue(t1.identical(s0));
        assertTrue(t2.identical(s0));
    }

    // Basic T3 Cases
    
    @Test 
    public void testRootT3LeftMostT2(){
        TwoThreeTree t0 = new TwoThreeTree("10 20,5,12,21"); // Insert into leftmost location
        TwoThreeTree t1 = new TwoThreeTree("10 20,1,12,21"); // Insert into leftmost location

        TwoThreeTree s0 = new TwoThreeTree("10 20,1 5,12,21"); // Corrects t1,2,3
        
        t0.add(1);
        t1.add(5);

        assertTrue(t0.contains(1));
        assertTrue(t1.contains(5));

        assertTrue(t0.identical(s0));
        assertTrue(t1.identical(s0));
    }

    @Test 
    public void testRootT3MiddleT2(){
        TwoThreeTree t0 = new TwoThreeTree("10 20,1,15,21"); // Insert into leftmost location
        TwoThreeTree t1 = new TwoThreeTree("10 20,1,12,21"); // Insert into leftmost location

        TwoThreeTree s0 = new TwoThreeTree("10 20,1,12 15,21"); // Corrects t1,2,3
        
        t0.add(12);
        t1.add(15);

        assertTrue(t0.contains(12));
        assertTrue(t1.contains(15));

        assertTrue(t0.identical(s0));
        assertTrue(t1.identical(s0));
    }

    @Test 
    public void testRootT3RightT2(){
        TwoThreeTree t0 = new TwoThreeTree("10 20,1,12,25"); // Insert into leftmost location
        TwoThreeTree t1 = new TwoThreeTree("10 20,1,12,21"); // Insert into leftmost location

        TwoThreeTree s0 = new TwoThreeTree("10 20,1,12,21 25"); // Corrects t1,2,3
        
        t0.add(21);
        t1.add(25);

        assertTrue(t0.contains(21));
        assertTrue(t1.contains(25));

        assertTrue(t0.identical(s0));
        assertTrue(t1.identical(s0));
    }

    // Overflow T3 Cases

    @Test 
    public void testRootT3LeftMostT3(){
        TwoThreeTree t0 = new TwoThreeTree("10 20,1 3,15,25"); 
        TwoThreeTree t1 = new TwoThreeTree("10 20,1 5,15,25");
        TwoThreeTree t2 = new TwoThreeTree("10 20,3 5,15,25");

        TwoThreeTree s0 = new TwoThreeTree("10,3,20,1,5,15,25");

        t0.add(5);
        t1.add(3);
        t2.add(1);

        assertTrue(t0.contains(5));
        assertTrue(t1.contains(3));
        assertTrue(t2.contains(1));

        assertTrue(t0.identical(s0));
        assertTrue(t1.identical(s0));
        assertTrue(t2.identical(s0));
    }
    @Test 
    public void testRootT3MiddleT3(){
        TwoThreeTree t0 = new TwoThreeTree("10 20,1,11 13,25"); 
        TwoThreeTree t1 = new TwoThreeTree("10 20,1,11 15,25"); 
        TwoThreeTree t2 = new TwoThreeTree("10 20,1,13 15,25"); 

        TwoThreeTree s0 = new TwoThreeTree("13,10,20,1,11,15,25");

        t0.add(15);
        t1.add(13);
        t2.add(11);

        assertTrue(t0.contains(15));
        assertTrue(t1.contains(13));
        assertTrue(t2.contains(11));

        assertTrue(t0.identical(s0));
        assertTrue(t1.identical(s0));
        assertTrue(t2.identical(s0));
    }
    @Test 
    public void testRootT3RightMostT3(){
        TwoThreeTree t0 = new TwoThreeTree("10 20,1,15,27 30"); 
        TwoThreeTree t1 = new TwoThreeTree("10 20,1,15,25 30"); 
        TwoThreeTree t2 = new TwoThreeTree("10 20,1,15,25 27");

        TwoThreeTree s0 = new TwoThreeTree("20,10,27,1,15,25,30");

        t0.add(25);
        t1.add(27);
        t2.add(30);

        assertTrue(t0.contains(25));
        assertTrue(t1.contains(27));
        assertTrue(t2.contains(30));

        assertTrue(t0.identical(s0));
        assertTrue(t1.identical(s0));
        assertTrue(t2.identical(s0));
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
	@Test
	public void testHeightMulti() {
		TwoThreeTree t1 = new TwoThreeTree("7 15,4,10 12,22");
		TwoThreeTree t2 = new TwoThreeTree("100 200,50,125 160,307,7 22,63,102,152,188 189,202 250,308");
		TwoThreeTree t3 = new TwoThreeTree("8,4,12,2,6,10,14,1,3,5,7,9,11,13,15");
		assertEquals(1, t1.height());
		assertEquals(2, t2.height());
		assertEquals(3, t3.height());
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

//    @Test 
//	public void testAddFirstThreeNodes() {
//        TwoThreeTree t = new TwoThreeTree();
//        t.add(1);
//        assertEquals(t.root.keys[0], 1);
//
//        TwoThreeTree t1 = new TwoThreeTree();
//        t1.add(1);
//        t1.add(2);
//        assertEquals(t1.root.keys[0], 1);
//
//        TwoThreeTree t2 = new TwoThreeTree();
//        t2.add(1);
//        t2.add(2);
//        t2.add(3);
//        assertEquals(2, t2.root.keys[0]);
//    }
//    @Test 
//	public void testAdd4thNode() {
//        TwoThreeTree t2 = new TwoThreeTree();
//        t2.add(1);
//        t2.add(2);
//        t2.add(3);
//        t2.add(4);
//        assertEquals(2, t2.root.keys[0]);
//    }
    @Test 
	public void testAddALotCheckIfContains() {
        TwoThreeTree t = new TwoThreeTree();
        for (int i = 1; i <= 10; i++)
        {
            t.add(i);
            assert(t.contains(i)) : "Breaks at " + i;
        }
    }

    @Test 
	public void testNodeCount() {
        TwoThreeTree t = new TwoThreeTree("40 50,25,47,61 72");
        assertEquals(4, t.nodeCount()); // 
    }

    @Test 
	public void testNodeCountEmpty() {
        TwoThreeTree t = new TwoThreeTree();
        assertEquals(0, t.nodeCount()); // 
    }

    @Test 
	public void testNodeCountSingle() {
        TwoThreeTree t = new TwoThreeTree("40");
        TwoThreeTree t1 = new TwoThreeTree("40 50");
        assertEquals(1, t.nodeCount()); // 
        assertEquals(1, t1.nodeCount()); // 
    }

    @Test 
	public void testContains() {
        TwoThreeTree t = new TwoThreeTree("40 50,25,47,61 72");
        assertTrue(t.contains(40)); // First item
        assertTrue(t.contains(50)); // First item; second key
        assertTrue(t.contains(72)); // right most item
        assertTrue(t.contains(25)); // left most item
    }
    @Test 
	public void testContainsSingleNode() {
        TwoThreeTree t = new TwoThreeTree("50");
        TwoThreeTree t1 = new TwoThreeTree("34 52");
        for (int i = 0; i < 200; i++)
        {
            if (i == 50) assertTrue(t.contains(i));
            else assertFalse(t.contains(i));

            if (i == 34 || i == 52) assertTrue(t1.contains(i));
            else assertFalse(t1.contains(i));
        }
    }
    @Test 
	public void testEmptyContains() {
        TwoThreeTree t = new TwoThreeTree();
        assertFalse(t.contains(0)); // Test zero
        for (int i = 1; i < 200; i++)
        {
            assertFalse(t.contains(i)); // Testing several
        }
    }
    @Test 
	public void testContainsNot() {
        TwoThreeTree t = new TwoThreeTree("40 50,25,47,61 72");
        assertFalse(t.contains(1)); // left most
        assertFalse(t.contains(44)); // middle
        assertFalse(t.contains(84)); // right most 
    }

    @Test 
    public void testHeight()
    {
        // TwoThreeTree t = new TwoThreeTree("10 20,5,15,30 40,2,9,12,16,25,31,60");
        TwoThreeTree t = new TwoThreeTree("40 50,25,47,61 72");
        assertTrue(t.height() == 1);
    }
}
