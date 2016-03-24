 package CS151.HW3;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
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

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class GUI extends JFrame implements ActionListener{

	//private static final Graphics Graphics = null;
	private JPanel contentPane;
	private MenuItem newGame, closeGame, abt;
	int[][] array;
	
	boolean gameStart;
	

	public static final int MAXROW = 6; 
	public static final int MAXCOL = 7;  
	public static final int BLANK = 0;
	public static final int RED = 1;
	public static final int YELLOW = 2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
	    EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);  // to center the frame
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		//JFrame frame = new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 800, 600);
		setTitle("Connect Four!");
		
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
	    this.setVisible(true);
	    
		
	    contentPane = new JPanel();
	    Font myFont = new Font("Sans-Serif", Font.BOLD, 100);
	    JLabel label = new JLabel("Connect Four!");
	    label.setFont(myFont);
	   
	   
	  
		contentPane.setBorder(new EmptyBorder(20, 20, 5, 5));
		contentPane.setLayout(new GridLayout(1, 1));
		contentPane.setMaximumSize(new Dimension(Integer.MAX_VALUE,Integer.MIN_VALUE)); // to set the max size not sure how if works tho 	
		
		setContentPane(contentPane);
		getContentPane().setBackground(Color.YELLOW);
		
	initialize();
	setSize(1024, 768);
		
		
	}
	
	public void initialize() {
		array = new int[MAXROW][MAXCOL];
		for (int row = 0; row < MAXROW; row++)
			for (int col = 0; col < MAXCOL; col++)
				array[row][col] = BLANK;
		gameStart = false;
	} // initialize

	public void paint(Graphics g) {

		g.fillRect(110, 50, 100 + 100 * MAXCOL, 100 + 100 * MAXROW);
		for (int row = 0; row < MAXROW; row++)
			for (int col = 0; col < MAXCOL; col++) {
				g.setColor(Color.YELLOW);
				if (array[row][col] == BLANK)
					g.setColor(Color.WHITE);
				if (array[row][col] == RED)
					g.setColor(Color.RED);
				if (array[row][col] == YELLOW)
					g.setColor(Color.YELLOW);
				g.fillOval(160 + 100 * col, 100 + 100 * row, 100, 100);
			}
			} 

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == newGame)
		
		{
			//reset();
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
