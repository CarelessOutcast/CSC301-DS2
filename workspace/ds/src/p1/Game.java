package p1;

import java.util.Scanner;
import java.util.HashSet;

public class Game {
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
		HashSet<Board> states = new HashSet<Board>(2097152); // History Tracking with Hash values

        Board board;
        char move;

        while (true)
        {
            // ask for difficulty
            System.out.print("Please select a difficulty (1-9): ");
            int difficulty = input.nextInt();
    
            board = new Board(difficulty);
            states.add(board);

            while (true) {
				printBoard(board);

				move = promptInput("Please select a move character: ", input);
                board.move(move);

                if (states.contains(board) || board.isSolved()) break; 
                states.add(board);
            } 

			printBoard(board);
            
            if (!board.isSolved()) 
                System.out.println("\n\tYou Lost :( ");
            else 
                System.out.println("\n\tYou Won! :) ");

			move = promptInput("\n  Would you like to play again? ", input);

            if (move == 'n') {
                System.out.println("\n  Thanks for playing! \n");
                break;
            }
        }
        input.close();
        return;

	}

	public static void printBoard(Board b) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println(b.toString());
	}
    public static char promptInput(String s, Scanner sc)
    {
		System.out.println(s);
		char m = sc.next().charAt(0);
		return m;
    }
}

