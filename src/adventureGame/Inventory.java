package adventureGame;

public class Inventory {
	private Weapon weapon;
	private Armor armor;
	private Award award;
	public Inventory() {
		this.weapon=new Weapon(-1,"Yumruk",0,0);
		this.armor=new Armor(-1,"Paçavra",0,0);
		this.award=new Award("");
	}
	public Weapon getWeapon() {
		return weapon;
	}
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	public Armor getArmor() {
		return armor;
	}
	public void setArmor(Armor armor) {
		this.armor = armor;
	}
	public Award getAward() {
		return award;
	}
	public void setAward(Award award) {
		this.award = award;
	}
	
	
	
}
