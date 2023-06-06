package p2;

public class Board{
		public boolean[][] b;

		private boolean[][] solution = new boolean[][]{ 
			{true, true, true, true,true},
			{true,false,false,false,true},
			{true,false,false,false,true},
			{true,false,false,false,true},
			{true, true, true, true,true}};

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
		public Board(){
			b = new boolean[5][5];
		}

		public Board(boolean [][] board) {
			this();
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
			return this.hashCode() == ((Board)o).hashCode(); }


	}