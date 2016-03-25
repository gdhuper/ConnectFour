package CS151.HW3;

import java.awt.EventQueue;

public class Controller {
	
	private  Player one, two;
	private Player currentPlayer;
	
	public static void main(String[] args) {
		
		//BoardPanel.MAXCOL = Integer.parseInt(args[0]);
		
		
		
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
	
	
	public Controller(Player one, Player two, Player currentPlayer)
	{
		this.one = one;
		this.two = two;
		this.currentPlayer = currentPlayer;
	}
	
	public void checkTurn()
	{
		
	}
	public void checkWinner()
	{
		
	}

}
