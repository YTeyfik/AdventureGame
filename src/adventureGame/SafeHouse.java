package adventureGame;

public class SafeHouse extends NormalLoc{

	public SafeHouse(Player player) {
		super(player, "G�venli Ev");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean onLocation() {
		System.out.println("G�venli evdesin");
		this.getPlayer().setHealth(this.getPlayer().getOriginalHealth());
		System.out.println("Can�n�z yenilendi");
		return true;
	}

}
