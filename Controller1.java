package CS151.HW3;

public class Controller1 {

	
	
	public static int getWinner() {
		// check 4 colors in a row
		for (int row = 0; row < ConnectFour.boardSize; row++) {
			for (int col = 0; col < ConnectFour.boardSize - 3; col++) {
				if (ConnectFour.chess[row][col] != 0
						&& ConnectFour.chess[row][col] == ConnectFour.chess[row][col + 1]
								
						&& ConnectFour.chess[row][col]== ConnectFour.chess[row][col + 2]
								
						&& ConnectFour.chess[row][col] == ConnectFour.chess[row][col + 3]
								) {
					return ConnectFour.chess[row][col];
				}
			}
		}

		// check 4 colors in a column
		for (int row = 0; row < ConnectFour.boardSize - 3; row++) {
			for (int col = 0; col < ConnectFour.boardSize; col++) {
				if (ConnectFour.chess[row][col] == ConnectFour.chess[row + 1][col]
						
						&& ConnectFour.chess[row][col] == ConnectFour.chess[row + 2][col]
								
						&& ConnectFour.chess[row][col] == ConnectFour.chess[row + 3][col]
								
						&& ConnectFour.chess[row][col] != 0) {
					return ConnectFour.chess[row][col];
				}
			}
		}

		// check for 4 colors diagonally
		for (int row = 0; row < ConnectFour.boardSize - 3; row++) {
			for (int col = 0; col < ConnectFour.boardSize - 3; col++) {
				if (ConnectFour.chess[row][col] == ConnectFour.chess[row + 1][col + 1]
						
						&& ConnectFour.chess[row][col] == ConnectFour.chess[row + 2][col + 2]
								
						&& ConnectFour.chess[row][col] == ConnectFour.chess[row + 3][col + 3]
								
						&& ConnectFour.chess[row][col] != 0) {
					return ConnectFour.chess[row][col];
				}
			}
		}
		// check for 4 colors diagonally
		for (int row = 3; row < ConnectFour.boardSize; row++) {
			for (int col = 0; col < ConnectFour.boardSize - 3; col++) {
				if (ConnectFour.chess[row][col] == ConnectFour.chess[row - 1][col + 1]
						
						&& ConnectFour.chess[row][col] == ConnectFour.chess[row - 2][col + 2]
								
						&& ConnectFour.chess[row][col] == ConnectFour.chess[row - 3][col + 3]
								
						&& ConnectFour.chess[row][col] != 0) {
					return ConnectFour.chess[row][col];
				}
			}
		}

		return 0;
	}
}
