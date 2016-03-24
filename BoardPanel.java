package CS151.HW3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.LayoutManager;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class BoardPanel extends JPanel 
{
	private JPanel contentPane;
	int[][] array;
	
	boolean gameStart;
	

	public static  int MAXROW = 9; 
	public static  int MAXCOL = MAXROW;  
	public static final int BLANK = 0;
	public static final int RED = 1;
	public static final int YELLOW = 2;


	/**
	 * Create the panel.
	 */
	public BoardPanel() {
		        contentPane = new JPanel();
		        //contentPane.setBorder(new EmptyBorder(20, 20, 5, 5));
				contentPane.setLayout(new BorderLayout());
				//add(contentPane, BorderLayout.CENTER);
				setMaximumSize(new Dimension(Integer.MAX_VALUE,Integer.MIN_VALUE)); // to set the max size not sure how if works tho 	
				
				//setContentPane(contentPane);
				
			    contentPane.setVisible(true);
			    initialize();
      
	}
	
	public void initialize() {
		array = new int[MAXROW][MAXCOL];
		for (int row = 0; row < MAXROW; row++)
			for (int col = 0; col < MAXCOL; col++)
				array[row][col] = BLANK;
		//gameStart = false;
	}
    /**
     * Override Paint method 
     * @param g
     */
	public void paintComponent(Graphics g) {
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
		} 

}
