package CS151.HW3;



//import java.awt.BorderLayout;
import java.awt.Color;
//import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
//import java.awt.LayoutManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import javax.swing.JOptionPane;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;

public class BoardPanel1 extends JPanel implements MouseListener {
	//private JPanel contentPane;
	BoardPanel1[][] array;
    //int[] colNum;
	boolean gameStart;
	int activeColour = RED;

	public static int MAXROW = 6;
	public static int MAXCOL = MAXROW;
	public static final int BLANK = 0;
	public static final int RED = 1;
	public static final int YELLOW = 2;
	private int rows, cols =0;
	
	boolean end = false;
	private int fillOval = 0;

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
	//	graphics.setColor(Color.CYAN);
		//graphics.fillRect(0, 0, Integer.MAX_VALUE, Integer.MAX_VALUE);
		if (mouseEntered && this.fillOval == 0) {
			if (this.currentPlayer == PLAYER_ONE) {
				// red
				graphics.setColor(Color.RED);
				//setCurrentPlayer(PLAYER_TWO);
			} else if (this.currentPlayer == PLAYER_TWO) {
				// blue
				graphics.setColor(Color.BLUE);
				//setCurrentPlayer(PLAYER_ONE);
			}
		} else {
			if (this.fillOval == PLAYER_ONE) {
				// red
				graphics.setColor(Color.RED);
			} else if (this.fillOval == PLAYER_TWO) {
				// blue
				graphics.setColor(Color.BLUE);
			} else {
				// empty
				graphics.setColor(Color.YELLOW);
			}
		}

		graphics.fillOval(0, 0, 110, 110);
		//checkWinner(graphics);
	}
public int getCurrentPlayer() {
		return currentPlayer;
	}



	public void setCurrentPlayer(int currentPlayer) {
		this.currentPlayer = currentPlayer;
	}
public void removeCurrentP()
{
	this.currentPlayer =  0;
}



public int getfillOval() {
		return fillOval;
	}



	public void setfillOval(int fillOval) {
		this.fillOval = fillOval;
	}
public void removeOval()
{
	this.fillOval = 0;
}

	public boolean checkColumn(int c) // to see if column is full
	{
		boolean check = false;
		
		for(int r = 0; r < MAXROW; r++)
		{
			BoardPanel1 colValue = array[r][c];
			if(colValue.getfillOval() == 0)
			{
				check = true;
				break;
			}
			else if (colValue.getfillOval() == 1 || colValue.getfillOval() == 2)
			{
				check = false;
				break;
			}
				
		}
		return check;
	}
   
	public boolean checkBoard()  // to check if board is full
	{
		boolean check =  false;
		for(int i = 0; i < MAXROW; i++)
		{
			for(int j = 0; j < MAXCOL; j++)
			{
				BoardPanel1 value = array[i][j];
				if(value.getfillOval() != 0)
				{
					check = true;
					break;
				}
				else if(value.getfillOval()  == 0)
				{
					check = false;
					continue;
				}
					
			}
		}
		return check;
	}

	public  void reset() // reset the board
	{
		BoardPanel n = new BoardPanel();
	    for(int i  = 0; i < MAXROW; i++)
	    {
	    	for(int j = 0; j < MAXCOL; j++)
	    	{
	    		BoardPanel1 p = array[i][j];
	    		p.setCurrentPlayer(this.currentPlayer);
	    		p.removeOval();
	    		
	    	}
	    }
	}
	
	private void setNewCurrentPlayer() {
		
		for (int row = 0; row < MAXROW; row++) {
			for (int col = 0; col < MAXCOL; col++) {
				array[row][col].setCurrentPlayer(this.currentPlayer);
				array[row][col].repaint();
			}
		}
	}
	
	public void putDisk(int n) {
		// put a disk on top of column n
		for(int i = MAXROW - 1; i  >= 0; i--)
		{
			BoardPanel1 value = array[i][n];
			if(value.fillOval == 0)
			{
				value.setfillOval(this.currentPlayer);
				if(this.currentPlayer == this.PLAYER_ONE)
				{
					this.currentPlayer = this.PLAYER_TWO;
				}
				else
				{
					this.currentPlayer = this.PLAYER_ONE;
				}
				break;
			}
		}
		this.setNewCurrentPlayer();
		super.repaint();
	}

	public void displayWinner(BoardPanel1 n) {
		//g.setColor(Color.BLACK);
	//	g.setFont(new Font("Courier", Font.BOLD, 100));
		//if (n.getfillOval() == RED)
			//g.drawString("Red wins!", 100, 400);
		//else
		//	g.drawString("Yellow wins!", 100, 400);
		//end = true;
		
		if (n.getfillOval() != 0) {
			if (n.getfillOval() == this.PLAYER_ONE) {
				JOptionPane.showMessageDialog(this,
						"Player One (Red) WINS !! Play again...",
						"Info", JOptionPane.INFORMATION_MESSAGE);
			} else if (n.getfillOval() == this.PLAYER_TWO) {
				JOptionPane.showMessageDialog(this,
						"Player Two (Blue) WINS !! Play again...",
						"Info", JOptionPane.INFORMATION_MESSAGE);
			}
			this.currentPlayer = this.PLAYER_ONE;
			this.reset();
		}
		
	}
	public boolean isVacant()
	{
		boolean  check = true;
		if(this.fillOval == 0)
		{
			check = true;
		}
		else
		{
			check = false;
		}
		return check;
	}

	public void checkWinner() {
		// see if there are 4 disks in a row: horizontal, vertical or diagonal
		// horizontal rows
		for (int row = 0; row < MAXROW; row++) {
			for (int col = 0; col < MAXCOL - 3; col++) {
				BoardPanel1 curr = array[row][col];
				if (curr.getfillOval() > 0 && curr == array[row][col + 1] && curr == array[row][col + 2]
						&& curr == array[row][col + 3]) {
					displayWinner(array[row][col]);
				}
			}
		}
		// vertical columns
		for (int col = 0; col < MAXCOL; col++) {
			for (int row = 0; row < MAXROW - 3; row++) {
				BoardPanel1 curr = array[row][col];
				if (curr.getfillOval() > 0 && curr == array[row + 1][col] && curr == array[row + 2][col]
						&& curr == array[row + 3][col])
					displayWinner(array[row][col]);
			}
		}
		// diagonal lower left to upper right
		for (int row = 0; row < MAXROW - 3; row++) {
			for (int col = 0; col < MAXCOL - 3; col++) {
				BoardPanel1 curr = array[row][col];
				if (curr.getfillOval() > 0 && curr == array[row + 1][col + 1] && curr == array[row + 2][col + 2]
						&& curr == array[row + 3][col + 3])
					displayWinner(array[row][col]);
			}
		}
		// diagonal upper left to lower right
		for (int row = MAXROW - 1; row >= 3; row--) {
			for (int col = 0; col < MAXCOL - 3; col++) {
				BoardPanel1 curr = array[row][col];
				if (curr.getfillOval() > 0 && curr == array[row - 1][col + 1] && curr == array[row - 2][col + 2]
						&& curr == array[row - 3][col + 3])
					displayWinner(array[row][col]);
			}
		}
	} // end check4

	@Override
	public void mousePressed(MouseEvent e) {
		/**if (e.getComponent() instanceof GUI1) {
			BoardPanel1  c  = (BoardPanel1) e.getComponent();

			if(checkColumn(c.getCols()))
			{
				JOptionPane.showMessageDialog(this,
						"Occupied! Choose another column.", "Error",
						JOptionPane.ERROR_MESSAGE);
				super.repaint();
				
			}
			else
			{
				putDisk(c.getCols());
				
			}
		}*/
		

	}

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
		this.mouseEntered = true;
		
	}

	

	@Override
	public void mouseReleased(MouseEvent e) {
		//super.repaint();
		
	}

	

}