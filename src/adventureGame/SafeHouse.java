package adventureGame;

public class SafeHouse extends NormalLoc{

	public SafeHouse(Player player) {
		super(player, "Güvenli Ev");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean onLocation() {
		System.out.println("Güvenli evdesin");
		this.getPlayer().setHealth(this.getPlayer().getOriginalHealth());
		System.out.println("Canýnýz yenilendi");
		return true;
	}

}
