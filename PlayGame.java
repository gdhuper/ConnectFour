package CS151.HW3;

import javax.swing.JOptionPane;


public class PlayGame {
	
	/**
	Controller c = null;

	public static void main(String[] args) {
		 int size = Integer.parseInt(args[0]);
		 if(size > 50)
		 {

	     JOptionPane.showMessageDialog(null,
		 "Sorry! Please select a size under 50");
		 }
		 if(size <= 0 )
		 {

		     JOptionPane.showMessageDialog(null,
			 "Sorry! Please select a size greater than 0");
			 }
		 
		 int winS = Integer.parseInt(args[1]);
		 
		 if(winS > size)
		 {
		 JOptionPane.showMessageDialog(null,
		 "Sorry! Winning sequence should be less than board size");
		 }
		// new ConnectFour(Integer.parseInt(args[0]));
		 
		new Controller(size, winS);

	}*/
	
	public static void main(String[] args)
	{
		new Controller(5, 3);
	}
	

}
