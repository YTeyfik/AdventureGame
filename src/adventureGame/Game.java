package adventureGame;

import java.util.Scanner;

public class Game {
	private Scanner scan=new Scanner(System.in);
	
	
	public void start() {
		System.out.println("Oyun ba�lat�l�yor");
		System.out.println("L�tfen isminizi giriniz");
		String playerName=scan.nextLine();
		Player player=new Player(playerName);
		System.out.println("K�ymetli "+player.getName()+" bu muhte�em maceraya ho�geldin! \nBu macerada hayatta kalmak i�in elinden geleni yap!");
		player.selectChamp();
		
		Location location=null;
		
		while(true) {
			String lastAward=player.getInventory().getAward().getName();
			if(lastAward.contains("Yemek") && lastAward.contains("Odun")&&lastAward.contains("Su")) {
				System.out.println("Tebrikler Oyunu Kazand�n�z...");
				location=null;
				break;
			}
			
			System.out.println();
			System.out.println("---------  B�lgeler!  ---------");
			System.out.println();
			System.out.println("1-G�venli Ev! --> Burada can�n� doldurabilirsin!");
			System.out.println("2-D�kkan! --> Buradan yeni e�yalar sat�n alablirsin.");
			System.out.println("3-Ma�ara! --> Buras� zombilerin mekan�! Bir veya daha fazlas� ile kar��la�abilirsin! G�revin bitti�inde yemek ile �d�llendirileceksin!");
			System.out.println("4-Orman! --> Buras� vampirlerin mekan�! Bir veya daha fazlas� ile kar��la�abilirsin! G�revin bitti�inde odun ile �d�llendirileceksin!");
			System.out.println("5-Nehir! --> Buras� ay�lar�n mekan�! Bir veya daha fazlas� ile kar��la�abilirsin! G�revin bitti�inde su ile �d�llendirileceksin!");
			System.out.println("6-Maden! --> Buras� y�lanlar�n mekan�! Bir veya daha fazlas� ile kar��la�abilirsin! G�revin bitti�inde rastgele e�ya ile �d�llendirileceksin!");
			System.out.println("0-��k��! --> Oyunu sonland�r.");
			System.out.println("Gitmek istedi�in b�lgeyi se�: ");
			int selectLoc=scan.nextInt();
			
			
			
			
			boolean conCave=player.getInventory().getAward().getName().contains("Yemek");
			boolean conForest=player.getInventory().getAward().getName().contains("Odun");
			boolean conRiver=player.getInventory().getAward().getName().contains("Su");
			
			switch (selectLoc) {
			case 0:	
				location=null;
				break;
			case 1: 
				location=new SafeHouse(player);
				break;
			case 2:	
				player.showInfo();
				System.out.println();
				location=new Market(player);
				break;
			case 3:
				if(conCave==true) {
					System.out.println("Bu b�lgedeki t�m canavarlar� yok ettiniz. Tekrar giremezsiniz!");
					location=new SafeHouse(player);
					break;
				}
				else if(conCave==false){
					location=new Cave(player);
					break;
				}
				break;
			case 4:
				if(conForest==true) {
					System.out.println("Bu b�lgedeki t�m canavarlar� yok ettiniz. Tekrar giremezsiniz!");
					location=new SafeHouse(player);
					break;
				}
				else if(conForest==false){
					location=new Forest(player);
					break;
				}
				break;
			case 5:
				if(conRiver==true) {
					System.out.println("Bu b�lgedeki t�m canavarlar� yok ettiniz. Tekrar giremezsiniz!");
					location=new SafeHouse(player);
					break;
				}
				else if(conRiver==false){
					location=new River(player);
					break;
				}
				break;
			case 6:
				location=new Mine(player);
				break;
			default:
				location=new SafeHouse(player);
			}
			
			if(location == null) {
				System.out.println("Oyun Bitti");
				break;
			}
			if(!location.onLocation()) {
				System.out.println("Oyun Bitti!!!");
				break;
			}
			
		}
	
	}
}
