package adventureGame;

public class Market extends NormalLoc{

	public Market(Player player) {
		super(player, "Ma�aza");
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean onLocation() {
		System.out.println("Ma�azaya ho�geldin!");
		boolean showMenu=true;
		while(showMenu) {
			System.out.println("1- Silahlar");
			System.out.println("2- Z�rhlar");
			System.out.println("3- ��k��");
			System.out.println("Se�iminiz :");
			int selectTaken=scan.nextInt();
			while(selectTaken<1 || selectTaken>3) {
				System.out.println("Ge�ersiz de�er,tekrar se�im yap�n.");
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
				System.out.println("��k� yapt�n�z\nG�le g�le!");
				showMenu=false;
				break;
			}
		}
		return true;
	}
	
	public void showWeapon() {
		
		System.out.println("Silahlar :");
		for (Weapon weapon : Weapon.weapons()) {
			System.out.println(weapon.getId()+"-"+ weapon.getName()+ " Hasar� :"+weapon.getDamage()+" Fiyat� :"+weapon.getPrice());
		}
		System.out.println("0 - ��k�� yap");
		
	}
	
	public void buyWeapon() {
		System.out.println("Bir silah se�!");
		int selectWeaponId=scan.nextInt();
		while(selectWeaponId < 0 || selectWeaponId > Weapon.weapons().length) {
			System.out.println("Ge�ersiz de�er,tekrar se�im yap�n.");
			selectWeaponId=scan.nextInt();
		}
		if(selectWeaponId!=0) {
			Weapon selectedWeapon =Weapon.getWeaponById(selectWeaponId);
			if(selectedWeapon!=null) {
				if(selectedWeapon.getPrice()>this.getPlayer().getMoney()) {
					System.out.println("Yeterli paran�z yok.");
				}else {
					System.out.println(selectedWeapon.getName()+ " silah�n� sat�n ald�n.");
					System.out.println();
					int balance=this.getPlayer().getMoney()-selectedWeapon.getPrice();
					this.getPlayer().setMoney(balance);
					System.out.println("Kalan paran :"+this.getPlayer().getMoney());
					System.out.println();
					System.out.println("�nceki silah :"+this.getPlayer().getInventory().getWeapon().getName());
					System.out.println();
					this.getPlayer().getInventory().setWeapon(selectedWeapon);
					System.out.println("Yeni silah :"+this.getPlayer().getInventory().getWeapon().getName());
					System.out.println();
				}
			}
		}
		
	}
	
	public void showArmor() {
		System.out.println("Z�rhlar :");
		for (Armor armor : Armor.armors()) {
			System.out.println(armor.getId()+"-"+ armor.getName()+ " Z�rh De�eri :"+armor.getBlock()+" Fiyat� :"+armor.getPrice());
		}
	}
	
	public void buyArmor() {
		System.out.println("Bir z�rh se�!");
		int selectArmorId=scan.nextInt();
		while(selectArmorId < 0 || selectArmorId > Armor.armors().length) {
			System.out.println("Ge�ersiz de�er,tekrar se�im yap�n.");
			selectArmorId=scan.nextInt();
		}
		Armor selectedArmor =Armor.getArmorById(selectArmorId);
		if(selectedArmor!=null) {
			if(selectedArmor.getPrice()>this.getPlayer().getMoney()) {
				System.out.println("Yeterli paran�z yok.");
			}else {
				System.out.println(selectedArmor.getName()+ " z�rh�n� sat�n ald�n.");
				System.out.println();
				int balance=this.getPlayer().getMoney()-selectedArmor.getPrice();
				this.getPlayer().setMoney(balance);
				System.out.println("Kalan paran :"+this.getPlayer().getMoney());
				System.out.println();
				System.out.println("�nceki z�rh :"+this.getPlayer().getInventory().getArmor().getName());
				System.out.println();
				this.getPlayer().getInventory().setArmor(selectedArmor);
				System.out.println("Yeni z�rh :"+this.getPlayer().getInventory().getArmor().getName());
				System.out.println();
			}
		}
	}
}
