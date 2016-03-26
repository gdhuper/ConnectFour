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
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class GUI1 extends JFrame implements MouseListener, ActionListener{

	// private static final Graphics Graphics = null;
	private MenuItem newGame, closeGame, abt;
	private int currentPlayer = BoardPanel1.PLAYER_ONE;
	BoardPanel1 p = new BoardPanel1(BoardPanel1.MAXROW, BoardPanel1.MAXCOL);
	
    BoardPanel1[][] array = new BoardPanel1[BoardPanel1.MAXROW][BoardPanel.MAXCOL];
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

					//GUI frame = new GUI();
					//frame.setLocationRelativeTo(null);
					//frame.setVisible(true); // to center the frame
		new GUI1();
	}
	public GUI1()
	{
		super.setTitle("Connect Four!!");
		createGUI();
		
			
	}

	/**
	 * Create the frame.
	 */
	public void createGUI() {
		// JFrame frame = new JFrame();
		super.setSize(1024, 720);
		super.setVisible(true);
		super.setResizable(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//super.setBounds(200, 200, 800, 600);
		//super.setTitle("Connect Four!");
		//super.setLocationRelativeTo(null);
		//super.setVisible(true);

		MenuBar menuBar = new MenuBar(); // For the menu on top

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
		// JMenuItem closeItem = fileMenu.add("Close");
		fileMenu.addSeparator();
		menuBar.add(fileMenu);
		menuBar.add(aboutMenu);
		setMenuBar(menuBar);
		this.setVisible(true);

		// contentPane = new JPanel();
		Font myFont = new Font("Sans-Serif", Font.BOLD, 100);
		JLabel label = new JLabel("Connect Four!");
		label.setFont(myFont);
		label.setOpaque(true);

		// contentPane.setBorder(new EmptyBorder(20, 20, 5, 5));
		// contentPane.setLayout(new BorderLayout(1, 1));
		// add(contentPane, BorderLayout.CENTER);
		// .setMaximumSize(new Dimension(Integer.MAX_VALUE,Integer.MIN_VALUE));
		// // to set the max size not sure how if works tho

		// setContentPane(contentPane);
		// getContentPane().setForeground(Color.BLUE);
		// getContentPane().setBackground(Color.BLUE);

		// BoardPanel p = new BoardPanel();
		// BoardPanel p = new BoardPanel(6, 7);
		 JPanel j = (JPanel) super.getContentPane();
			j.setLayout(new GridLayout(BoardPanel.MAXROW, BoardPanel.MAXCOL));
			//array = new int[MAXROW][MAXCOL];
			//colNum = new int[MAXCOL];
			for (int row = 0; row <  BoardPanel.MAXROW; row++){
				for (int col = 0; col < BoardPanel.MAXCOL; col++){
					BoardPanel1 panel = new BoardPanel1(col, row);
					//j.addMouseListener((MouseListener) this);
					panel.setCurrentPlayer(this.currentPlayer);
					
					panel.addMouseListener(this);
					array[row][col] = panel;
			 		//colNum[col] = col;
					j.add(array[row][col]);
				}
			}
					
		//p.setIgnoreRepaint(true);
		//p.setPreferredSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
		//add(p, BorderLayout.CENTER);
		//pack();
		//super.setVisible(true);
			super.repaint();
		//super.setSize(1024, 768);
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == newGame)

		{
			//BoardPanel.reset();
		} else if (e.getSource() == abt) {
			JOptionPane.showMessageDialog(null, "Welcome to Connect Four! Duh!");
		} else if (e.getSource() == closeGame)

		{
			Toolkit.getDefaultToolkit().beep();
			int decision = JOptionPane.showConfirmDialog(null, "Are you sure want to quit the game?", "Quit",
					JOptionPane.YES_NO_OPTION);
			if (decision == JOptionPane.YES_OPTION) {
				System.exit(0);
			} else {
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}