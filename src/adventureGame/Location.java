package adventureGame;

import java.util.Scanner;

public abstract class Location {
	public static Scanner scan=new Scanner(System.in);
	private Player player;
	private String name;
	public Location(Player player, String name) {
		super();
		this.player = player;
		this.name = name;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public abstract boolean onLocation();
}