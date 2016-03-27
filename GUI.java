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

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame implements MouseListener, ActionListener{

	private JPanel panel_Center;
	protected JPanel[][] buttonsBoard;
	private static int boardSize = 8;
	private static int winSequence = 5;
	protected int [][] chess;
	//private static final Graphics Graphics = null;
	private MenuItem newGame, closeGame, abt;
	private int player = 1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		//int size = Integer.parseInt(args[0]);
		//if(size > 50)
		//{
			
		//JOptionPane.showMessageDialog(null, "Sorry! Please select a size under 50");
	//	}
		//int winS = Integer.parseInt(args[1]);
		//if(winS > size)
		//{
		//JOptionPane.showMessageDialog(null, "Sorry! Winning sequence should be less than board size");
		//}
		
		//new ConnectFour(Integer.parseInt(args[0]));
	
		new GUI(boardSize, winSequence );
	}

	public GUI(int boardSize, int winSequence)
	{
		this.boardSize = boardSize;
		this.winSequence = winSequence;
	     showFrame();
	     JOptionPane.showMessageDialog(null,"Welcome to Connect 4");
	}

public void showFrame()
{
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
    buttonsBoard =new JPanel[boardSize][boardSize];
    chess=new int[boardSize][boardSize];
        
     for (int r=0; r<boardSize;r++)
     {
    	for (int c=0;c<boardSize;c++)
            {
                buttonsBoard[r][c]=new JPanel();
               buttonsBoard[r][c].setBackground(Color.BLACK);
               
                panel_Center.add(buttonsBoard[r][c]);
                chess[r][c] = 0;
                
                buttonsBoard[r][c].putClientProperty("row", r);
                buttonsBoard[r][c].putClientProperty("col", c);
                
                buttonsBoard[r][c].addMouseListener(this);
                chess[r][c]=0;	
            }
         }

    add(panel_Center,BorderLayout.CENTER);
    panel_Center.repaint();
    setVisible(true);
	}

	

	@Override
	public void mouseClicked(MouseEvent e) 
	{
		JPanel panel = (JPanel) e.getSource();
		int row = (Integer)panel.getClientProperty("row");
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
							checkWinner();
							player=2;
							
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
							checkWinner();
							player=1;
							
							break;
						}
					}
					
					player=1;
					break;
				}
			}
		}
		
	}
	
	
	public void checkWinner()
	{

		  
		  //win at row
		int counter = 0;
		  for (int r=0;r<boardSize;r++) // 
		    {
		        for(int c=0;(c+(winSequence-1))<boardSize;c++)
		             {
		        	  for(int j = 0; j < winSequence; j++)  // for how many boxes to check around
		        	  {
		                if(chess[r][c]==chess[r][c+j]&&
		                      
		                      chess[r][c]==1)
		                	
		                        {
		                			counter++;
		                			continue;
		                			
		                        }
		                else
		                {
		                	 counter = 0;
		                	break;
		                }
		         
		        	      }
		        	         if(counter == winSequence)
		        	         {
		                         JOptionPane.showMessageDialog(null,player+" is a winner.");
		                         counter = 0;
		                         int d =  JOptionPane.showConfirmDialog(null, "Do you wish to replay game?", "Play Again!", JOptionPane.YES_NO_OPTION);
			                        
		                         if(d == JOptionPane.YES_OPTION)
		                        	 {
		                        		 reset();
		                        	 }
		                         else{
		                        	 System.exit(0);
		                         }
		                        
		        	         }
		                        
		                        
		                         
		                       

		       
		        for(int j = 0; j < winSequence; j++)   // for how many boxes to check around
	        	  {
		                 if(chess[r][c]==chess[r][c+j]&&
		                       
		                            chess[r][c]==2)
		                      {
		                	 counter++;
		                	 continue;
		                      }
		                 else
		                 {
		                	 counter = 0;
		                	 break;
		                 }
	        	  }
		        		if(counter == winSequence)
		        			{
		                         JOptionPane.showMessageDialog(null,player+ " is a winner.");
		                         counter = 0;
		                         int q =  JOptionPane.showConfirmDialog(null, "Do you wish to replay game?", "Play Again!", JOptionPane.YES_NO_OPTION);
			                        
		                         if(q == JOptionPane.YES_OPTION)
		                        	 {
		                        		 reset();
		                        	 }
		                         else{
		                        	 System.exit(0);
		                         }
		                        
		                    }
		             }
		        }
		 

		  
		   
		   

		 //win at column

		 for (int r=0; (r+ (winSequence - 1))<boardSize;r++)
		    {
		         for(int c=0;c<boardSize;c++)
		              {
		        	 for(int j = 0; j < winSequence; j++) // for how many boxes to check around
		        	  {
		                 if(chess[r][c]==chess[r+j][c]&&
		                       
		                       chess[r][c]==1)
		                         {
		                	 counter++;
		                	 continue;
		                         }
		                 else
		                 {
		                	 counter = 0;
		                	 break;
		                 }
		        	  }
		        	 if(counter == winSequence)
		        	 {
		                         JOptionPane.showMessageDialog(null, player+" is a winner.");
		                         counter = 0;
		                        int d =  JOptionPane.showConfirmDialog(null, "Do you wish to replay game?", "Play Again!", JOptionPane.YES_NO_OPTION);
		                        
		                         if(d == JOptionPane.YES_OPTION)
		                        	 {
		                        		 reset();
		                        	 }
		                         else{
		                        	 System.exit(0);
		                         }
		        	 }
		                         
		                       
		                    
		        	 for(int j = 0; j < winSequence; j++) // for how many boxes to check around
		        	  {
		                  if(chess[r][c]==chess[r+j][c]&&
		                             
		                             chess[r][c]==2)
		                       {
		                	  counter++;
		                	  continue;
		                       }
		                  else
		                  {
		                	  counter = 0;
		                	  break;
		                  }
		        	  }
		        	 if(counter == winSequence)
		        	 {
		                         JOptionPane.showMessageDialog(null,player+" is a winner.");
		                         counter = 0;
		                         int e =  JOptionPane.showConfirmDialog(null, "Do you wish to replay game?", "Play Again!", JOptionPane.YES_NO_OPTION);
			                        
		                         if(e == JOptionPane.YES_OPTION)
		                        	 {
		                        		 reset();
		                        	 }
		                         else{
		                        	 System.exit(0);
		                         }
		                       
		                    }
		              }
		         }
		              
		  
		//win at upleft-to-downright direction
		for (int r=0;(r+(winSequence - 1))<boardSize;r++)
		    {
		         for(int c=0;(c+(winSequence - 1))<boardSize;c++)
		              {
		        	 for(int j = 0; j < winSequence; j++)     // for how many boxes to check around
		        	  {
		                 if(chess[r][c]==chess[r+j][c+j]&&
		                      
		                       chess[r][c]==1)
		                         {
		                	 counter++;
		                	 continue;
		                         }
		                 else
		                 {
		                	 counter = 0;
		                	 break;
		                 }
		        	  }
		        	 if(counter == winSequence)
		        	 {
		                         JOptionPane.showMessageDialog(null, player+" is a winner.");
		                         counter = 0;
		                         int d =  JOptionPane.showConfirmDialog(null, "Do you wish to replay game?", "Play Again!", JOptionPane.YES_NO_OPTION);
			                        
		                         if(d == JOptionPane.YES_OPTION)
		                        	 {
		                        		 reset();
		                        	 }
		                         else{
		                        	 System.exit(0);
		                         }
		        	 }
		                        
		                    
		        	 for(int j = 0; j < winSequence; j++)   // for how many boxes to check around
		        	  {
		                  if(chess[r][c]==chess[r+j][c+j]&&
		                             
		                             chess[r][c]==2)
		                       {
		                	  counter++;
		                	  continue;
		                       }
		                  else
		                  {
		                	  counter = 0;
		                	  break;
		                  }
		        	  }
		                  
		        	 if(counter == winSequence)
		        	 {
		                         JOptionPane.showMessageDialog(null,player+" is a winner.");
		                         counter = 0;
		                         int f =  JOptionPane.showConfirmDialog(null, "Do you wish to replay game?", "Play Again!", JOptionPane.YES_NO_OPTION);
			                        
		                         if(f == JOptionPane.YES_OPTION)
		                        	 {
		                        		 reset();
		                        	 }
		                         else{
		                        	 System.exit(0);
		                         }
		                       
		                    }
		        	 
		              }
		         }
		              
		  
		//win at downleft-to-upright direction
		for (int r=boardSize - 1;(r-(winSequence - 1))>=0;r--)
		    {
		         for(int c=0;(c+(winSequence - 1))<boardSize;c++)
		              {
		        	 for(int j = 0; j < winSequence; j++)    // for how many boxes to check around
		        	  {  
		                 if(chess[r][c]==chess[r-j][c+j]&&
		                       chess[r][c]==1)
		                	 
		                         {
		                	 counter++;
		                	 continue;
		                         }
		                 else
		                 {
		                	 counter = 0;
		                	 break;
		                 }
		        	  }
		        	 if(counter == winSequence)
		        	 {
		                         JOptionPane.showMessageDialog(null, player+" is a winner.");
		                         counter = 0;
		                         int d =  JOptionPane.showConfirmDialog(null, "Do you wish to replay game?", "Play Again!", JOptionPane.YES_NO_OPTION);
			                        
		                         if(d == JOptionPane.YES_OPTION)
		                        	 {
		                        		 reset();
		                        	 }
		                         else{
		                        	 System.exit(0);
		                         }
		        	 }
		                        
		                    
		        	 for(int j = 0; j < winSequence; j++)    // for how many boxes to check around
		        	  {
		                  if(chess[r][c]==chess[r-j][c+j]&&
		                             
		                             chess[r][c]==2)
		                       {
		                	  counter++;
		                	  continue;
		                       }
		                  else
		                  {
		                	  counter = 0;
		                	  break;
		                  }
		        	  }
		        	    if(counter == winSequence)
		        	    {
		        	    	
		        	    
		                         JOptionPane.showMessageDialog(null,player+" is a winner.");
		                         counter = 0;
		                         int g =  JOptionPane.showConfirmDialog(null, "Do you wish to replay game?", "Play Again!", JOptionPane.YES_NO_OPTION);
			                        
		                         if(g == JOptionPane.YES_OPTION)
		                        	 {
		                        		 reset();
		                        	 }
		                         else{
		                        	 System.exit(0);
		                         }
		        	    }
		                       
		                    }
		         }
		              }
		  

	

		//end hasAwinner
	

	
	
	
	
	private void reset() {
		for(int i = 0; i < boardSize; i++)
		{
			for(int j = 0; j < boardSize; j++)
			{
				this.chess[i][j] = 0;
			}
		}
		new GUI(boardSize,winSequence );
		
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
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
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