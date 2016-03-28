
package CS151.HW3;

public class Player {
	int playerTurn = 1;
	static int player1 = 1;
	static int player2 = 2;
	
	public int getNextPlayer()
	{
		if(playerTurn == 1)
		{
			playerTurn = player2;
		}
		else if (playerTurn == 2)
		{
			playerTurn = player1;
		}
		return playerTurn;
	}
	
	

}
