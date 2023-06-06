package p2;

import java.util.Arrays;
import java.util.HashMap;
//import java.util.PriorityQueue;

import edu.princeton.cs.algs4.*;

public class Solver {
	private static final int SIZE = 2097152; // HashMaps
	private static final String moves = "abcdeABCDEVWXYZvwxyz";

	HashMap<Board, Board> edgeTo;

	private Board solution = new Board( new boolean[][]{ 
		{true, true, true, true,true},
		{true,false,false,false,true},
		{true,false,false,false,true},
		{true,false,false,false,true},
		{true, true, true, true,true}});


	private StringBuilder answer;
	// This constructor is called once to create a Solver object.
	// My tests will then use that one Solver object to solve many puzzles.
	// The most direct/intuitive solution leaves this constrctor blank.
	// However, adding some "preprocessing" code to this constructor
	// that executes before any puzzles are solved could potentially
	// speed up your solve method.

	public Solver() { 
    	Queue<Board> queue = new Queue<>();

		edgeTo = new HashMap<>(SIZE);		

    	char move;

		edgeTo.put(solution, null);
		queue.enqueue(solution);

		while (!queue.isEmpty()){
			
			Board b = queue.dequeue();

			for (int i = 0; i < 20; i++) {
				move = moves.charAt(i);
				
				Board bp = new Board(b.b); 
				bp.move(move);

				if (!edgeTo.containsKey(bp)) {
					edgeTo.put(bp, b);
					queue.enqueue(bp);
				}
			}
		}
    }
	
	/**
	 * Solves a given puzzle represented as a 5-by-5 boolean array with
	 * 16 trues and 9 falses.
	 * @param start the intial puzzle/board configuration
	 * @return the sequence of moves that solves the puzzle.
	 */
    public char[] solve(boolean[][] s) {
		answer = new StringBuilder();

		Board x, prevBoard;
		Board solve = new Board(s);

		for (x = solve; edgeTo.get(x) != null; x = edgeTo.get(x)) {
			prevBoard = edgeTo.get(x);
			answer.append(x.getMove(prevBoard));
		}
		
		return answer.toString().trim().toCharArray();
	}


	// A simple toy example of how a Solver object is used.
	public static void main(String[] args) {
		boolean[][] bb = {
				{ true,  true,  true,  true,  true},
				{false,  true,  true, false, false},
				{ true, false, false, false,  true},
				{ true, false, false, false,  true},
				{ true,  true,  true,  true,  true}
		};
		
		boolean[][] Xbb = {
				{ true,  true,  true,  true,  true},
				{false,  true,  true, false, false},
				{ true, false,  true, false,  true},
				{ true, false, false, false,  true},
				{ true,  true, false,  true,  true}
		};
		
		Solver solver = new Solver();

		char[] sol = solver.solve(bb);
		System.out.println(Arrays.toString(sol));
		sol = solver.solve(Xbb);
		System.out.println(Arrays.toString(sol));
	}
	
	
	/**
	---Board class--------------------------------------
	*/
	private class Board {
		private boolean[][] b;
		
		public void move(char m) {
			if 		(m == 'a') {rotate(0, false, 1);}
			else if (m == 'b') {rotate(1, false, 1);}
			else if (m == 'c') {rotate(2, false, 1);}
			else if (m == 'd') {rotate(3, false, 1);}
			else if (m == 'e') {rotate(4, false, 1);}

			else if (m == 'A') {rotate(0, false, 4);}
			else if (m == 'B') {rotate(1, false, 4);}
			else if (m == 'C') {rotate(2, false, 4);}
			else if (m == 'D') {rotate(3, false, 4);}
			else if (m == 'E') {rotate(4, false, 4);}

			else if (m == 'V') {rotate(0, true, 1);}
			else if (m == 'W') {rotate(1, true, 1);}
			else if (m == 'X') {rotate(2, true, 1);}
			else if (m == 'Y') {rotate(3, true, 1);}
			else if (m == 'Z') {rotate(4, true, 1);}

			else if (m == 'v') {rotate(0, true, 4);}
			else if (m == 'w') {rotate(1, true, 4);}
			else if (m == 'x') {rotate(2, true, 4);}
			else if (m == 'y') {rotate(3, true, 4);}
			else if (m == 'z') {rotate(4, true, 4);}
		}

		public Board(boolean [][] board) {
			b = new boolean[5][5];

			int len = 5;
			for (int i = 0; i<len; i++){ 
				for(int j = 0; j<len; j++){
					b[i][j] = board[i][j];
				}
			}
		}

		public boolean isSolved() {
			return this.equals(solution);
		}

		public char getMove(Board board) {
			// calculate how to get to this board;
			char move = ' ';
			for (int i = 0, len = moves.length(); i < len; i++) {
				Board bp = new Board(this.b);
				move = moves.charAt(i);
				bp.move(move);
				if (bp.equals(board)) {
					break;
				}
			}
			return move;
		}


		private void rotate(int k, boolean t, int n) {
			if (t) {
				// 4 left == 1 right shift
				for (;n > 0; n--) {
					boolean temp = b[0][k];
					for (int i = 0; i<4; i++) {
						b[i][k] = b[i+1][k];
					}
					b[4][k] = temp;
				}
			} else {
				for (;n > 0; n--) {
					boolean temp = b[k][0];
					// rotate rows
					for (int i = 0; i<4; i++) {
						b[k][i] = b[k][i+1];
					}
					b[k][4] = temp;
				}
			}
		}
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(350);
        s.append(" \n");
        s.append(" -------------------\n");
        for (int i = 0, size = 5; i < size; i++) {
            for (int j = 0; j < size; j++){
                if ( j == 0) s.append(" |");

                if (b[i][j]) s.append(" x |");
                else s.append("   |");

                if (j == 4) s.append(" \n");
            }
            s.append(" -------------------\n");
        }
        s.append(" \n");
        return s.toString();
    }

		@Override
		public int hashCode() {
			int k = 1,len = 5; 
			for (int i = 0; i < len; i++) {
				for (int j = 0; j < len; j++){
					k = k << 1 | (b[i][j] ? 1 : 0);
				}
			}
			return k;
		}
		@Override
		public boolean equals(Object o) {
			if (!(o instanceof Board)) return false;
				return this.hashCode()  == ((Board)o).hashCode();  
			}

	}
}
