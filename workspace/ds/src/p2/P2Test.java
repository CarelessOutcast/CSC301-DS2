package p2;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.BeforeClass;


public class P2Test {

	private char[] answerArray;
	private static String[] stringArray;
	private static boolean[][] b;
	private static Solver solver;
	private static final int SIZE = 5;

	@BeforeClass
	public static void setUpClass() {
		solver = new Solver();
		b = new boolean[SIZE][SIZE];
		stringArray = new String[SIZE];
	}


	private void toBooleanArray(boolean[][] B, String[] S) {
		for (int row = 0; row < B.length; row++) {
			for (int col = 0; col < B.length; col++) {
				B[row][col] = S[row].charAt(col) == '*' ? true : false;
			}
		}
	}

	@Test
	public void test00Moves04() {
		stringArray[0] = "*****";
		stringArray[1] = "*   *";
		stringArray[2] = "*   *";
		stringArray[3] = "*   *";
		stringArray[4] = "*****";
		toBooleanArray(b, stringArray);
		answerArray = solver.solve(b);
		assertTrue(answerArray.length == 0);
	}

	@Test
	public void test01Move04() {
		stringArray[0] = "*****";
		stringArray[1] = "*   *";
		stringArray[2] = "**   ";
		stringArray[3] = "*   *";
		stringArray[4] = "*****";
		toBooleanArray(b, stringArray);
		answerArray = solver.solve(b);
		assertTrue(answerArray.length == 1);
		assertTrue(checkSolution(b, answerArray));


		stringArray[0] = "*****";
		stringArray[1] = "*   *";
		stringArray[2] = "*   *";
		stringArray[3] = "   **";
		stringArray[4] = "*****";
		toBooleanArray(b, stringArray);
		answerArray = solver.solve(b);
		assertTrue(answerArray.length == 1);
		assertTrue(checkSolution(b, answerArray));


		stringArray[0] = "*****";
		stringArray[1] = "**  *";
		stringArray[2] = "*   *";
		stringArray[3] = "*   *";
		stringArray[4] = "* ***";
		toBooleanArray(b, stringArray);
		answerArray = solver.solve(b);
		assertTrue(answerArray.length == 1);
		assertTrue(checkSolution(b, answerArray));
		

		stringArray[0] = "*** *";
		stringArray[1] = "*   *";
		stringArray[2] = "*   *";
		stringArray[3] = "*  **";
		stringArray[4] = "*****";
		toBooleanArray(b, stringArray);
		answerArray = solver.solve(b);
		assertTrue(answerArray.length == 1);
		assertTrue(checkSolution(b, answerArray));
	}

	@Test
	public void test02Moves04() {
		stringArray[0] = "*** *";
		stringArray[1] = "*   *";
		stringArray[2] = "*   *";
		stringArray[3] = "  ***";
		stringArray[4] = "*****";
		toBooleanArray(b, stringArray);
		answerArray = solver.solve(b);
		assertTrue(answerArray.length <= 2);
		assertTrue(checkSolution(b, answerArray));


		/********** 17 **********/
		stringArray[0] = "*****";
		stringArray[1] = "**  *";
		stringArray[2] = "   **";
		stringArray[3] = "*   *";
		stringArray[4] = "* ***";
		toBooleanArray(b, stringArray);
		answerArray = solver.solve(b);
		assertTrue(answerArray.length <= 2);
		assertTrue(checkSolution(b, answerArray));


		/********** 32 **********/
		stringArray[0] = "*****";
		stringArray[1] = "*   *";
		stringArray[2] = "**   ";
		stringArray[3] = "   **";
		stringArray[4] = "*****";
		toBooleanArray(b, stringArray);
		answerArray = solver.solve(b);
		assertTrue(answerArray.length <= 2);
		assertTrue(checkSolution(b, answerArray));


		/********** 66 **********/
		stringArray[0] = "*****";
		stringArray[1] = "*  **";
		stringArray[2] = "*   *";
		stringArray[3] = "*   *";
		stringArray[4] = "**** ";
		toBooleanArray(b, stringArray);
		answerArray = solver.solve(b);
		assertTrue(answerArray.length <= 2);
		assertTrue(checkSolution(b, answerArray));

	}

	@Test
	public void test03Moves04() {
		stringArray[0] = "**  *";
		stringArray[1] = "*   *";
		stringArray[2] = "* * *";
		stringArray[3] = "  ***";
		stringArray[4] = "*****";
		toBooleanArray(b, stringArray);
		answerArray = solver.solve(b);
		assertTrue(answerArray.length <= 3);
		assertTrue(checkSolution(b, answerArray));
		
		/********** 243 **********/
		stringArray[0] = "*****";
		stringArray[1] = "*   *";
		stringArray[2] = "   **";
		stringArray[3] = "*  **";
		stringArray[4] = "*** *";
		toBooleanArray(b, stringArray);
		answerArray = solver.solve(b);
		assertTrue(answerArray.length <= 3);
		assertTrue(checkSolution(b, answerArray));
		
		/********** 484 **********/
		stringArray[0] = "*****";
		stringArray[1] = "*** *";
		stringArray[2] = "*    ";
		stringArray[3] = "**  *";
		stringArray[4] = "*  **";
		toBooleanArray(b, stringArray);
		answerArray = solver.solve(b);
		assertTrue(answerArray.length <= 3);
		assertTrue(checkSolution(b, answerArray));
		
		/********** 710 **********/
		stringArray[0] = "*****";
		stringArray[1] = "***  ";
		stringArray[2] = "*    ";
		stringArray[3] = "**  *";
		stringArray[4] = "* ***";
		toBooleanArray(b, stringArray);
		answerArray = solver.solve(b);
		assertTrue(answerArray.length <= 3);
		assertTrue(checkSolution(b, answerArray));
	}
	
	@Test
	public void test04Moves04() {
		/********** 819 **********/
		stringArray[0] = "*****";
		stringArray[1] = "   **";
		stringArray[2] = " *   ";
		stringArray[3] = "**  *";
		stringArray[4] = "*****";
		toBooleanArray(b, stringArray);
		answerArray = solver.solve(b);
		assertTrue(answerArray.length <= 4);
		assertTrue(checkSolution(b, answerArray));
		
		/********** 2579 **********/
		stringArray[0] = "*****";
		stringArray[1] = "    *";
		stringArray[2] = "    *";
		stringArray[3] = "* ***";
		stringArray[4] = "*****";
		toBooleanArray(b, stringArray);
		answerArray = solver.solve(b);
		assertTrue(answerArray.length <= 4);
		assertTrue(checkSolution(b, answerArray));
		
		/********** 3785 **********/
		stringArray[0] = "*****";
		stringArray[1] = "* *  ";
		stringArray[2] = " ** *";
		stringArray[3] = "*   *";
		stringArray[4] = "** **";
		toBooleanArray(b, stringArray);
		answerArray = solver.solve(b);
		assertTrue(answerArray.length <= 4);
		assertTrue(checkSolution(b, answerArray));
		
		/********** 5669 **********/
		stringArray[0] = "*****";
		stringArray[1] = "*    ";
		stringArray[2] = "**  *";
		stringArray[3] = "**  *";
		stringArray[4] = "**** ";
		toBooleanArray(b, stringArray);
		answerArray = solver.solve(b);
		assertTrue(answerArray.length <= 4);
		assertTrue(checkSolution(b, answerArray));
	}
	
	@Test
	public void test05Moves04() {
		/********** 6335 **********/
		stringArray[0] = "** **";
		stringArray[1] = "   **";
		stringArray[2] = "* ** ";
		stringArray[3] = "* * *";
		stringArray[4] = "** **";
		toBooleanArray(b, stringArray);
		answerArray = solver.solve(b);
		assertTrue(answerArray.length <= 5);
		assertTrue(checkSolution(b, answerArray));
		
		/********** 12745 **********/
		stringArray[0] = "*** *";
		stringArray[1] = "***  ";
		stringArray[2] = "  * *";
		stringArray[3] = "*  **";
		stringArray[4] = "** **";
		toBooleanArray(b, stringArray);
		answerArray = solver.solve(b);
		assertTrue(answerArray.length <= 5);
		assertTrue(checkSolution(b, answerArray));
		
		/********** 17843 **********/
		stringArray[0] = "** **";
		stringArray[1] = "**  *";
		stringArray[2] = "***  ";
		stringArray[3] = "*   *";
		stringArray[4] = " ****";
		toBooleanArray(b, stringArray);
		answerArray = solver.solve(b);
		assertTrue(answerArray.length <= 5);
		assertTrue(checkSolution(b, answerArray));
		
		/********** 31590 **********/
		stringArray[0] = "*** *";
		stringArray[1] = "*   *";
		stringArray[2] = " *** ";
		stringArray[3] = "** * ";
		stringArray[4] = "*** *";
		toBooleanArray(b, stringArray);
		answerArray = solver.solve(b);
		assertTrue(answerArray.length <= 5);
		assertTrue(checkSolution(b, answerArray));
	}
	
	@Test
	public void test07Moves04() {
		/********** 81486 **********/
		stringArray[0] = "** * ";
		stringArray[1] = "  ***";
		stringArray[2] = "*  **";
		stringArray[3] = "** * ";
		stringArray[4] = "** **";
		toBooleanArray(b, stringArray);
		answerArray = solver.solve(b);
		assertTrue(answerArray.length <= 7);
		assertTrue(checkSolution(b, answerArray));
		
		/********** 142394 **********/
		stringArray[0] = "**** ";
		stringArray[1] = "***  ";
		stringArray[2] = "* ***";
		stringArray[3] = "*    ";
		stringArray[4] = "** **";
		toBooleanArray(b, stringArray);
		answerArray = solver.solve(b);
		assertTrue(answerArray.length <= 7);
		assertTrue(checkSolution(b, answerArray));
		
		/********** 240338 **********/
		stringArray[0] = "*****";
		stringArray[1] = "**   ";
		stringArray[2] = " ** *";
		stringArray[3] = "***  ";
		stringArray[4] = "  ***";
		toBooleanArray(b, stringArray);
		answerArray = solver.solve(b);
		assertTrue(answerArray.length <= 7);
		assertTrue(checkSolution(b, answerArray));
		
		/********** 341575 **********/
		stringArray[0] = "**** ";
		stringArray[1] = "*** *";
		stringArray[2] = "    *";
		stringArray[3] = "*** *";
		stringArray[4] = "** * ";
		toBooleanArray(b, stringArray);
		answerArray = solver.solve(b);
		assertTrue(answerArray.length <= 7);
		assertTrue(checkSolution(b, answerArray));
	}

	@Test
	public void test10Moves04() {
		/********** 156245 **********/
		stringArray[0] = "* * *";
		stringArray[1] = "**** ";
		stringArray[2] = " *** ";
		stringArray[3] = "* ** ";
		stringArray[4] = "* ** ";
		toBooleanArray(b, stringArray);
		answerArray = solver.solve(b);
		assertTrue(answerArray.length <= 10);
		assertTrue(checkSolution(b, answerArray));
		
		/********** 43705 **********/
		stringArray[0] = "*****";
		stringArray[1] = " *   ";
		stringArray[2] = "* ***";
		stringArray[3] = "**** ";
		stringArray[4] = "  ** ";
		toBooleanArray(b, stringArray);
		answerArray = solver.solve(b);
		assertTrue(answerArray.length <= 10);
		assertTrue(checkSolution(b, answerArray));
		
		/********** 113086 **********/
		stringArray[0] = "  ***";
		stringArray[1] = " *  *";
		stringArray[2] = "*****";
		stringArray[3] = "**** ";
		stringArray[4] = "   **";
		toBooleanArray(b, stringArray);
		answerArray = solver.solve(b);
		assertTrue(answerArray.length <= 10);
		assertTrue(checkSolution(b, answerArray));
		
		/********** 201041 **********/
		stringArray[0] = " *  *";
		stringArray[1] = "* * *";
		stringArray[2] = "**** ";
		stringArray[3] = "**** ";
		stringArray[4] = " *** ";
		toBooleanArray(b, stringArray);
		answerArray = solver.solve(b);
		assertTrue(answerArray.length <= 10);
		assertTrue(checkSolution(b, answerArray));

	}

	@Test
	public void test12Moves04() {
		/********** 5136 **********/
		stringArray[0] = "* *  ";
		stringArray[1] = " *** ";
		stringArray[2] = "*****";
		stringArray[3] = "**** ";
		stringArray[4] = " * * ";
		toBooleanArray(b, stringArray);
		answerArray = solver.solve(b);
		assertTrue(answerArray.length <= 12);
		assertTrue(checkSolution(b, answerArray));
	}

	private boolean checkSolution(boolean[][] board, char[] moves) {
		for (char m : moves) {
			if (m >= 'a' && m <= 'e') {
				int row = m - 'a';
				boolean temp = board[row][0];
				for (int col = 0; col < SIZE - 1; col++)
					board[row][col] = board[row][col + 1];
				board[row][SIZE - 1] = temp;
			} else if (m >= 'A' && m <= 'E') {
				int row = m - 'A';
				boolean temp = board[row][SIZE - 1];
				for (int col = SIZE - 1; col > 0; col--)
					board[row][col] = board[row][col - 1];
				board[row][0] = temp;
			} else if (m >= 'v' && m <= 'z') {
				int col = m - 'v';
				boolean temp = board[SIZE - 1][col];
				for (int row = SIZE - 1; row > 0; row--)
					board[row][col] = board[row - 1][col];
				board[0][col] = temp;
			} else if (m >= 'V' && m <= 'Z') {
				int col = m - 'V';
				boolean temp = board[0][col];
				for (int row = 0; row < SIZE - 1; row++)
					board[row][col] = board[row + 1][col];
				board[SIZE - 1][col] = temp;
			} else {
				throw new IllegalArgumentException("Illegal move: " + m);
			}
		}
		for(int row = 0; row < 5; row++) {
			for(int col = 0; col < 5; col++) {
				if (row == 0 || col == 0 || row == 4 || col == 4) {
					if (!board[row][col])
						return false;
				} else {
					if (board[row][col])
						return false;
				}
			}
		}
		return true;
	}
}
