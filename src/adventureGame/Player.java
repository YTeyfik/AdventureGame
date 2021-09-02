package adventureGame;

import java.util.Scanner;

public class Player {
	private Scanner scan=new Scanner(System.in);
	private int damage;
	private int health;
	private int originalHealth;
	private int money;
	private String name;
	private String champion;
	private Inventory inventory;
	
	public Player(String name) {
		super();
		this.name = name;
		this.inventory=new Inventory();
	}
	
	public void selectChamp() {
		Champions[] championList= {new Samurai(),new Archer(),new Knight()};
		System.out.println("##########################################################");
		System.out.println("Þampiyonlar..");
		System.out.println("##########################################################");
		for (Champions champions : championList) {
			System.out.println(
					"Id: "+champions.getId()+" "+
					"Þampiyon: " +champions.getName() +
					"\tHasar: "+champions.getDamage()+
					"\tSaðlýk: "+champions.getHealth()+
					"\tPara: "+champions.getMoney());
		}
		System.out.println("##########################################################");
		System.out.println("Bu mistik macera için þampiyonunu seç");
		
		int chosenChamp=scan.nextInt();
		switch (chosenChamp) {
		case 1: 
			initPlayer(new Samurai());
			break;
		case 2: 
			initPlayer(new Archer());
			break;
		case 3: 
			initPlayer(new Knight());
			break;
		default:
			initPlayer(new Samurai());
		}
		
		/*System.out.println(
				"Kýymetli "+this.getName()+"\n"+
				"Þampiyonun adý :"+this.getChampion()+"\n"+
				"Þampiyonun hasarý :"+this.getDamage()+"\n"+
				"Þampiyonun saðlýðý :"+this.getHealth()+"\n"+
				"Þampiyonun sahip olduðu para :"+this.getMoney());
		*/
	}

	public void initPlayer(Champions champion) {
		this.setChampion(champion.getName());
		this.setDamage(champion.getDamage());
		this.setHealth(champion.getHealth());
		this.setOriginalHealth(champion.getHealth());
		this.setMoney(champion.getMoney());
	}
		
	public void showInfo() {
		System.out.println(
				"Silahýnýz :"+this.getInventory().getWeapon().getName()+
				" Zýrhýnýz :"+this.getInventory().getArmor().getName()+" "+
				"Hasarýnýz :"+this.getTotalDamage()+" "+
				"Bloklama :"+this.getInventory().getArmor().getBlock()+" "+
				"Saðlýðýnýz :"+this.getHealth()+" "+
				"Paranýz :"+this.getMoney());
	}
	
	public String getChampion() {
		return champion;
	}

	public void setChampion(String champion) {
		this.champion = champion;
	}
	
	public int getTotalDamage() {
		return damage + this.getInventory().getWeapon().getDamage();
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		if(health<0) {
			health=0;
		}
		this.health = health;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public int getOriginalHealth() {
		return originalHealth;
	}

	public void setOriginalHealth(int originalHealth) {
		this.originalHealth = originalHealth;
	}

	
	
}
