package CS151.HW3;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Controller extends JPanel {

	public static void main(String[] args) {
		// int size = Integer.parseInt(args[0]);
		// if(size > 50)
		// {

		// JOptionPane.showMessageDialog(null,
		// "Sorry! Please select a size under 50");
		// }
		// int winS = Integer.parseInt(args[1]);
		// if(winS > size)
		// {
		// JOptionPane.showMessageDialog(null,
		// "Sorry! Winning sequence should be less than board size");
		// }

		// new ConnectFour(Integer.parseInt(args[0]));

		new Controller(Integer.parseInt(args[0]), Integer.parseInt(args[1]));

	}

	public Controller(int arg1, int arg2) {

		new GUI(arg1, arg2);

	}

	public static void checkWinner() {

		// win at row
		int counter = 0;
		for (int r = 0; r < GUI.boardSize; r++) //
		{
			for (int c = 0; (c + (GUI.winSequence - 1)) < GUI.boardSize; c++) {
				for (int j = 0; j < GUI.winSequence; j++) // for how many boxes
															// to check around
				{
					if (GUI.chess[r][c] == GUI.chess[r][c + j] &&

					GUI.chess[r][c] == 1)

					{
						counter++;
						continue;

					} else {
						counter = 0;
						break;
					}

				}
				if (counter == GUI.winSequence) {
					JOptionPane.showMessageDialog(null, GUI.player
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

				for (int j = 0; j < GUI.winSequence; j++) // for how many boxes
															// to check around
				{
					if (GUI.chess[r][c] == GUI.chess[r][c + j] &&

					GUI.chess[r][c] == 2) {
						counter++;
						continue;
					} else {
						counter = 0;
						break;
					}
				}
				if (counter == GUI.winSequence) {
					JOptionPane.showMessageDialog(null, GUI.player
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

		for (int r = 0; (r + (GUI.winSequence - 1)) < GUI.boardSize; r++) {
			for (int c = 0; c < GUI.boardSize; c++) {
				for (int j = 0; j < GUI.winSequence; j++) // for how many boxes
															// to check around
				{
					if (GUI.chess[r][c] == GUI.chess[r + j][c] &&

					GUI.chess[r][c] == 1) {
						counter++;
						continue;
					} else {
						counter = 0;
						break;
					}
				}
				if (counter == GUI.winSequence) {
					JOptionPane.showMessageDialog(null, GUI.player
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

				for (int j = 0; j < GUI.winSequence; j++) // for how many boxes
															// to check around
				{
					if (GUI.chess[r][c] == GUI.chess[r + j][c] &&

					GUI.chess[r][c] == 2) {
						counter++;
						continue;
					} else {
						counter = 0;
						break;
					}
				}
				if (counter == GUI.winSequence) {
					JOptionPane.showMessageDialog(null, GUI.player
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
		for (int r = 0; (r + (GUI.winSequence - 1)) < GUI.boardSize; r++) {
			for (int c = 0; (c + (GUI.winSequence - 1)) < GUI.boardSize; c++) {
				for (int j = 0; j < GUI.winSequence; j++) // for how many boxes
															// to check around
				{
					if (GUI.chess[r][c] == GUI.chess[r + j][c + j] &&

					GUI.chess[r][c] == 1) {
						counter++;
						continue;
					} else {
						counter = 0;
						break;
					}
				}
				if (counter == GUI.winSequence) {
					JOptionPane.showMessageDialog(null, GUI.player
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

				for (int j = 0; j < GUI.winSequence; j++) // for how many boxes
															// to check around
				{
					if (GUI.chess[r][c] == GUI.chess[r + j][c + j] &&

					GUI.chess[r][c] == 2) {
						counter++;
						continue;
					} else {
						counter = 0;
						break;
					}
				}

				if (counter == GUI.winSequence) {
					JOptionPane.showMessageDialog(null, GUI.player
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
		for (int r = GUI.boardSize - 1; (r - (GUI.winSequence - 1)) >= 0; r--) {
			for (int c = 0; (c + (GUI.winSequence - 1)) < GUI.boardSize; c++) {
				for (int j = 0; j < GUI.winSequence; j++) // for how many boxes
															// to check around
				{
					if (GUI.chess[r][c] == GUI.chess[r - j][c + j]
							&& GUI.chess[r][c] == 1)

					{
						counter++;
						continue;
					} else {
						counter = 0;
						break;
					}
				}
				if (counter == GUI.winSequence) {
					JOptionPane.showMessageDialog(null, GUI.player
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

				for (int j = 0; j < GUI.winSequence; j++) // for how many boxes
															// to check around
				{
					if (GUI.chess[r][c] == GUI.chess[r - j][c + j] &&

					GUI.chess[r][c] == 2) {
						counter++;
						continue;
					} else {
						counter = 0;
						break;
					}
				}
				if (counter == GUI.winSequence) {

					JOptionPane.showMessageDialog(null, GUI.player
							+ " is a winner.");
					counter = 0;
					int g = JOptionPane.showConfirmDialog(null,
							"Do you wish to replay game?", "Play Again!",
							JOptionPane.YES_NO_OPTION);

					if (g == JOptionPane.YES_OPTION) {
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
		Component[] components = GUI.panel_Center.getComponents();
		for (Component component : components) {
			JPanel j = (JPanel) component;
			j.setBackground(Color.BLACK);
		}
		for (int i = 0; i < GUI.boardSize; i++) {
			for (int j = 0; j < GUI.boardSize; j++) {
				GUI.chess[i][j] = 0;
			}
		}

		GUI.player = 2;
	}

	public static void isTie() {
		int counter = 0;
		for (int i = 0; i < GUI.boardSize; i++) {
			for (int j = 0; j < GUI.boardSize; j++) {
				if(GUI.chess[i][j] != 0)
				{
					counter++;
				}
			}
		}
		if(counter == GUI.boardSize*(GUI.boardSize))
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
