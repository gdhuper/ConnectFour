 package CS151.HW3;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class GUI extends JFrame implements ActionListener{

	private static final Graphics Graphics = null;
	private JPanel contentPane;
	private JMenuItem newGame, closeGame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		/**JFrame frame = new JFrame("Connect Four");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(10,10));
		
		frame.add(new Button("click to play"));
		frame.pack();
		frame.setVisible(true);
		*/
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
					//T4 gui = new T4(board, firstPlayer, depth);
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
		JFrame frame = new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		setTitle("Connect Four!");
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu fileMenu = new JMenu("File");
		
	    newGame = fileMenu.add("New Game");
	    newGame.addActionListener(this);
	    closeGame = fileMenu.add("Quit");
	   closeGame.addActionListener(this);
	   JMenu aboutMenu = new JMenu("About");
       
	   //JMenuItem closeItem = fileMenu.add("Close");
	   fileMenu.addSeparator();
	   menuBar.add(fileMenu); 
	   menuBar.add(aboutMenu);
		
	   contentPane = new JPanel();
	   Font myFont = new Font("Serif", Font.BOLD, 50);
	   JLabel label = new JLabel("Connect Four!");
	   label.setFont(myFont);
	  // contentPane.add(label);
	   
	  
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(10, 1));
		//contentPane.add(drawBoard());
		setContentPane(contentPane);
		getContentPane().setBackground(Color.YELLOW);
		
		
		
	}
	
	public void drawBoard()
	{
		Graphics.draw3DRect(10, 12, 23, 32, true);
	
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == newGame)
		
		{
			//reset();
		}
		else if(e.getSource() == closeGame)
			
		{
			System.exit(0);
		}
	}
	

}
