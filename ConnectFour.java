package CS151.HW3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ConnectFour extends JFrame implements MouseListener, ActionListener{

	private JPanel panel_Center;
	protected JPanel[][] buttonsBoard;
	public static int boardSize = 7;
	public static int [][] chess;
	//private static final Graphics Graphics = null;
	private MenuItem newGame, closeGame, abt;
	private int player = 0;
	
	/**
	 * Launch the application.
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws MalformedURLException 
	{
		//boardSize = Integer.parseInt(args[0]);
		new ConnectFour();
	}

	public ConnectFour() throws MalformedURLException
	{
	     showFrame();
	     JOptionPane.showMessageDialog(null,"Welcome to Connect 4");
	    // JOptionPane.showMessageDialog(this, "Welcome to Connect Four!", "Duh", JOptionPane.INFORMATION_MESSAGE);
	}

public void showFrame() throws MalformedURLException
{
	JWindow window = new JWindow();
	window.getContentPane().add(
	    new JLabel("", new ImageIcon(new URL("http://docs.oracle.com/javase/tutorial/uiswing/examples/misc/SplashDemoProject/src/misc/images/splash.gif")), SwingConstants.CENTER));
	window.setSize(boardSize*100, boardSize*100);
	window.setVisible(true);
	try {
	    Thread.sleep(5000);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	window.setVisible(false);
     setTitle("Connect 4");
     setSize( boardSize*100,boardSize*100);
     super.setLocationRelativeTo(null);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
     MenuBar menuBar = new MenuBar(); //For the menu on top 
		
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
	//JMenuItem closeItem = fileMenu.add("Close");
	 fileMenu.addSeparator();
	 menuBar.add(fileMenu); 
	 menuBar.add(aboutMenu);
	 setMenuBar(menuBar);
     
   
     
    setLayout(new BorderLayout());
    panel_Center=new JPanel();  //show the board
    panel_Center.setLayout(new GridLayout(boardSize,boardSize,10,10));
    panel_Center.setBackground(Color.YELLOW);
    buttonsBoard=new JPanel[boardSize][boardSize];
    chess=new int[boardSize][boardSize];
        
     for (int r=0; r<boardSize;r++)
     {
    	for (int c=0;c<boardSize;c++)
            {
                buttonsBoard[r][c]=new JPanel();
               buttonsBoard[r][c].setBackground(Color.GRAY);
               
                panel_Center.add(buttonsBoard[r][c]);
                chess[r][c] = 0;
                
                buttonsBoard[r][c].putClientProperty("row", r);
                buttonsBoard[r][c].putClientProperty("col", c);
                
                buttonsBoard[r][c].addMouseListener(this);
                //buttonsBoard[r][c].addActionListener(new mybuttonsBoard());//add actionListener
                chess[r][c]=0;	
            }
         }

    add(panel_Center,BorderLayout.CENTER);
    panel_Center.repaint();
    setVisible(true);
	}

	
	public void mousePressed(MouseEvent e)
	{
		
	}

	@Override
	public void mouseClicked(MouseEvent e) 
	{
		JPanel panel = (JPanel) e.getSource();
		int 
		row = (Integer)panel.getClientProperty("row");
		int col =  (Integer)panel.getClientProperty("col");
		Component[] components = panel.getParent().getComponents();
		for(int i=boardSize-1; i>=0; i-- ) {
			if(chess[i][col] == 0) {
				if(player == 0 || player == 1) {
					chess[i][col] = 1;
					for(Component component: components) {
						JPanel jPanel = (JPanel)component;
						if((Integer)jPanel.getClientProperty("row") == i && (Integer)jPanel.getClientProperty("col") == col ) {
							jPanel.setBackground(Color.RED);
							player=2;
							int w = getWinner();
							if(w != 0)
							{
								if(w == player)
								{
									JOptionPane.showMessageDialog(this, "Red Wins");
								}
								
							}
							break;
						}
					}
					player=2;
					break;
				} else {
					chess[i][col] = 2;
					for(Component component: components) {
						JPanel jPanel = (JPanel)component;
						if((Integer)jPanel.getClientProperty("row") == i && (Integer)jPanel.getClientProperty("col") == col ) {
							jPanel.setBackground(Color.BLUE);
							player=1;
							int w = getWinner();
							if(w != 0)
							{
								if(w == player)
								{
									JOptionPane.showMessageDialog(this, "Blue Wins");
								}
								
							}
							break;
						}
					}
					
					player=1;
					int w = getWinner();
					if(w != 0)
					{
						if(w == player)
						{
							JOptionPane.showMessageDialog(this, "Red Wins");
						}
						
					}
					
					break;
				}
			}
		}
	}
			
			public int getWinner() {
				// check 4 colors in a row
				for (int row = 0; row < boardSize; row++) {
					for (int col = 0; col < boardSize - 3; col++) {
						if (chess[row][col] != 0
								&& chess[row][col] == chess[row][col + 1]
										
								&& chess[row][col]== chess[row][col + 2]
										
								&& chess[row][col] == chess[row][col + 3]
										) {
							return chess[row][col];
						}
					}
				}

				// check 4 colors in a column
				for (int row = 0; row < boardSize - 3; row++) {
					for (int col = 0; col < boardSize; col++) {
						if (chess[row][col] == chess[row + 1][col]
								
								&& chess[row][col] == chess[row + 2][col]
										
								&& chess[row][col] == chess[row + 3][col]
										
								&& chess[row][col] != 0) {
							return chess[row][col];
						}
					}
				}

				// check for 4 colors diagonally
				for (int row = 0; row < boardSize - 3; row++) {
					for (int col = 0; col < boardSize - 3; col++) {
						if (chess[row][col] == chess[row + 1][col + 1]
								
								&& chess[row][col] == chess[row + 2][col + 2]
										
								&& chess[row][col] == chess[row + 3][col + 3]
										
								&& chess[row][col] != 0) {
							return chess[row][col];
						}
					}
				}
				// check for 4 colors diagonally
				for (int row = 3; row < boardSize; row++) {
					for (int col = 0; col < boardSize - 3; col++) {
						if (chess[row][col] == chess[row - 1][col + 1]
								
								&& chess[row][col] == chess[row - 2][col + 2]
										
								&& chess[row][col] == chess[row - 3][col + 3]
										
								&& chess[row][col] != 0) {
							return chess[row][col];
						}
					}
				}

				return 0;
			}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
		
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == newGame)
		{
			for (int row = 0; row < boardSize; row++) {
				for (int col = 0; col < boardSize; col++) {
					chess[row][col] = 0;
				}
			}
			super.repaint();
		}
		else if (e.getSource() == abt)
		{
			JOptionPane.showMessageDialog(null, "Welcome to Connect Four! Duh!");
		}
		else if(e.getSource() == closeGame)
		{
			Toolkit.getDefaultToolkit().beep();
			int decision = JOptionPane.showConfirmDialog(null, 
			        "Are you sure want to quit the game?", "Quit",
			        JOptionPane.YES_NO_OPTION);
			if(decision == JOptionPane.YES_OPTION)
			{
			System.exit(0);
			}
			else
			{
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		}
	}
}