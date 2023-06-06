
package p1;

import static org.junit.Assert.*;
import java.util.Random;

import org.junit.Test;

public class MyTest {
        
	// start == START == 
	// X X X
	//  XX X
	//  XXX 
	//   X X
	// XXXXX
	boolean[][] start = { { true, false, true, false, true }, { false, true, true, false, true },
			{ false, true, true, true, false }, { false, false, true, false, true }, { true, true, true, true, true } };
	boolean[][] START = { { true, false, true, false, true }, { false, true, true, false, true },
			{ false, true, true, true, false }, { false, false, true, false, true }, { true, true, true, true, true } };
	
	// array2 = 
	// XXXXX
	// XXX  
	// X   X
	// X   X
	// X XXX
	boolean[][] array2 = { { true, true, true, true, true }, { true, true, true, false, false },
			{ true, false, false, false, true }, { true, false, false, false, true },
			{ true, false, true, true, true } };
	
	// solArray ==
	// XXXXX
	// X   X
	// X   X
	// X   X
	// XXXXX
	boolean[][] solArray = { 
			{ true, true, true, true, true }, 
			{ true, false, false, false, true },
			{ true, false, false, false, true }, 
			{ true, false, false, false, true },
			{ true,  true, true, true, true } };


	// solArray ==
	// XXXXX
	//    XX
	// X   X
	// X   X
	// XXXXX
	boolean[][] testArray = { 
			{ true, true, true, true, true }, 
			{ false, false, false, true, true },
			{ true, false, false, false, true }, 
			{ true, false, false, false, true },
			{ true,  true, true, true, true } };
	@Test
	public void testIsSolved01() {
		Board b1 = new Board(solArray);
		Board b2 = new Board(0);
		Board b3 = new Board(array2);
		
		assertTrue(b1.isSolved());
		b1.move('a');
		assertTrue(b1.isSolved());
		b1.move('b');
		assertFalse(b1.isSolved());
		
		assertTrue(b2.isSolved());
		
		assertFalse(b3.isSolved());
		b3.move('b');
		assertFalse(b3.isSolved());
		b3.move('W');
		assertTrue(b3.isSolved());
	}
	@Test 
	public void testStates()
	{
		Board b1 = new Board(testArray);
		b1.move('a'); // repeat state lost
		assertTrue(b1.getStatus());

		Board b2 = new Board(testArray);
		b1.move('a'); // repeat state 
		assertTrue(b2.getStatus());
		
        Board b3 = new Board(testArray);
        b2.move('B');
        assertTrue(b3.isSolved());
	}
}
