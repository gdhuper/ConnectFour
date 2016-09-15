package CS151.HW3;

import javax.swing.JOptionPane;

public class Controller {
	
	public static Connect4 g = null;
	public static boolean winA = false;
	public static boolean winB = false;
    /**
     * Contructor for controller class to initialize GUI for game
     * @param arg1 the board size
     * @param arg2 the winning sequence
     */
	public Controller(int arg1, int arg2) {
		g = new Connect4(arg1, arg2);
	}
	
	
	/**
	 * Method to check the winner
	 */
	public  static void checkWinner() {
		int counter = 0;
		for (int r = 0; r < g.getBoardSize(); r++)
		{
			for (int c = 0; (c + (g.getWinSequence() - 1)) < g.getBoardSize(); c++) {
				for (int j = 0; j < g.getWinSequence(); j++) 
				{
					if (g.getBoard(r,c) == g.getBoard(r, c + j) &&
					g.getBoard(r, c) == 1)
					{
						counter++;
						continue;
					} 
					else {
						counter = 0;
						break;
					}
				}
				if (counter == g.getWinSequence()) {
					JOptionPane.showMessageDialog(null,"Player " + g.getPlayer()
							+ " is a winner.");
					counter = 0;
				
					int d = JOptionPane.showConfirmDialog(null,
							"Do you wish to replay game?", "Play Again!",
							JOptionPane.YES_NO_OPTION);
					if (d == JOptionPane.YES_OPTION) {
						reset();
					} else {
						System.exit(0);
					}
					
				}
			   

				for (int j = 0; j < g.getWinSequence(); j++) 
				{
					if (g.getBoard(r, c) == g.getBoard(r, c + j) &&
					g.getBoard(r, c) == 2) {
						counter++;
						continue;
					} else {
						counter = 0;
						break;
					}
				}
				if (counter == g.getWinSequence()) {
					JOptionPane.showMessageDialog(null, "Player " + g.getPlayer()
							+ " is a winner.");
					counter = 0;
					
					int q = JOptionPane.showConfirmDialog(null,
							"Do you wish to replay game?", "Play Again!",
							JOptionPane.YES_NO_OPTION);
					if (q == JOptionPane.YES_OPTION) {
						reset();
					} else {
						System.exit(0);
					}
				}
				
			}
		}

		for (int r = 0; (r + (g.getWinSequence() - 1)) < g.getBoardSize(); r++) {
			for (int c = 0; c < g.getBoardSize(); c++) {
				for (int j = 0; j < g.getWinSequence(); j++) 										
				{
					if (g.getBoard(r, c) == g.getBoard(r + j, c) &&
					g.getBoard(r, c) == 1) {
						counter++;
						continue;
					} else {
						counter = 0;
						break;
					}
				}
				if (counter == g.getWinSequence()) {
					JOptionPane.showMessageDialog(null,"Player " + g.getPlayer()
							+ " is a winner.");
					counter = 0;
					
					int d = JOptionPane.showConfirmDialog(null,
							"Do you wish to replay game?", "Play Again!",
							JOptionPane.YES_NO_OPTION);
					if (d == JOptionPane.YES_OPTION) {
						reset();
					} else {
						System.exit(0);
					}
				}
				
				for (int j = 0; j < g.getWinSequence(); j++) 										
				{
					if (g.getBoard(r, c) == g.getBoard(r + j, c) &&

					g.getBoard(r, c) == 2) {
						counter++;
						continue;
					} else {
						counter = 0;
						break;
					}
				}
				if (counter == g.getWinSequence()) {
					JOptionPane.showMessageDialog(null,"Player " + g.getPlayer()
							+ " is a winner.");
					counter = 0;
					
					int e = JOptionPane.showConfirmDialog(null,
							"Do you wish to replay game?", "Play Again!",
							JOptionPane.YES_NO_OPTION);

					if (e == JOptionPane.YES_OPTION) {
						reset();
					} else {
						System.exit(0);
					}
				}
			
			}
		}

		for (int r = 0; (r + (g.getWinSequence() - 1)) < g.getBoardSize(); r++) {
			for (int c = 0; (c + (g.getWinSequence() - 1)) < g.getBoardSize(); c++) {
				for (int j = 0; j < g.getWinSequence(); j++) 
				{
					if (g.getBoard(r, c) == g.getBoard(r + j, c + j) &&
							g.getBoard(r, c) == 1) {
						counter++;
						continue;
					} else {
						counter = 0;
						break;
					}
				}
				if (counter == g.getWinSequence()) {
					JOptionPane.showMessageDialog(null, "Player " + g.getPlayer()
							+ " is a winner.");
					counter = 0;
					
					int d = JOptionPane.showConfirmDialog(null,
							"Do you wish to replay game?", "Play Again!",
							JOptionPane.YES_NO_OPTION);

					if (d == JOptionPane.YES_OPTION) {
						reset();
					} else {
						System.exit(0);
					}
				}
			   

				for (int j = 0; j < g.getWinSequence(); j++)
				{
					if (g.getBoard(r, c) == g.getBoard(r + j, c + j) &&

							g.getBoard(r, c) == 2) {
						counter++;
						continue;
					} else {
						counter = 0;
						break;
					}
				}

				if (counter == g.getWinSequence()) {
					JOptionPane.showMessageDialog(null,"Player " + g.getPlayer()
							+ " is a winner.");
					counter = 0;
					
					int f = JOptionPane.showConfirmDialog(null,
							"Do you wish to replay game?", "Play Again!",
							JOptionPane.YES_NO_OPTION);

					if (f == JOptionPane.YES_OPTION) {
						reset();
					} else {
						System.exit(0);
					}

				}
			   
			}
		}

		for (int r = g.getBoardSize() - 1; (r - (g.getWinSequence() - 1)) >= 0; r--) {
			for (int c = 0; (c + (g.getWinSequence() - 1)) < g.getBoardSize(); c++) {
				for (int j = 0; j < g.getWinSequence(); j++) 
				{
					if (g.getBoard(r, c) == g.getBoard(r - j, c + j)
							&& g.getBoard(r, c) == 1)
					{
						counter++;
						continue;
					} else {
						counter = 0;
						break;
					}
				}
				if (counter == g.getWinSequence()) {
					JOptionPane.showMessageDialog(null,"Player " + g.getPlayer()
							+ " is a winner.");
					counter = 0;
					
					int d = JOptionPane.showConfirmDialog(null,
							"Do you wish to replay game?", "Play Again!",
							JOptionPane.YES_NO_OPTION);

					if (d == JOptionPane.YES_OPTION) {
						reset();
					} else {
						System.exit(0);
					}
				}
				

				for (int j = 0; j < g.getWinSequence(); j++)
				{
					if (g.getBoard(r, c) == g.getBoard(r - j, c + j) &&

							g.getBoard(r, c) == 2) {
						counter++;
						continue;
					} else {
						counter = 0;
						break;
					}
				}
				if (counter == g.getWinSequence()) {

					JOptionPane.showMessageDialog(null,"Player " + g.getPlayer()
							+ " is a winner.");
					counter = 0;
					int h = JOptionPane.showConfirmDialog(null,
							"Do you wish to replay game?", "Play Again!",
							JOptionPane.YES_NO_OPTION);

					if (h == JOptionPane.YES_OPTION) {
						reset();
					} else {
						System.exit(0);
					}
				}

			}
		}
	}

	/**
	 * Resets the board when called. 
	 * Resets the board panels to default
	 */
	public static void reset() {
		g.reset();
		}
    /**
     * Helper method to check if there is a tie between two players
     * resets the board if there is a tie between players
     */
	public static  void isTie() {
		int counter = 0;
		for (int i = 0; i < g.getBoardSize(); i++) {
			for (int j = 0; j < g.getBoardSize(); j++) {
				if(g.getBoard(i, j) != 0)
				{
					counter++;
				}
			}
		}
		if(counter == g.getBoardSize()*(g.getBoardSize()))
		{
			int g = JOptionPane.showConfirmDialog(null, "Tie game, " + "Play again?", "Quit" ,JOptionPane.YES_NO_OPTION);
			if (g == JOptionPane.YES_OPTION) {
				reset();
			} else {
				System.exit(0);
			}
		}


	}

}