package adventureGame;

public class Market extends NormalLoc{

	public Market(Player player) {
		super(player, "Maðaza");
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean onLocation() {
		System.out.println("Maðazaya hoþgeldin!");
		boolean showMenu=true;
		while(showMenu) {
			System.out.println("1- Silahlar");
			System.out.println("2- Zýrhlar");
			System.out.println("3- Çýkýþ");
			System.out.println("Seçiminiz :");
			int selectTaken=scan.nextInt();
			while(selectTaken<1 || selectTaken>3) {
				System.out.println("Geçersiz deðer,tekrar seçim yapýn.");
				selectTaken=scan.nextInt();
			}
			switch (selectTaken) {
			case 1: 
				showWeapon();
				buyWeapon();
				break;
			case 2:
				showArmor();
				buyArmor();
				break;
			case 3:
				System.out.println("Çýkþ yaptýnýz\nGüle güle!");
				showMenu=false;
				break;
			}
		}
		return true;
	}
	
	public void showWeapon() {
		
		System.out.println("Silahlar :");
		for (Weapon weapon : Weapon.weapons()) {
			System.out.println(weapon.getId()+"-"+ weapon.getName()+ " Hasarý :"+weapon.getDamage()+" Fiyatý :"+weapon.getPrice());
		}
		System.out.println("0 - çýkýþ yap");
		
	}
	
	public void buyWeapon() {
		System.out.println("Bir silah seç!");
		int selectWeaponId=scan.nextInt();
		while(selectWeaponId < 0 || selectWeaponId > Weapon.weapons().length) {
			System.out.println("Geçersiz deðer,tekrar seçim yapýn.");
			selectWeaponId=scan.nextInt();
		}
		if(selectWeaponId!=0) {
			Weapon selectedWeapon =Weapon.getWeaponById(selectWeaponId);
			if(selectedWeapon!=null) {
				if(selectedWeapon.getPrice()>this.getPlayer().getMoney()) {
					System.out.println("Yeterli paranýz yok.");
				}else {
					System.out.println(selectedWeapon.getName()+ " silahýný satýn aldýn.");
					System.out.println();
					int balance=this.getPlayer().getMoney()-selectedWeapon.getPrice();
					this.getPlayer().setMoney(balance);
					System.out.println("Kalan paran :"+this.getPlayer().getMoney());
					System.out.println();
					System.out.println("Önceki silah :"+this.getPlayer().getInventory().getWeapon().getName());
					System.out.println();
					this.getPlayer().getInventory().setWeapon(selectedWeapon);
					System.out.println("Yeni silah :"+this.getPlayer().getInventory().getWeapon().getName());
					System.out.println();
				}
			}
		}
		
	}
	
	public void showArmor() {
		System.out.println("Zýrhlar :");
		for (Armor armor : Armor.armors()) {
			System.out.println(armor.getId()+"-"+ armor.getName()+ " Zýrh Deðeri :"+armor.getBlock()+" Fiyatý :"+armor.getPrice());
		}
	}
	
	public void buyArmor() {
		System.out.println("Bir zýrh seç!");
		int selectArmorId=scan.nextInt();
		while(selectArmorId < 0 || selectArmorId > Armor.armors().length) {
			System.out.println("Geçersiz deðer,tekrar seçim yapýn.");
			selectArmorId=scan.nextInt();
		}
		Armor selectedArmor =Armor.getArmorById(selectArmorId);
		if(selectedArmor!=null) {
			if(selectedArmor.getPrice()>this.getPlayer().getMoney()) {
				System.out.println("Yeterli paranýz yok.");
			}else {
				System.out.println(selectedArmor.getName()+ " zýrhýný satýn aldýn.");
				System.out.println();
				int balance=this.getPlayer().getMoney()-selectedArmor.getPrice();
				this.getPlayer().setMoney(balance);
				System.out.println("Kalan paran :"+this.getPlayer().getMoney());
				System.out.println();
				System.out.println("Önceki zýrh :"+this.getPlayer().getInventory().getArmor().getName());
				System.out.println();
				this.getPlayer().getInventory().setArmor(selectedArmor);
				System.out.println("Yeni zýrh :"+this.getPlayer().getInventory().getArmor().getName());
				System.out.println();
			}
		}
	}
}
