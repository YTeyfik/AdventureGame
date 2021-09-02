package adventureGame;

import java.util.Scanner;

public class Game {
	private Scanner scan=new Scanner(System.in);
	
	
	public void start() {
		System.out.println("Oyun baþlatýlýyor");
		System.out.println("Lütfen isminizi giriniz");
		String playerName=scan.nextLine();
		Player player=new Player(playerName);
		System.out.println("Kýymetli "+player.getName()+" bu muhteþem maceraya hoþgeldin! \nBu macerada hayatta kalmak için elinden geleni yap!");
		player.selectChamp();
		
		Location location=null;
		
		while(true) {
			String lastAward=player.getInventory().getAward().getName();
			if(lastAward.contains("Yemek") && lastAward.contains("Odun")&&lastAward.contains("Su")) {
				System.out.println("Tebrikler Oyunu Kazandýnýz...");
				location=null;
				break;
			}
			
			System.out.println();
			System.out.println("---------  Bölgeler!  ---------");
			System.out.println();
			System.out.println("1-Güvenli Ev! --> Burada canýný doldurabilirsin!");
			System.out.println("2-Dükkan! --> Buradan yeni eþyalar satýn alablirsin.");
			System.out.println("3-Maðara! --> Burasý zombilerin mekaný! Bir veya daha fazlasý ile karþýlaþabilirsin! Görevin bittiðinde yemek ile ödüllendirileceksin!");
			System.out.println("4-Orman! --> Burasý vampirlerin mekaný! Bir veya daha fazlasý ile karþýlaþabilirsin! Görevin bittiðinde odun ile ödüllendirileceksin!");
			System.out.println("5-Nehir! --> Burasý ayýlarýn mekaný! Bir veya daha fazlasý ile karþýlaþabilirsin! Görevin bittiðinde su ile ödüllendirileceksin!");
			System.out.println("6-Maden! --> Burasý yýlanlarýn mekaný! Bir veya daha fazlasý ile karþýlaþabilirsin! Görevin bittiðinde rastgele eþya ile ödüllendirileceksin!");
			System.out.println("0-Çýkýþ! --> Oyunu sonlandýr.");
			System.out.println("Gitmek istediðin bölgeyi seç: ");
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
					System.out.println("Bu bölgedeki tüm canavarlarý yok ettiniz. Tekrar giremezsiniz!");
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
					System.out.println("Bu bölgedeki tüm canavarlarý yok ettiniz. Tekrar giremezsiniz!");
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
					System.out.println("Bu bölgedeki tüm canavarlarý yok ettiniz. Tekrar giremezsiniz!");
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
