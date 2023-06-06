package p2;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.BeforeClass;


public class P2TestTiming {

	private char[] answerArray;
	private static String[] stringArray;
	private static boolean[][] b;
	private static Solver solver;
	private static final int SIZE = 5;

	@BeforeClass
	public static void setUpClass() {
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
	public void testTiming() {
		long start;
		long finish;
		double time;
		
		start = System.currentTimeMillis();
		solver = new Solver();
		
		/********** 286 **********/
		stringArray[0] = "  ** ";
		stringArray[1] = "**** ";
		stringArray[2] = "*****";
		stringArray[3] = "**** ";
		stringArray[4] = "   * ";
		toBooleanArray(b, stringArray);
		answerArray = solver.solve(b);
		assertTrue(answerArray.length <= 13);
		assertTrue(checkSolution(b, answerArray));
		
		/********** 541 **********/
		stringArray[0] = " * * ";
		stringArray[1] = "*****";
		stringArray[2] = " *** ";
		stringArray[3] = "**** ";
		stringArray[4] = " * * ";
		toBooleanArray(b, stringArray);
		answerArray = solver.solve(b);
		assertTrue(answerArray.length <= 13);
		assertTrue(checkSolution(b, answerArray));
		
		/********** 690 **********/
		stringArray[0] = "  *  ";
		stringArray[1] = " ****";
		stringArray[2] = "*****";
		stringArray[3] = "**** ";
		stringArray[4] = " **  ";
		toBooleanArray(b, stringArray);
		answerArray = solver.solve(b);
		assertTrue(answerArray.length <= 13);
		assertTrue(checkSolution(b, answerArray));
		
		/********** 944 **********/
		stringArray[0] = "     ";
		stringArray[1] = " ****";
		stringArray[2] = "*****";
		stringArray[3] = "**** ";
		stringArray[4] = " *** ";
		toBooleanArray(b, stringArray);
		answerArray = solver.solve(b);
		assertTrue(answerArray.length <= 13);
		assertTrue(checkSolution(b, answerArray));
		
		finish = System.currentTimeMillis();
		time = (finish-start) / 1000.0;
		System.out.println("time taken:  " + time + " seconds");
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
