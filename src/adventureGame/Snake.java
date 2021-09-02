package adventureGame;

import java.util.Random;

public class Snake extends Monster {
	//super constructor random usage
	private static Random r=new Random();

	public Snake() {
		super(4, "Yýlan",r.nextInt(3)+3, 12, 0);
	}
	
	

}
