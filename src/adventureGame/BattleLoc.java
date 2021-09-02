package adventureGame;

import java.util.Random;

public abstract class BattleLoc extends Location{
	
	private Monster monster;
	private String award;
	private int maxMonster;
	private static Random r=new Random();

	public BattleLoc(Player player, String name, Monster monster, String award,int maxMonster) {
		super(player, name);
		this.monster = monster;
		this.award = award;
		this.maxMonster=maxMonster;
	}
	
	


	@Override
	public boolean onLocation() {
		int numOfMonster=this.randomMonster();
		System.out.println("Þuan buradasýnýz :"+this.getName()); 
		System.out.println("Dikkatli ol! Burada "+numOfMonster+" tane "+this.getMonster().getName()+" yaþýyor");
		System.out.println("Savaþmak için 'S' kaçmak için 'K'ye basýnýz :");
		String selection=scan.next();
		selection=selection.toUpperCase();
		if(selection.equals("S") && combat(numOfMonster)) {
				System.out.println(this.getName()+" tüm düþmanlarý yendiniz !");
				if(this.getMonster().getName()=="Yýlan") {
					getrandomAward();
				}
				return true;			
		}
		if(this.getPlayer().getHealth()<=0){
			System.out.println("Öldün! :(");
			return false;
		}
		return true;
	}
	
	
	public int randomMonster() {
		Random r =new Random();
		return r.nextInt(this.getMaxMonster())+1;
	}
	
	public void afterHit() {
		System.out.println("Canýnýz : "+this.getPlayer().getHealth());
		System.out.println(this.getMonster().getName()+" caný : "+this.getMonster().getHealth());
	}
	
	public boolean combat(int numOfMonster) {
		Random rand=new Random();
		for(int i=1;i<=numOfMonster;i++) {
			this.getMonster().setHealth(this.getMonster().getOriginalHealth());
			playerStats();
			monsterStats(i);
			//Oyuncu bir canavarla karþýlaþtýðýnda ilk hamleyi kimin yapacaðýný, %50 þans ile belirlenmesi.
			int firstHit=rand.nextInt(2);
			while(this.getPlayer().getHealth()>0 &&this.getMonster().getHealth()>0) {
				if(firstHit==0) {
					System.out.println("Vurmak için 'V' kaçmak için 'K'ye basýnýz :");
					String selection=scan.next();
					selection=selection.toUpperCase();
					if(selection.equals("V")) {
						System.out.println(this.getMonster().getName()+" e vurdunuz!");
						this.getMonster().setHealth(this.monster.getHealth()-this.getPlayer().getTotalDamage());
						afterHit();
						if(this.getMonster().getHealth()>0) {
							System.out.println();
							System.out.println(this.getMonster().getName()+" size vurdu!");
							int monsterDamageAfterArmor=this.getMonster().getDamage()-this.getPlayer().getInventory().getArmor().getBlock();
							if(monsterDamageAfterArmor<0) {
								monsterDamageAfterArmor=0;
							}
							this.getPlayer().setHealth(this.getPlayer().getHealth()-monsterDamageAfterArmor);
							afterHit();
						}
					}
					else {
						return false;
					}
				}else {
					System.out.println();
					System.out.println(this.getMonster().getName()+" size vurdu!");
					int monsterDamageAfterArmor=this.getMonster().getDamage()-this.getPlayer().getInventory().getArmor().getBlock();
					if(monsterDamageAfterArmor<0) {
						monsterDamageAfterArmor=0;
					}
					this.getPlayer().setHealth(this.getPlayer().getHealth()-monsterDamageAfterArmor);
					afterHit();
					if(this.getPlayer().getHealth()>0) {
						System.out.println("Vurmak için 'V' kaçmak için 'K'ye basýnýz :");
						String selection=scan.next();
						selection=selection.toUpperCase();
						if(selection.equals("V")) {
							System.out.println(this.getMonster().getName()+" e vurdunuz!");
							this.getMonster().setHealth(this.monster.getHealth()-this.getPlayer().getTotalDamage());
							afterHit();
					}
				}
			}
			}
			
			if(this.getPlayer().getHealth()>this.getMonster().getHealth()) {
				System.out.println("Tebrikler " + this.getMonster().getName() + " ordusunu yok ettiniz");
				System.out.println(this.getMonster().getAward()+" para kazandýnýz!");
				this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonster().getAward());
				
				System.out.println("Güncel para miktarýnýz : " + this.getPlayer().getMoney());
			}else {
				return false;
			}
		}
		if(this.getPlayer().getHealth()>0) {
			this.getPlayer().getInventory().getAward().setName(this.getPlayer().getInventory().getAward().getName()+this.award+" ");
			System.out.println(this.getPlayer().getInventory().getAward().getName());
		}
		
		return true;
		
	}
	
	public void getrandomAward() {
		int rand=r.nextInt(100)+1;
		int randx=r.nextInt(100)+1;
		if(rand<=15) {
			if(randx<=20) {
				this.getPlayer().getInventory().setWeapon(Weapon.getWeaponById(1));	
			}else if(randx>20 && randx<=50) {
				this.getPlayer().getInventory().setWeapon(Weapon.getWeaponById(2));
			}else if(randx>50 && randx<=100) {
				this.getPlayer().getInventory().setWeapon(Weapon.getWeaponById(3));
			}
			System.out.println("Yeni bir silah kazandýnýz : "+this.getPlayer().getInventory().getWeapon().getName());
		}
		else if(rand>15&&rand<=30) {
			if(randx<=20) {
				this.getPlayer().getInventory().setArmor(Armor.getArmorById(1));
			}else if(randx>20 && randx<=50) {
				this.getPlayer().getInventory().setArmor(Armor.getArmorById(2));
			}else if(randx>50 && randx<=100) {
				this.getPlayer().getInventory().setArmor(Armor.getArmorById(3));
			}
			System.out.println("Yeni bir zýrh kazandýnýz : "+this.getPlayer().getInventory().getArmor().getName());
		}
		else if(rand>30&&rand<=55) {
			if(randx<=20) {
				this.getPlayer().setMoney(this.getPlayer().getMoney()+10);
			}else if(randx>20 && randx<=50) {
				this.getPlayer().setMoney(this.getPlayer().getMoney()+5);
			}else if(randx>50 && randx<=100) {
				this.getPlayer().setMoney(this.getPlayer().getMoney()+1);
			}
			System.out.println("Madenden rastgele para kazandýn yeni para miktarýn : "+this.getPlayer().getMoney());
		}
		else{
			System.out.println("Madenden hiç bir þey kazanamadýn.");
		}
		
	}
	
	
	public void playerStats() {
		System.out.println("------ Oyuncu Deðerleri ------");
		System.out.println("Saðlýk : "+this.getPlayer().getHealth());
		System.out.println("Silah : "+this.getPlayer().getInventory().getWeapon().getName());
		System.out.println("Hasar : "+this.getPlayer().getTotalDamage());
		System.out.println("Zýrh : "+this.getPlayer().getInventory().getArmor().getName());
		System.out.println("Bloklama : "+this.getPlayer().getInventory().getArmor().getBlock());
		System.out.println("Para : "+this.getPlayer().getMoney());
		System.out.println();
	}
	
	public void monsterStats(int i) {
		System.out.println("------"+i+ ". "+this.getMonster().getName()+ " Deðerleri ------");
		System.out.println("Saðlýk : "+this.getMonster().getHealth());
		System.out.println("Hasar : "+this.getMonster().getDamage());
		System.out.println("Ödül : "+this.getMonster().getAward());
		System.out.println();
	}

	public Monster getMonster() {
		return monster;
	}



	public void setMonster(Monster monster) {
		this.monster = monster;
	}



	public String getAward() {
		return award;
	}



	public void setAward(String award) {
		this.award = award;
	}


	public int getMaxMonster() {
		return maxMonster;
	}


	public void setMaxMonster(int maxMonster) {
		this.maxMonster = maxMonster;
	}


}
