package p1;

import java.util.Arrays;
import java.util.Random;

public class Board {
    // Remove this and put into game class
    static private int solution; // Caching solution Hash 
    private final String letters = "abcdeABCDEVWXYZvwxyz";

    @FunctionalInterface
    private interface Command {
        void rotate();
    }
    
    private final Command[] commands = {
    () -> { rotate(0, false, 1);},  
      () -> { rotate(1, false, 1);},  
      () -> { rotate(2, false, 1);}, 
      () -> { rotate(3, false, 1);}, 
      () -> { rotate(4, false, 1);},
                               
    () -> { rotate(0, false, 4);}, 
      () -> { rotate(1, false, 4);}, 
      () -> { rotate(2, false, 4);}, 
      () -> { rotate(3, false, 4);}, 
      () -> { rotate(4, false, 4);}, 
    
        // Rotate Colmns 
    () -> { rotate(0, true, 1);}, 
      () -> { rotate(1, true, 1);}, 
      () -> { rotate(2, true, 1);}, 
      () -> { rotate(3, true, 1);}, 
      () -> { rotate(4, true, 1);}, 

    () -> { rotate(0, true, 4);}, 
      () -> { rotate(1, true, 4);}, 
      () -> { rotate(2, true, 4);}, 
      () -> { rotate(3, true, 4);}, 
      () -> { rotate(4, true, 4);} 
    };

    private boolean [][] board; 
    
    private Board()
    {
        this.board = new boolean[][]{ {true,  true,  true,  true, true}, {true, false, false, false, true}, {true, false, false, false, true}, {true, false, false, false, true}, {true,  true,  true,  true, true}}; 

        solution = this.hashCode(); // caching solution
    }

    public Board(int moves) {
        this();
        Random random = new Random();
        do { 
            if (moves == 0) break;

            // Randomize board
            for (int i = 0; i < moves ; i++) {
                this.move(letters.charAt(random.nextInt(20)));
            }
        } while (isSolved());
    }
    
    public Board(boolean[][] b) {
        this();
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                board[i][j] = b[i][j];
            }
        }
    }
    
    public boolean isSolved() {
        return this.hashCode() == solution;
    }

    public void move(char m) {
        Board.Command func = commands[letters.indexOf(m)];

        if (func == null) {
            throw new IllegalArgumentException();   
        }
        func.rotate();
    }

    public boolean isFilled(int row, int col) {
        return board[row][col];
    }

    @Override
    public int hashCode() 
    {
        int k = 1, i, j, len = board.length; 
        for (i = 0; i < len; i++) {
            for (j = 0; j < len; j++){
                k = k << 1 | (board[i][j] ? 1 : 0);
            }
        }
        return k;
    }

    @Override
    public boolean equals(Object o) {
    	if (!(o instanceof Board)) return false;
    	Board that = (Board)o;
    	
        return this.hashCode() == that.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(350);
        s.append("    V   W   X   Y   Z\n");
        s.append("   -------------------\n");
        for (int i = 0, size = 5; i < size; i++) {
            for (int j = 0; j < size; j++){
                if ( j == 0) s.append( letters.charAt(i%5)+ " |");

                if (board[i][j]) s.append(" x |");
                else s.append("   |");

                if (j == 4) s.append(" " + letters.charAt(i%5+5) + "\n");
            }
            s.append("   -------------------\n");
        }
        s.append("    v   w   x   y   z\n");
        return s.toString();
    }
// -------------------------------------------------
//  Private Helper Functions 
// -------------------------------------------------

    private void rotate(int k, boolean t, int n) {
        // 3 left == 1 right hence n moves
        boolean [][] b = board;
        if (t) {
            for (;n > 0;n--) {
                boolean temp = b[0][k];
                for (int i = 0; i<4; i++) {
                    b[i][k] = b[i+1][k];
                }
                b[4][k] = temp;
            }
        } else {
            for (;n > 0;n--) {
                boolean temp = b[k][0];
                for (int i = 0; i<4; i++) {
                    b[k][i] = b[k][i+1];
                }
                b[k][4] = temp;
            }
        }
    }

    

}


