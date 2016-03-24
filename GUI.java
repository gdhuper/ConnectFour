 package CS151.HW3;

import java.awt.BorderLayout;
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
	private MenuItem newGame, closeGame, abt;
	BoardPanel panel = new BoardPanel();

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
	    
		
	   //contentPane = new JPanel();
	    Font myFont = new Font("Sans-Serif", Font.BOLD, 100);
	    JLabel label = new JLabel("Connect Four!");
	    label.setFont(myFont);
	    label.setOpaque(true);
	    
	   
	    
	  
		//contentPane.setBorder(new EmptyBorder(20, 20, 5, 5));
		//contentPane.setLayout(new BorderLayout(1, 1));
		//add(contentPane, BorderLayout.CENTER);
		//.setMaximumSize(new Dimension(Integer.MAX_VALUE,Integer.MIN_VALUE)); // to set the max size not sure how if works tho 	
		
		//setContentPane(contentPane);
		//getContentPane().setForeground(Color.BLUE);
		//getContentPane().setBackground(Color.BLUE);
		
	    BoardPanel p = new BoardPanel();
	    p.setIgnoreRepaint(true);
	    p.setPreferredSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
	     add(p, BorderLayout.CENTER);
	    pack();
	
	    setSize(1024, 768);

		
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
