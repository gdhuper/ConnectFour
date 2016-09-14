package CS151.HW3;

import javax.swing.JOptionPane;


public class PlayGame {
	
	
	Controller c = null;
	static JOptionPane pane = new JOptionPane();

	public static void main(String[] args) {
		
		String s = pane.showInputDialog("Please enter the size of board between 5-50");
		 
		int size = Integer.parseInt(s);
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
		 String w = pane.showInputDialog("Please enter winning sequence number");
		 int winS = Integer.parseInt(w);
		 
		 if(winS > size)
		 {
		 JOptionPane.showMessageDialog(null,
		 "Sorry! Winning sequence should be less than board size");
		 }
		// new ConnectFour(Integer.parseInt(args[0]));
		 
		new Controller(size, winS);

	}
	

}
