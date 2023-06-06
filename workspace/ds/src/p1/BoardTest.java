package p1;

public class BoardTest {
    public static void main(String[] args) {
        boolean[][] a1 = {
                {true, true, true, true, true},
                {true, true, true, false, true},
                {true, false, false, false, true},
                {true, false, false, false, true},
                {true, false, false, true, true}
        };
        
        boolean[][] a2 = {
                {true, true, true, true, true},
                {true, true, true, true, true},
                {true, false, false, false, true},
                {true, false, false, false, true},
                {true, false, false, false, true}
        };

        Board b1 = new Board(a1);
        Board b2 = new Board(a2);
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b1.equals(b2));
    }
}