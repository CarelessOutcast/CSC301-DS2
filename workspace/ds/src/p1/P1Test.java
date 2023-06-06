package p1;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class P1Test {

	@Rule
	public Timeout globalTimeout = Timeout.seconds(10);

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
	boolean[][] solArray = { { true, true, true, true, true }, { true, false, false, false, true },
			{ true, false, false, false, true }, { true, false, false, false, true },
			{ true,  true, true, true, true } };

	/*
	 * The Board should not modify the array parameter used to construct the Board.
	 * If this test fails, moves on the board are affecting the external array.
	 */

	@Test
	public void testDoesntModifyExternalArray02() {
		Board board = new Board(start);
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++)
				assertEquals(start[i][j], START[i][j]);

		board.move('c');
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++)
				assertEquals(start[i][j], START[i][j]);

		board.move('D');
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++)
				assertEquals(start[i][j], START[i][j]);

		board.move('V');
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++)
				assertEquals(start[i][j], START[i][j]);

		board.move('y');
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++)
				assertEquals(start[i][j], START[i][j]);
	}

	@Test
	public void testArrayConstructor01() {

		Board b = new Board(start);
		Board b2 = new Board(array2);
		Board b3 = new Board(solArray);

		assertTrue(b.isFilled(0, 0));
		assertFalse(b.isFilled(0, 1));
		assertTrue(b.isFilled(0, 2));
		assertFalse(b.isFilled(0, 3));
		assertTrue(b.isFilled(0, 4));
		assertFalse(b.isFilled(1, 0));
		assertTrue(b.isFilled(1, 1));
		assertTrue(b.isFilled(1, 2));
		assertFalse(b.isFilled(1, 3));
		assertTrue(b.isFilled(1, 4));
		assertFalse(b.isFilled(2, 0));
		assertTrue(b.isFilled(2, 1));
		assertTrue(b.isFilled(2, 2));
		assertTrue(b.isFilled(2, 3));
		assertFalse(b.isFilled(2, 4));
		assertFalse(b.isFilled(3, 0));
		assertFalse(b.isFilled(3, 1));
		assertTrue(b.isFilled(3, 2));
		assertFalse(b.isFilled(3, 3));
		assertTrue(b.isFilled(3, 4));
		assertTrue(b.isFilled(4, 0));
		assertTrue(b.isFilled(4, 1));
		assertTrue(b.isFilled(4, 2));
		assertTrue(b.isFilled(4, 3));
		assertTrue(b.isFilled(4, 4));

		assertTrue(b2.isFilled(0, 0));
		assertTrue(b2.isFilled(0, 1));
		assertTrue(b2.isFilled(0, 2));
		assertTrue(b2.isFilled(0, 3));
		assertTrue(b2.isFilled(0, 4));
		assertTrue(b2.isFilled(1, 0));
		assertTrue(b2.isFilled(1, 1));
		assertTrue(b2.isFilled(1, 2));
		assertFalse(b2.isFilled(1, 3));
		assertFalse(b2.isFilled(1, 4));
		assertTrue(b2.isFilled(2, 0));
		assertFalse(b2.isFilled(2, 1));
		assertFalse(b2.isFilled(2, 2));
		assertFalse(b2.isFilled(2, 3));
		assertTrue(b2.isFilled(2, 4));
		assertTrue(b2.isFilled(3, 0));
		assertFalse(b2.isFilled(3, 1));
		assertFalse(b2.isFilled(3, 2));
		assertFalse(b2.isFilled(3, 3));
		assertTrue(b2.isFilled(3, 4));
		assertTrue(b2.isFilled(4, 0));
		assertFalse(b2.isFilled(4, 1));
		assertTrue(b2.isFilled(4, 2));
		assertTrue(b2.isFilled(4, 3));
		assertTrue(b2.isFilled(4, 4));
		
		assertTrue(b3.isFilled(0, 0));
		assertTrue(b3.isFilled(0, 1));
		assertTrue(b3.isFilled(0, 2));
		assertTrue(b3.isFilled(0, 3));
		assertTrue(b3.isFilled(0, 4));
		assertTrue(b3.isFilled(1, 0));
		assertFalse(b3.isFilled(1, 1));
		assertFalse(b3.isFilled(1, 2));
		assertFalse(b3.isFilled(1, 3));
		assertTrue(b3.isFilled(1, 4));
		assertTrue(b3.isFilled(2, 0));
		assertFalse(b3.isFilled(2, 1));
		assertFalse(b3.isFilled(2, 2));
		assertFalse(b3.isFilled(2, 3));
		assertTrue(b3.isFilled(2, 4));
		assertTrue(b3.isFilled(3, 0));
		assertFalse(b3.isFilled(3, 1));
		assertFalse(b3.isFilled(3, 2));
		assertFalse(b3.isFilled(3, 3));
		assertTrue(b3.isFilled(3, 4));
		assertTrue(b3.isFilled(4, 0));
		assertTrue(b3.isFilled(4, 1));
		assertTrue(b3.isFilled(4, 2));
		assertTrue(b3.isFilled(4, 3));
		assertTrue(b3.isFilled(4, 4));
	}

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
	public void testMoveConstructorZero01() {
		Board b = new Board(0);
		assertTrue(b.isFilled(0, 0));
		assertTrue(b.isFilled(0, 1));
		assertTrue(b.isFilled(0, 2));
		assertTrue(b.isFilled(0, 3));
		assertTrue(b.isFilled(0, 4));
		assertTrue(b.isFilled(1, 0));
		assertFalse(b.isFilled(1, 1));
		assertFalse(b.isFilled(1, 2));
		assertFalse(b.isFilled(1, 3));
		assertTrue(b.isFilled(1, 4));
		assertTrue(b.isFilled(2, 0));
		assertFalse(b.isFilled(2, 1));
		assertFalse(b.isFilled(2, 2));
		assertFalse(b.isFilled(2, 3));
		assertTrue(b.isFilled(2, 4));
		assertTrue(b.isFilled(3, 0));
		assertFalse(b.isFilled(3, 1));
		assertFalse(b.isFilled(3, 2));
		assertFalse(b.isFilled(3, 3));
		assertTrue(b.isFilled(3, 4));
		assertTrue(b.isFilled(4, 0));
		assertTrue(b.isFilled(4, 1));
		assertTrue(b.isFilled(4, 2));
		assertTrue(b.isFilled(4, 3));
		assertTrue(b.isFilled(4, 4));
	}

	@Test
	public void testMoveConstructorOne01() {
		// Check that the the move 'C' is possible.
		boolean found = false;
		for (int i = 0; i < 10000; i++) {
			Board b = new Board(1);
			b.move('c');
			if (b.isSolved()) {
				found = true;
				break;
			}
		}
		assertTrue(found);

		// Check that the move 'c' is possible
		found = false;
		for (int i = 0; i < 10000; i++) {
			Board b = new Board(1);
			b.move('C');
			if (b.isSolved()) {
				found = true;
				break;
			}
		}

		// Check that the move 'Y' is possible
		found = false;
		for (int i = 0; i < 10000; i++) {
			Board b = new Board(1);
			b.move('y');
			if (b.isSolved()) {
				found = true;
				break;
			}
		}

		// Check that the move 'w' is possible
		found = false;
		for (int i = 0; i < 1000; i++) {
			Board b = new Board(1);
			b.move('W');
			if (b.isSolved()) {
				found = true;
				break;
			}
		}
	}

	@Test
	public void testMoveRight01() {
		Board b = new Board(start);
		b.move('A');
		assertTrue(b.isFilled(0, 0));
		assertTrue(b.isFilled(0, 1));
		assertFalse(b.isFilled(0, 2));
		assertTrue(b.isFilled(0, 3));
		assertFalse(b.isFilled(0, 4));
		assertFalse(b.isFilled(1, 0));
		assertTrue(b.isFilled(1, 1));
		assertTrue(b.isFilled(1, 2));
		assertFalse(b.isFilled(1, 3));
		assertTrue(b.isFilled(1, 4));
		assertFalse(b.isFilled(2, 0));
		assertTrue(b.isFilled(2, 1));
		assertTrue(b.isFilled(2, 2));
		assertTrue(b.isFilled(2, 3));
		assertFalse(b.isFilled(2, 4));
		assertFalse(b.isFilled(3, 0));
		assertFalse(b.isFilled(3, 1));
		assertTrue(b.isFilled(3, 2));
		assertFalse(b.isFilled(3, 3));
		assertTrue(b.isFilled(3, 4));
		assertTrue(b.isFilled(4, 0));
		assertTrue(b.isFilled(4, 1));
		assertTrue(b.isFilled(4, 2));
		assertTrue(b.isFilled(4, 3));
		assertTrue(b.isFilled(4, 4));

		b.move('B');
		assertTrue(b.isFilled(0, 0));
		assertTrue(b.isFilled(0, 1));
		assertFalse(b.isFilled(0, 2));
		assertTrue(b.isFilled(0, 3));
		assertFalse(b.isFilled(0, 4));
		assertTrue(b.isFilled(1, 0));
		assertFalse(b.isFilled(1, 1));
		assertTrue(b.isFilled(1, 2));
		assertTrue(b.isFilled(1, 3));
		assertFalse(b.isFilled(1, 4));
		assertFalse(b.isFilled(2, 0));
		assertTrue(b.isFilled(2, 1));
		assertTrue(b.isFilled(2, 2));
		assertTrue(b.isFilled(2, 3));
		assertFalse(b.isFilled(2, 4));
		assertFalse(b.isFilled(3, 0));
		assertFalse(b.isFilled(3, 1));
		assertTrue(b.isFilled(3, 2));
		assertFalse(b.isFilled(3, 3));
		assertTrue(b.isFilled(3, 4));
		assertTrue(b.isFilled(4, 0));
		assertTrue(b.isFilled(4, 1));
		assertTrue(b.isFilled(4, 2));
		assertTrue(b.isFilled(4, 3));
		assertTrue(b.isFilled(4, 4));

		b.move('C');
		assertTrue(b.isFilled(0, 0));
		assertTrue(b.isFilled(0, 1));
		assertFalse(b.isFilled(0, 2));
		assertTrue(b.isFilled(0, 3));
		assertFalse(b.isFilled(0, 4));
		assertTrue(b.isFilled(1, 0));
		assertFalse(b.isFilled(1, 1));
		assertTrue(b.isFilled(1, 2));
		assertTrue(b.isFilled(1, 3));
		assertFalse(b.isFilled(1, 4));
		assertFalse(b.isFilled(2, 0));
		assertFalse(b.isFilled(2, 1));
		assertTrue(b.isFilled(2, 2));
		assertTrue(b.isFilled(2, 3));
		assertTrue(b.isFilled(2, 4));
		assertFalse(b.isFilled(3, 0));
		assertFalse(b.isFilled(3, 1));
		assertTrue(b.isFilled(3, 2));
		assertFalse(b.isFilled(3, 3));
		assertTrue(b.isFilled(3, 4));
		assertTrue(b.isFilled(4, 0));
		assertTrue(b.isFilled(4, 1));
		assertTrue(b.isFilled(4, 2));
		assertTrue(b.isFilled(4, 3));
		assertTrue(b.isFilled(4, 4));

		b.move('D');
		assertTrue(b.isFilled(0, 0));
		assertTrue(b.isFilled(0, 1));
		assertFalse(b.isFilled(0, 2));
		assertTrue(b.isFilled(0, 3));
		assertFalse(b.isFilled(0, 4));
		assertTrue(b.isFilled(1, 0));
		assertFalse(b.isFilled(1, 1));
		assertTrue(b.isFilled(1, 2));
		assertTrue(b.isFilled(1, 3));
		assertFalse(b.isFilled(1, 4));
		assertFalse(b.isFilled(2, 0));
		assertFalse(b.isFilled(2, 1));
		assertTrue(b.isFilled(2, 2));
		assertTrue(b.isFilled(2, 3));
		assertTrue(b.isFilled(2, 4));
		assertTrue(b.isFilled(3, 0));
		assertFalse(b.isFilled(3, 1));
		assertFalse(b.isFilled(3, 2));
		assertTrue(b.isFilled(3, 3));
		assertFalse(b.isFilled(3, 4));
		assertTrue(b.isFilled(4, 0));
		assertTrue(b.isFilled(4, 1));
		assertTrue(b.isFilled(4, 2));
		assertTrue(b.isFilled(4, 3));
		assertTrue(b.isFilled(4, 4));

		b.move('E');
		assertTrue(b.isFilled(0, 0));
		assertTrue(b.isFilled(0, 1));
		assertFalse(b.isFilled(0, 2));
		assertTrue(b.isFilled(0, 3));
		assertFalse(b.isFilled(0, 4));
		assertTrue(b.isFilled(1, 0));
		assertFalse(b.isFilled(1, 1));
		assertTrue(b.isFilled(1, 2));
		assertTrue(b.isFilled(1, 3));
		assertFalse(b.isFilled(1, 4));
		assertFalse(b.isFilled(2, 0));
		assertFalse(b.isFilled(2, 1));
		assertTrue(b.isFilled(2, 2));
		assertTrue(b.isFilled(2, 3));
		assertTrue(b.isFilled(2, 4));
		assertTrue(b.isFilled(3, 0));
		assertFalse(b.isFilled(3, 1));
		assertFalse(b.isFilled(3, 2));
		assertTrue(b.isFilled(3, 3));
		assertFalse(b.isFilled(3, 4));
		assertTrue(b.isFilled(4, 0));
		assertTrue(b.isFilled(4, 1));
		assertTrue(b.isFilled(4, 2));
		assertTrue(b.isFilled(4, 3));
		assertTrue(b.isFilled(4, 4));
	}

	@Test
	public void testMoveLeft01() {
		Board b = new Board(start);
		b.move('a');
		assertFalse(b.isFilled(0, 0));
		assertTrue(b.isFilled(0, 1));
		assertFalse(b.isFilled(0, 2));
		assertTrue(b.isFilled(0, 3));
		assertTrue(b.isFilled(0, 4));
		assertFalse(b.isFilled(1, 0));
		assertTrue(b.isFilled(1, 1));
		assertTrue(b.isFilled(1, 2));
		assertFalse(b.isFilled(1, 3));
		assertTrue(b.isFilled(1, 4));
		assertFalse(b.isFilled(2, 0));
		assertTrue(b.isFilled(2, 1));
		assertTrue(b.isFilled(2, 2));
		assertTrue(b.isFilled(2, 3));
		assertFalse(b.isFilled(2, 4));
		assertFalse(b.isFilled(3, 0));
		assertFalse(b.isFilled(3, 1));
		assertTrue(b.isFilled(3, 2));
		assertFalse(b.isFilled(3, 3));
		assertTrue(b.isFilled(3, 4));
		assertTrue(b.isFilled(4, 0));
		assertTrue(b.isFilled(4, 1));
		assertTrue(b.isFilled(4, 2));
		assertTrue(b.isFilled(4, 3));
		assertTrue(b.isFilled(4, 4));

		b.move('b');
		assertFalse(b.isFilled(0, 0));
		assertTrue(b.isFilled(0, 1));
		assertFalse(b.isFilled(0, 2));
		assertTrue(b.isFilled(0, 3));
		assertTrue(b.isFilled(0, 4));
		assertTrue(b.isFilled(1, 0));
		assertTrue(b.isFilled(1, 1));
		assertFalse(b.isFilled(1, 2));
		assertTrue(b.isFilled(1, 3));
		assertFalse(b.isFilled(1, 4));
		assertFalse(b.isFilled(2, 0));
		assertTrue(b.isFilled(2, 1));
		assertTrue(b.isFilled(2, 2));
		assertTrue(b.isFilled(2, 3));
		assertFalse(b.isFilled(2, 4));
		assertFalse(b.isFilled(3, 0));
		assertFalse(b.isFilled(3, 1));
		assertTrue(b.isFilled(3, 2));
		assertFalse(b.isFilled(3, 3));
		assertTrue(b.isFilled(3, 4));
		assertTrue(b.isFilled(4, 0));
		assertTrue(b.isFilled(4, 1));
		assertTrue(b.isFilled(4, 2));
		assertTrue(b.isFilled(4, 3));
		assertTrue(b.isFilled(4, 4));

		b.move('c');
		assertFalse(b.isFilled(0, 0));
		assertTrue(b.isFilled(0, 1));
		assertFalse(b.isFilled(0, 2));
		assertTrue(b.isFilled(0, 3));
		assertTrue(b.isFilled(0, 4));
		assertTrue(b.isFilled(1, 0));
		assertTrue(b.isFilled(1, 1));
		assertFalse(b.isFilled(1, 2));
		assertTrue(b.isFilled(1, 3));
		assertFalse(b.isFilled(1, 4));
		assertTrue(b.isFilled(2, 0));
		assertTrue(b.isFilled(2, 1));
		assertTrue(b.isFilled(2, 2));
		assertFalse(b.isFilled(2, 3));
		assertFalse(b.isFilled(2, 4));
		assertFalse(b.isFilled(3, 0));
		assertFalse(b.isFilled(3, 1));
		assertTrue(b.isFilled(3, 2));
		assertFalse(b.isFilled(3, 3));
		assertTrue(b.isFilled(3, 4));
		assertTrue(b.isFilled(4, 0));
		assertTrue(b.isFilled(4, 1));
		assertTrue(b.isFilled(4, 2));
		assertTrue(b.isFilled(4, 3));
		assertTrue(b.isFilled(4, 4));

		b.move('d');
		assertFalse(b.isFilled(0, 0));
		assertTrue(b.isFilled(0, 1));
		assertFalse(b.isFilled(0, 2));
		assertTrue(b.isFilled(0, 3));
		assertTrue(b.isFilled(0, 4));
		assertTrue(b.isFilled(1, 0));
		assertTrue(b.isFilled(1, 1));
		assertFalse(b.isFilled(1, 2));
		assertTrue(b.isFilled(1, 3));
		assertFalse(b.isFilled(1, 4));
		assertTrue(b.isFilled(2, 0));
		assertTrue(b.isFilled(2, 1));
		assertTrue(b.isFilled(2, 2));
		assertFalse(b.isFilled(2, 3));
		assertFalse(b.isFilled(2, 4));
		assertFalse(b.isFilled(3, 0));
		assertTrue(b.isFilled(3, 1));
		assertFalse(b.isFilled(3, 2));
		assertTrue(b.isFilled(3, 3));
		assertFalse(b.isFilled(3, 4));
		assertTrue(b.isFilled(4, 0));
		assertTrue(b.isFilled(4, 1));
		assertTrue(b.isFilled(4, 2));
		assertTrue(b.isFilled(4, 3));
		assertTrue(b.isFilled(4, 4));

		b.move('e');
		assertFalse(b.isFilled(0, 0));
		assertTrue(b.isFilled(0, 1));
		assertFalse(b.isFilled(0, 2));
		assertTrue(b.isFilled(0, 3));
		assertTrue(b.isFilled(0, 4));
		assertTrue(b.isFilled(1, 0));
		assertTrue(b.isFilled(1, 1));
		assertFalse(b.isFilled(1, 2));
		assertTrue(b.isFilled(1, 3));
		assertFalse(b.isFilled(1, 4));
		assertTrue(b.isFilled(2, 0));
		assertTrue(b.isFilled(2, 1));
		assertTrue(b.isFilled(2, 2));
		assertFalse(b.isFilled(2, 3));
		assertFalse(b.isFilled(2, 4));
		assertFalse(b.isFilled(3, 0));
		assertTrue(b.isFilled(3, 1));
		assertFalse(b.isFilled(3, 2));
		assertTrue(b.isFilled(3, 3));
		assertFalse(b.isFilled(3, 4));
		assertTrue(b.isFilled(4, 0));
		assertTrue(b.isFilled(4, 1));
		assertTrue(b.isFilled(4, 2));
		assertTrue(b.isFilled(4, 3));
		assertTrue(b.isFilled(4, 4));
	}

	@Test
	public void testMoveUp01() {
		Board b = new Board(start);
		b.move('V');
		assertFalse(b.isFilled(0, 0));
		assertFalse(b.isFilled(0, 1));
		assertTrue(b.isFilled(0, 2));
		assertFalse(b.isFilled(0, 3));
		assertTrue(b.isFilled(0, 4));
		assertFalse(b.isFilled(1, 0));
		assertTrue(b.isFilled(1, 1));
		assertTrue(b.isFilled(1, 2));
		assertFalse(b.isFilled(1, 3));
		assertTrue(b.isFilled(1, 4));
		assertFalse(b.isFilled(2, 0));
		assertTrue(b.isFilled(2, 1));
		assertTrue(b.isFilled(2, 2));
		assertTrue(b.isFilled(2, 3));
		assertFalse(b.isFilled(2, 4));
		assertTrue(b.isFilled(3, 0));
		assertFalse(b.isFilled(3, 1));
		assertTrue(b.isFilled(3, 2));
		assertFalse(b.isFilled(3, 3));
		assertTrue(b.isFilled(3, 4));
		assertTrue(b.isFilled(4, 0));
		assertTrue(b.isFilled(4, 1));
		assertTrue(b.isFilled(4, 2));
		assertTrue(b.isFilled(4, 3));
		assertTrue(b.isFilled(4, 4));

		b.move('W');
		assertFalse(b.isFilled(0, 0));
		assertTrue(b.isFilled(0, 1));
		assertTrue(b.isFilled(0, 2));
		assertFalse(b.isFilled(0, 3));
		assertTrue(b.isFilled(0, 4));
		assertFalse(b.isFilled(1, 0));
		assertTrue(b.isFilled(1, 1));
		assertTrue(b.isFilled(1, 2));
		assertFalse(b.isFilled(1, 3));
		assertTrue(b.isFilled(1, 4));
		assertFalse(b.isFilled(2, 0));
		assertFalse(b.isFilled(2, 1));
		assertTrue(b.isFilled(2, 2));
		assertTrue(b.isFilled(2, 3));
		assertFalse(b.isFilled(2, 4));
		assertTrue(b.isFilled(3, 0));
		assertTrue(b.isFilled(3, 1));
		assertTrue(b.isFilled(3, 2));
		assertFalse(b.isFilled(3, 3));
		assertTrue(b.isFilled(3, 4));
		assertTrue(b.isFilled(4, 0));
		assertFalse(b.isFilled(4, 1));
		assertTrue(b.isFilled(4, 2));
		assertTrue(b.isFilled(4, 3));
		assertTrue(b.isFilled(4, 4));

		b.move('X');
		assertFalse(b.isFilled(0, 0));
		assertTrue(b.isFilled(0, 1));
		assertTrue(b.isFilled(0, 2));
		assertFalse(b.isFilled(0, 3));
		assertTrue(b.isFilled(0, 4));
		assertFalse(b.isFilled(1, 0));
		assertTrue(b.isFilled(1, 1));
		assertTrue(b.isFilled(1, 2));
		assertFalse(b.isFilled(1, 3));
		assertTrue(b.isFilled(1, 4));
		assertFalse(b.isFilled(2, 0));
		assertFalse(b.isFilled(2, 1));
		assertTrue(b.isFilled(2, 2));
		assertTrue(b.isFilled(2, 3));
		assertFalse(b.isFilled(2, 4));
		assertTrue(b.isFilled(3, 0));
		assertTrue(b.isFilled(3, 1));
		assertTrue(b.isFilled(3, 2));
		assertFalse(b.isFilled(3, 3));
		assertTrue(b.isFilled(3, 4));
		assertTrue(b.isFilled(4, 0));
		assertFalse(b.isFilled(4, 1));
		assertTrue(b.isFilled(4, 2));
		assertTrue(b.isFilled(4, 3));
		assertTrue(b.isFilled(4, 4));

		b.move('Y');
		assertFalse(b.isFilled(0, 0));
		assertTrue(b.isFilled(0, 1));
		assertTrue(b.isFilled(0, 2));
		assertFalse(b.isFilled(0, 3));
		assertTrue(b.isFilled(0, 4));
		assertFalse(b.isFilled(1, 0));
		assertTrue(b.isFilled(1, 1));
		assertTrue(b.isFilled(1, 2));
		assertTrue(b.isFilled(1, 3));
		assertTrue(b.isFilled(1, 4));
		assertFalse(b.isFilled(2, 0));
		assertFalse(b.isFilled(2, 1));
		assertTrue(b.isFilled(2, 2));
		assertFalse(b.isFilled(2, 3));
		assertFalse(b.isFilled(2, 4));
		assertTrue(b.isFilled(3, 0));
		assertTrue(b.isFilled(3, 1));
		assertTrue(b.isFilled(3, 2));
		assertTrue(b.isFilled(3, 3));
		assertTrue(b.isFilled(3, 4));
		assertTrue(b.isFilled(4, 0));
		assertFalse(b.isFilled(4, 1));
		assertTrue(b.isFilled(4, 2));
		assertFalse(b.isFilled(4, 3));
		assertTrue(b.isFilled(4, 4));

		b.move('Z');
		assertFalse(b.isFilled(0, 0));
		assertTrue(b.isFilled(0, 1));
		assertTrue(b.isFilled(0, 2));
		assertFalse(b.isFilled(0, 3));
		assertTrue(b.isFilled(0, 4));
		assertFalse(b.isFilled(1, 0));
		assertTrue(b.isFilled(1, 1));
		assertTrue(b.isFilled(1, 2));
		assertTrue(b.isFilled(1, 3));
		assertFalse(b.isFilled(1, 4));
		assertFalse(b.isFilled(2, 0));
		assertFalse(b.isFilled(2, 1));
		assertTrue(b.isFilled(2, 2));
		assertFalse(b.isFilled(2, 3));
		assertTrue(b.isFilled(2, 4));
		assertTrue(b.isFilled(3, 0));
		assertTrue(b.isFilled(3, 1));
		assertTrue(b.isFilled(3, 2));
		assertTrue(b.isFilled(3, 3));
		assertTrue(b.isFilled(3, 4));
		assertTrue(b.isFilled(4, 0));
		assertFalse(b.isFilled(4, 1));
		assertTrue(b.isFilled(4, 2));
		assertFalse(b.isFilled(4, 3));
		assertTrue(b.isFilled(4, 4));
	}

	@Test
	public void testMoveDown01() {
		Board b = new Board(start);
		b.move('v');
		assertTrue(b.isFilled(0, 0));
		assertFalse(b.isFilled(0, 1));
		assertTrue(b.isFilled(0, 2));
		assertFalse(b.isFilled(0, 3));
		assertTrue(b.isFilled(0, 4));
		assertTrue(b.isFilled(1, 0));
		assertTrue(b.isFilled(1, 1));
		assertTrue(b.isFilled(1, 2));
		assertFalse(b.isFilled(1, 3));
		assertTrue(b.isFilled(1, 4));
		assertFalse(b.isFilled(2, 0));
		assertTrue(b.isFilled(2, 1));
		assertTrue(b.isFilled(2, 2));
		assertTrue(b.isFilled(2, 3));
		assertFalse(b.isFilled(2, 4));
		assertFalse(b.isFilled(3, 0));
		assertFalse(b.isFilled(3, 1));
		assertTrue(b.isFilled(3, 2));
		assertFalse(b.isFilled(3, 3));
		assertTrue(b.isFilled(3, 4));
		assertFalse(b.isFilled(4, 0));
		assertTrue(b.isFilled(4, 1));
		assertTrue(b.isFilled(4, 2));
		assertTrue(b.isFilled(4, 3));
		assertTrue(b.isFilled(4, 4));

		b.move('w');
		assertTrue(b.isFilled(0, 0));
		assertTrue(b.isFilled(0, 1));
		assertTrue(b.isFilled(0, 2));
		assertFalse(b.isFilled(0, 3));
		assertTrue(b.isFilled(0, 4));
		assertTrue(b.isFilled(1, 0));
		assertFalse(b.isFilled(1, 1));
		assertTrue(b.isFilled(1, 2));
		assertFalse(b.isFilled(1, 3));
		assertTrue(b.isFilled(1, 4));
		assertFalse(b.isFilled(2, 0));
		assertTrue(b.isFilled(2, 1));
		assertTrue(b.isFilled(2, 2));
		assertTrue(b.isFilled(2, 3));
		assertFalse(b.isFilled(2, 4));
		assertFalse(b.isFilled(3, 0));
		assertTrue(b.isFilled(3, 1));
		assertTrue(b.isFilled(3, 2));
		assertFalse(b.isFilled(3, 3));
		assertTrue(b.isFilled(3, 4));
		assertFalse(b.isFilled(4, 0));
		assertFalse(b.isFilled(4, 1));
		assertTrue(b.isFilled(4, 2));
		assertTrue(b.isFilled(4, 3));
		assertTrue(b.isFilled(4, 4));

		b.move('x');
		assertTrue(b.isFilled(0, 0));
		assertTrue(b.isFilled(0, 1));
		assertTrue(b.isFilled(0, 2));
		assertFalse(b.isFilled(0, 3));
		assertTrue(b.isFilled(0, 4));
		assertTrue(b.isFilled(1, 0));
		assertFalse(b.isFilled(1, 1));
		assertTrue(b.isFilled(1, 2));
		assertFalse(b.isFilled(1, 3));
		assertTrue(b.isFilled(1, 4));
		assertFalse(b.isFilled(2, 0));
		assertTrue(b.isFilled(2, 1));
		assertTrue(b.isFilled(2, 2));
		assertTrue(b.isFilled(2, 3));
		assertFalse(b.isFilled(2, 4));
		assertFalse(b.isFilled(3, 0));
		assertTrue(b.isFilled(3, 1));
		assertTrue(b.isFilled(3, 2));
		assertFalse(b.isFilled(3, 3));
		assertTrue(b.isFilled(3, 4));
		assertFalse(b.isFilled(4, 0));
		assertFalse(b.isFilled(4, 1));
		assertTrue(b.isFilled(4, 2));
		assertTrue(b.isFilled(4, 3));
		assertTrue(b.isFilled(4, 4));

		b.move('y');
		assertTrue(b.isFilled(0, 0));
		assertTrue(b.isFilled(0, 1));
		assertTrue(b.isFilled(0, 2));
		assertTrue(b.isFilled(0, 3));
		assertTrue(b.isFilled(0, 4));
		assertTrue(b.isFilled(1, 0));
		assertFalse(b.isFilled(1, 1));
		assertTrue(b.isFilled(1, 2));
		assertFalse(b.isFilled(1, 3));
		assertTrue(b.isFilled(1, 4));
		assertFalse(b.isFilled(2, 0));
		assertTrue(b.isFilled(2, 1));
		assertTrue(b.isFilled(2, 2));
		assertFalse(b.isFilled(2, 3));
		assertFalse(b.isFilled(2, 4));
		assertFalse(b.isFilled(3, 0));
		assertTrue(b.isFilled(3, 1));
		assertTrue(b.isFilled(3, 2));
		assertTrue(b.isFilled(3, 3));
		assertTrue(b.isFilled(3, 4));
		assertFalse(b.isFilled(4, 0));
		assertFalse(b.isFilled(4, 1));
		assertTrue(b.isFilled(4, 2));
		assertFalse(b.isFilled(4, 3));
		assertTrue(b.isFilled(4, 4));

		b.move('z');
		assertTrue(b.isFilled(0, 0));
		assertTrue(b.isFilled(0, 1));
		assertTrue(b.isFilled(0, 2));
		assertTrue(b.isFilled(0, 3));
		assertTrue(b.isFilled(0, 4));
		assertTrue(b.isFilled(1, 0));
		assertFalse(b.isFilled(1, 1));
		assertTrue(b.isFilled(1, 2));
		assertFalse(b.isFilled(1, 3));
		assertTrue(b.isFilled(1, 4));
		assertFalse(b.isFilled(2, 0));
		assertTrue(b.isFilled(2, 1));
		assertTrue(b.isFilled(2, 2));
		assertFalse(b.isFilled(2, 3));
		assertTrue(b.isFilled(2, 4));
		assertFalse(b.isFilled(3, 0));
		assertTrue(b.isFilled(3, 1));
		assertTrue(b.isFilled(3, 2));
		assertTrue(b.isFilled(3, 3));
		assertFalse(b.isFilled(3, 4));
		assertFalse(b.isFilled(4, 0));
		assertFalse(b.isFilled(4, 1));
		assertTrue(b.isFilled(4, 2));
		assertFalse(b.isFilled(4, 3));
		assertTrue(b.isFilled(4, 4));
	}
}
