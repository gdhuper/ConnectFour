package CS151.HW3;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class BoardPanel1 extends JPanel implements MouseListener {
	//private JPanel contentPane;
	int[][] array;
    int[] colNum;
	boolean gameStart;
	int activeColour = RED;

	public static int MAXROW = 7;
	public static int MAXCOL = MAXROW;
	public static final int BLANK = 0;
	public static final int RED = 1;
	private int rows, cols =0;
	public static final int YELLOW = 2;
	boolean end = false;
	private int lockPlayer = 0;

	public static final int PLAYER_ONE = 1;
	public static final int PLAYER_TWO = 2;

	private int currentPlayer = PLAYER_ONE;
	private boolean mouseEntered = false;
	

	/**
	 * Create the panel.
	 */
	public BoardPanel1(int row, int col) {
	     
	   //	contentPane = new JPanel();
		// contentPane.setBorder(new EmptyBorder(20, 20, 5, 5));
		//contentPane.setLayout(new BorderLayout());
		// add(contentPane, BorderLayout.CENTER);
	//	setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MIN_VALUE)); 
		// setContentPane(contentPane);
        //super();
        this.rows = row;
        this.cols = col;
		
		super.addMouseListener(this);
		//super.setVisible(true);
		

	}

	

	/**
	 * Override Paint method
	 * 
	 * @param g
	 */
	/**public void paintComponent(Graphics g) {
		g.setColor(Color.CYAN);

		g.fillRect(0, 0, Integer.MAX_VALUE, Integer.MAX_VALUE);
		for (int row = 0; row < MAXROW; row++)
			for (int col = 0; col < MAXCOL; col++) {
				g.setColor(Color.YELLOW);
				if (array[row][col] == BLANK)
					g.setColor(Color.WHITE);
				if (array[row][col] == RED)
					g.setColor(Color.RED);
				if (array[row][col] == YELLOW)
					g.setColor(Color.YELLOW);
				g.fillOval(200 + 100 * col, 50 + 100 * row, 100, 100);

			}
	}*/
	public void paintComponent(Graphics graphics) {
		if (mouseEntered && this.lockPlayer == 0) {
			if (this.currentPlayer == PLAYER_ONE) {
				// red
				graphics.setColor(Color.RED);
				setCurrentPlayer(PLAYER_TWO);
			} else if (this.currentPlayer == PLAYER_TWO) {
				// blue
				graphics.setColor(Color.BLUE);
				//setCurrentPlayer(PLAYER_ONE);
			}
		} else {
			if (this.lockPlayer == PLAYER_ONE) {
				// red
				graphics.setColor(Color.RED);
			} else if (this.lockPlayer == PLAYER_TWO) {
				// blue
				graphics.setColor(Color.BLUE);
			} else {
				// empty
				graphics.setColor(Color.YELLOW);
			}
		}

		graphics.fillOval(0, 0, 70, 70);
	}
public int getCurrentPlayer() {
		return currentPlayer;
	}



	public void setCurrentPlayer(int currentPlayer) {
		this.currentPlayer = currentPlayer;
	}



public int getLockPlayer() {
		return lockPlayer;
	}



	public void setLockPlayer(int lockPlayer) {
		this.lockPlayer = lockPlayer;
	}



/**	public static void reset()
	{
		BoardPanel n = new BoardPanel();
		n.setVisible(true);
	}*/
	
	public void putDisk(int n) {
		// put a disk on top of column n
		// if game is won, do nothing
		if (end)
			return;
		gameStart = true;
		int row;
		n--;
		for (row = 0; row < MAXROW; row++)
			if (array[row][n] > 0)
				break;
		if (row > 0) {
			array[--row][n] = activeColour;
			if (activeColour == RED)
				activeColour = YELLOW;
			else
				activeColour = RED;
			repaint();
		}
	}

	public void displayWinner(Graphics g, int n) {
		g.setColor(Color.BLACK);
		g.setFont(new Font("Courier", Font.BOLD, 100));
		if (n == RED)
			g.drawString("Red wins!", 100, 400);
		else
			g.drawString("Yellow wins!", 100, 400);
		end = true;
	}

	public void check4(Graphics g) {
		// see if there are 4 disks in a row: horizontal, vertical or diagonal
		// horizontal rows
		for (int row = 0; row < MAXROW; row++) {
			for (int col = 0; col < MAXCOL - 3; col++) {
				int curr = array[row][col];
				if (curr > 0 && curr == array[row][col + 1] && curr == array[row][col + 2]
						&& curr == array[row][col + 3]) {
					displayWinner(g, array[row][col]);
				}
			}
		}
		// vertical columns
		for (int col = 0; col < MAXCOL; col++) {
			for (int row = 0; row < MAXROW - 3; row++) {
				int curr = array[row][col];
				if (curr > 0 && curr == array[row + 1][col] && curr == array[row + 2][col]
						&& curr == array[row + 3][col])
					displayWinner(g, array[row][col]);
			}
		}
		// diagonal lower left to upper right
		for (int row = 0; row < MAXROW - 3; row++) {
			for (int col = 0; col < MAXCOL - 3; col++) {
				int curr = array[row][col];
				if (curr > 0 && curr == array[row + 1][col + 1] && curr == array[row + 2][col + 2]
						&& curr == array[row + 3][col + 3])
					displayWinner(g, array[row][col]);
			}
		}
		// diagonal upper left to lower right
		for (int row = MAXROW - 1; row >= 3; row--) {
			for (int col = 0; col < MAXCOL - 3; col++) {
				int curr = array[row][col];
				if (curr > 0 && curr == array[row - 1][col + 1] && curr == array[row - 2][col + 2]
						&& curr == array[row - 3][col + 3])
					displayWinner(g, array[row][col]);
			}
		}
	} // end check4

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getComponent() instanceof GUI) {
			BoardPanel1  c  = (BoardPanel1) e.getComponent();

			
				putDisk(c.getCols());
		}

				//int winner = getWinner();

				/**if (winner != 0) {
					if (winner == this.PLAYER_ONE) {
						JOptionPane.showMessageDialog(this,
								"Player One (Red) WINS !! Play again...",
								"Info", JOptionPane.INFORMATION_MESSAGE);
					} else if (winner == this.PLAYER_TWO) {
						JOptionPane.showMessageDialog(this,
								"Player Two (Blue) WINS !! Play again...",
								"Info", JOptionPane.INFORMATION_MESSAGE);
					}

					this.currentPlayer = this.PLAYER_ONE;
					this.resetBoard();
				}

				this.resetBoardIfFull();
			}
		}*/
	}


	/**private boolean isColumnFull(int col) {
		boolean full = true;

		for (int x = 0; x < MAXROW; x++) {
			if (!array[x][col].isOccupied()) {
				full = false;
				break;
			}
		}

		return full;
	}*/

	public int getRows() {
		return rows;
	}



	public int getCols() {
		return cols;
	}




	
		
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		super.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		//super.repaint();
		this.mouseEntered =true;
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		//super.repaint();
		
	}

	

	@Override
	public void mouseReleased(MouseEvent e) {
		//super.repaint();
		
	}

	

}