package CS151.HW3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

/**
 * Creates the GUI for Connect 4 board
 * @author Harkamal Grewal, Gurpreet Singh, Ankit Gandhi
 */
@SuppressWarnings("serial")
public class Connect4 extends JFrame implements MouseListener, ActionListener {

	private JPanel panel_Center;
	protected JPanel[][] buttonsBoard;
	private int boardSize;
	private int winSequence;
	private int[][] board;
	private MenuItem newGame, closeGame, abt;
	private int player = 0;
   
	

    /**
     * Construct a connect Four GUI with the given size and winning sequence.
     * @param boardSize the size of the board
     * @param winSequence the sequence to win by
     */
	public Connect4(int boardSize, int winSequence) {
		this.boardSize = boardSize;
		this.winSequence = winSequence;
		showFrame();
		JOptionPane.showMessageDialog(null, "Welcome to Connect 4: " +
				 "Player 1 is Red and Player 2 is Blue");
		JOptionPane.showMessageDialog(null, "Player 1, You may begin");
	}
   /**
    * Displays the Frame of the Game
    */
	public void showFrame() {
		setTitle("Connect 4");
		setSize(boardSize * 100, boardSize * 100);
		super.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MenuBar menuBar = new MenuBar(); 
		Menu fileMenu = new Menu("File");

		newGame = new MenuItem("New Game");
		newGame.addActionListener(this);
		fileMenu.add(newGame);
		closeGame = new MenuItem("Quit");
		closeGame.addActionListener(this);
		fileMenu.add(closeGame);
		Menu aboutMenu = new Menu("About");
		abt = new MenuItem("About Game");
		abt.addActionListener(this);
		aboutMenu.add(abt);
		fileMenu.addSeparator();
		menuBar.add(fileMenu);
		menuBar.add(aboutMenu);
		setMenuBar(menuBar);

		setLayout(new BorderLayout());
		panel_Center = new JPanel(); 
		panel_Center.setLayout(new GridLayout(boardSize, boardSize, 10, 10));
		panel_Center.setBackground(Color.YELLOW);
		buttonsBoard = new JPanel[boardSize][boardSize];
		board = new int[boardSize][boardSize];

		for (int r = 0; r < boardSize; r++) {
			for (int c = 0; c < boardSize; c++) {
				buttonsBoard[r][c] = new JPanel();
				buttonsBoard[r][c].setBackground(Color.BLACK);

				panel_Center.add(buttonsBoard[r][c]);
				board[r][c] = 0;

				buttonsBoard[r][c].putClientProperty("row", r);
				buttonsBoard[r][c].putClientProperty("col", c);

				buttonsBoard[r][c].addMouseListener(this);
				board[r][c] = 0;
			}
		}

		add(panel_Center, BorderLayout.CENTER);
		panel_Center.repaint();
		setVisible(true);
	}
	
	
	/**
	 * Drops the color in the column when clicked.
	 */

	@Override
	public void mouseClicked(MouseEvent e) {
		JPanel panel = (JPanel) e.getSource();
		//int row = (Integer) panel.getClientProperty("row");
		int col = (Integer) panel.getClientProperty("col");
		Component[] components = panel.getParent().getComponents();
		for (int i = boardSize - 1; i >= 0; i--) {
			if (board[i][col] == 0) {
				if (player == 0 || player == 1) {
					board[i][col] = 1;
					for (Component component : components) {
						JPanel jPanel = (JPanel) component;
						if ((Integer) jPanel.getClientProperty("row") == i
								&& (Integer) jPanel.getClientProperty("col") == col) {
							jPanel.setBackground(Color.RED);
							isTie();
							checkWinner();
							break;
						}
					}
					player = 2;
					break;
				} else {
					board[i][col] = 2;
					for (Component component : components) {
						JPanel jPanel = (JPanel) component;
						if ((Integer) jPanel.getClientProperty("row") == i
								&& (Integer) jPanel.getClientProperty("col") == col) {
							jPanel.setBackground(Color.BLUE);
							isTie();
							checkWinner();
							break;
						}
					}

					player = 1;
					break;
				}
			}
		}

	}
     /**
      * Returns the Board at index[a][b]
      * @param a row index
      * @param b col index
      * @return the int value of the given panel
      */
	public int getBoard(int a, int b) {
		return board[a][b];
	}
    /**
     * 
     * @param a
     * @param b
     * @param zero
     */
	public void setBoard(int a, int b, int zero) {
		this.board[a][b] = zero;
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
			

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == newGame) {
			 Controller.reset();
		} else if (e.getSource() == abt) {
			JOptionPane
					.showMessageDialog(null, "Created by: Harkamal Grewal, Gurpreet Singh, & Ankit Gandhi!");
		} else if (e.getSource() == closeGame) {
			Toolkit.getDefaultToolkit().beep();
			int decision = JOptionPane.showConfirmDialog(null,
					"Are you sure want to quit the game?", "Quit",
					JOptionPane.YES_NO_OPTION);
			if (decision == JOptionPane.YES_OPTION) {
				System.exit(0);
			} else {
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		}
	}
	/**
	 * Helper method to access Check Winner method of Controller class
	 */
	public void checkWinner()
	{
		Controller.checkWinner();
	}
	/**
	 * To check if there is Tie between two players
	 */
	public void isTie()
	{
		Controller.isTie();
	}
	/**
	 * Returns the board size
	 * @return the board size 
	 */
	public int getBoardSize() {
		return boardSize;
	}
   /**
    * Set the board size to a new Size
    * @param boardSize the new size to be set
    */
	public void setBoardSize(int boardSize) {
		this.boardSize = boardSize;
	} 
   /**
    * Return the panel center component
    * @return the panel center component
    */
	public JPanel getPanel_Center() {
		return panel_Center;
	}
   /**
    * Sets the panel center component to a new component
    */
	public void setPanel_Center(JPanel panel_Center) {
		this.panel_Center = panel_Center;
	}
    /**
     * Return the win sequence size
     * @return the win sequence size
     */
	public int getWinSequence() {
		return winSequence;
	}
     /**
      * set the win sequence to a new size
      * @param winSequence the new size of win Sequence
      */
	public void setWinSequence(int winSequence) {
		this.winSequence = winSequence;
	}
     /**
      * Returns the given player
      * @return the current player 
      */
	public int getPlayer() {
		return player;
	}
    /**
     * Sets the new player value to a new value 
     * @param player the new int value
     */
	public void setPlayer(int player) {
		this.player = player;
	}
}
