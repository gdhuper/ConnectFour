package CS151.HW3;

import javax.swing.JOptionPane;


public class PlayGame {
	
	
	Controller c = null;
	static boolean verify = false;
	static boolean v = false;
	static boolean v1 = false;
	static int size = 0;
	static int winS = 0;
	static String s = "";
	static String w = "";

	public static void main(String[] args) {
		
		 s = JOptionPane.showInputDialog("Please enter the size of the board between 5-15");
		 while(!verify){
		 if(s == null || s.equals(""))
		 {
			s = JOptionPane.showInputDialog("Please enter the size of board between 5-15");
		 }
		 if (s != null){
		 
		   size = Integer.parseInt(s);
		   verify = true;
		 }
		 if(Integer.parseInt(s) == JOptionPane.CANCEL_OPTION)
		 {
			 System.exit(0);
		 }
		 }
		 
		 
		while (!v) {
			if (size > 15) {

				s = JOptionPane
						.showInputDialog("Sorry! Please select a size under 15");
				size = Integer.parseInt(s);

			}
			else if (size < 5) {

				s = JOptionPane
						.showInputDialog("Sorry! Please select a size greater or equal to 5");
				size = Integer.parseInt(s);

			}
			else
			{
				v = true;
			}
		}
		
		w = JOptionPane.showInputDialog("Please enter winning sequence number");
		while(!v1){
		  
		  winS = Integer.parseInt(w);
		  if(w == null)
		  {
			  w = JOptionPane.showInputDialog("Please enter winning sequence number");
			  
		  }
		
		  if(winS <= size)
		  {
		  v1 = true;
		  }
		 
		 if(winS > size)
		 {
		 w = JOptionPane.showInputDialog(null,
		 "Sorry! Winning sequence should be less than board size");
		 }
		}
		
		new Controller(size, winS);

	}
	

}
