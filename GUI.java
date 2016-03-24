 package CS151.HW3;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
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
	private JMenuItem newGame, closeGame, abt;

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
		
		JMenuBar menuBar = new JMenuBar(); //For the menu on top 
		
		JMenu fileMenu = new JMenu("File");
		
	    newGame = fileMenu.add("New Game");
	    newGame.addActionListener(this);
	    closeGame = fileMenu.add("Quit");
	    closeGame.addActionListener(this);
	    JMenu aboutMenu = new JMenu("About");
        abt = aboutMenu.add("About Game");
        abt.addActionListener(this);
	   //JMenuItem closeItem = fileMenu.add("Close");
	    fileMenu.addSeparator();
	    menuBar.add(fileMenu); 
	    menuBar.add(aboutMenu);
	    setJMenuBar(menuBar);
		
	   contentPane = new JPanel();
	   // contentPane.setForeground(Color.cyan); // does nothing for right now 
	   Font myFont = new Font("Sans-Serif", Font.BOLD, 100);
	   JLabel label = new JLabel("Connect Four!");
	   label.setFont(myFont);
	  
		contentPane.setBorder(new EmptyBorder(20, 20, 5, 5));
		contentPane.setLayout(new GridLayout(1, 1));
		contentPane.setMaximumSize(new Dimension(Integer.MAX_VALUE,Integer.MIN_VALUE)); // to set the max size not sure how if works tho 	

		setContentPane(contentPane);
		getContentPane().setBackground(Color.YELLOW);
		
		
		
	}
	
	/**public void drawBoard()
	{
		Graphics.draw3DRect(10, 12, 23, 32, true);
	
	}*/
	

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
