package CS151.HW3;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Controller {
	
	public static GUI g = null;

	

	public Controller(int arg1, int arg2) {

		
		g = new GUI(arg1, arg2);
		g.showFrame();      //Added an object to call GUI's methods

	}

	public  static void checkWinner() {

		// win at row
		int counter = 0;
		for (int r = 0; r < g.getBoardSize(); r++) //
		{
			for (int c = 0; (c + (g.getWinSequence() - 1)) < g.getBoardSize(); c++) {
				for (int j = 0; j < g.getWinSequence(); j++) // for how many boxes
															// to check around
				{
					if (g.getChess(r,c) == g.getChess(r, c + j) &&

					g.getChess(r, c) == 1)

					{
						counter++;
						continue;

					} else {
						counter = 0;
						break;
					}

				}
				if (counter == g.getWinSequence()) {
					JOptionPane.showMessageDialog(null, g.getPlayer()
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

				for (int j = 0; j < g.getBoardSize(); j++) // for how many boxes
															// to check around
				{
					if (g.getChess(r, c) == g.getChess(r, c + j) &&
					g.getChess(r, c) == 2) {
						counter++;
						continue;
					} else {
						counter = 0;
						break;
					}
				}
				if (counter == g.getWinSequence()) {
					JOptionPane.showMessageDialog(null, g.getPlayer()
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

		// win at column

		for (int r = 0; (r + (g.getWinSequence() - 1)) < g.getBoardSize(); r++) {
			for (int c = 0; c < g.getBoardSize(); c++) {
				for (int j = 0; j < g.getWinSequence(); j++) // for how many boxes
															// to check around
				{
					if (g.getChess(r, c) == g.getChess(r + j, c) &&

					g.getChess(r, c) == 1) {
						counter++;
						continue;
					} else {
						counter = 0;
						break;
					}
				}
				if (counter == g.getWinSequence()) {
					JOptionPane.showMessageDialog(null, g.getPlayer()
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

				for (int j = 0; j < g.getWinSequence(); j++) // for how many boxes
															// to check around
				{
					if (g.getChess(r, c) == g.getChess(r + j, c) &&

					g.getChess(r, c) == 2) {
						counter++;
						continue;
					} else {
						counter = 0;
						break;
					}
				}
				if (counter == g.getWinSequence()) {
					JOptionPane.showMessageDialog(null, g.getPlayer()
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

		// win at upleft-to-downright direction
		for (int r = 0; (r + (g.getWinSequence() - 1)) < g.getBoardSize(); r++) {
			for (int c = 0; (c + (g.getWinSequence() - 1)) < g.getBoardSize(); c++) {
				for (int j = 0; j < g.getWinSequence(); j++) // for how many boxes
															// to check around
				{
					if (g.getChess(r, c) == g.getChess(r + j, c + j) &&

							g.getChess(r, c) == 1) {
						counter++;
						continue;
					} else {
						counter = 0;
						break;
					}
				}
				if (counter == g.getWinSequence()) {
					JOptionPane.showMessageDialog(null, g.getPlayer()
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

				for (int j = 0; j < g.getWinSequence(); j++) // for how many boxes
															// to check around
				{
					if (g.getChess(r, c) == g.getChess(r + j, c + j) &&

							g.getChess(r, c) == 2) {
						counter++;
						continue;
					} else {
						counter = 0;
						break;
					}
				}

				if (counter == g.getWinSequence()) {
					JOptionPane.showMessageDialog(null, g.getPlayer()
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

		// win at downleft-to-upright direction
		for (int r = g.getBoardSize() - 1; (r - (g.getWinSequence() - 1)) >= 0; r--) {
			for (int c = 0; (c + (g.getWinSequence() - 1)) < g.getBoardSize(); c++) {
				for (int j = 0; j < g.getWinSequence(); j++) // for how many boxes
															// to check around
				{
					if (g.getChess(r, c) == g.getChess(r - j, c + j)
							&& g.getChess(r, c) == 1)

					{
						counter++;
						continue;
					} else {
						counter = 0;
						break;
					}
				}
				if (counter == g.getWinSequence()) {
					JOptionPane.showMessageDialog(null, g.getPlayer()
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

				for (int j = 0; j < g.getWinSequence(); j++) // for how many boxes
															// to check around
				{
					if (g.getChess(r, c) == g.getChess(r - j, c + j) &&

							g.getChess(r, c) == 2) {
						counter++;
						continue;
					} else {
						counter = 0;
						break;
					}
				}
				if (counter == g.getWinSequence()) {

					JOptionPane.showMessageDialog(null, g.getPlayer()
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

	// end hasAwinner
	public static void reset() {
		
		for (int i = 0; i < g.getBoardSize(); i++) {
			for (int j = 0; j < g.getBoardSize(); j++) {
				g.setChess(i, j, 0);
			}
		}

		new Controller(g.getBoardSize(), g.getWinSequence());
	}

	public  void isTie() {
		int counter = 0;
		for (int i = 0; i < g.getBoardSize(); i++) {
			for (int j = 0; j < g.getBoardSize(); j++) {
				if(g.getChess(i, j) != 0)
				{
					counter++;
				}
			}
		}
		if(counter == g.getBoardSize()*(g.getBoardSize()))
		{
			int g = JOptionPane.showConfirmDialog(null, "Tie game", "Play again?", JOptionPane.YES_NO_OPTION);
			if (g == JOptionPane.YES_OPTION) {
				reset();
			} else {
				System.exit(0);
			}
		}


	}

}
