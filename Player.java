package CS151.HW3;

public class Player {
	
	private String p1;
	private String p2;
	private String c1;
	private String c2;
	
	
	public Player(String name1, String color1, String name2, String color2)
	{
		this.p1 = name1;
		this.c1 = color1;
		this.p2 = name2; 
		this.c2 = color2;
	}


	public String getP1() {
		return p1;
	}


	public void setP1(String p1) {
		this.p1 = p1;
	}


	public String getP2() {
		return p2;
	}


	public void setP2(String p2) {
		this.p2 = p2;
	}


	public String getC1() {
		return c1;
	}


	public void setC1(String c1) {
		this.c1 = c1;
	}


	public String getC2() {
		return c2;
	}


	public void setC2(String c2) {
		this.c2 = c2;
	}

		
	
}
