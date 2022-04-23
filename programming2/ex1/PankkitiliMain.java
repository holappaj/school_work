import java.util.Scanner;

public class PankkitiliMain {
	private static boolean menu = false;
	private static Scanner lukija = new Scanner(System.in);
	
	public static void setMenu(boolean menu) {
		PankkitiliMain.menu = menu;
	}
	public boolean getMenu() {
		return menu;
	}
	public static void main(String [] args) {
		// Ekaksi luodaan pankkitili
		System.out.println("Tervetuloa pankkiautomaatille");
		System.out.printf("Anna tilinumero: ");
		String tilinum = lukija.nextLine();
		
		System.out.printf("Anna tilin omistajan nimi: ");
		String nimi = lukija.nextLine();
		
		System.out.printf("Määrää tilin saldo: ");
		double rahamaara = lukija.nextDouble();
		while (rahamaara < 0) {
			System.out.printf("Saldo ei voi olla negatiivinen! Syötä uusi saldo:");
			rahamaara = lukija.nextDouble();
		}
		Pankkitili pankkitili = new Pankkitili();
		
		pankkitili.setOmistaja(nimi);
		pankkitili.setSaldo(rahamaara);
		pankkitili.setTilinumero(tilinum);
		
		System.out.println(pankkitili);
		setMenu(true);
		// Pankkitilin luonnin jälkeen avautuu menu rakenne, missä voi valita kolmesta operaatiosta
		while (menu) {
			System.out.println("\nMitä haluat tehdä? 1 - nosta tililtä, 2 -Talleta tilille, 3 - poistu");
			int toimenpide = lukija.nextInt();
			switch (toimenpide) {
				case 1:
					System.out.println("Määrää nostosumma: ");
					double nosto = lukija.nextDouble();
					pankkitili.otto(nosto);
					System.out.println(pankkitili);
					break;
					
				case 2:
					System.out.printf("\nMäärää talletussumma: ");
					double talletus = lukija.nextDouble();
					pankkitili.talletus(talletus);
					System.out.println(pankkitili);
					break;
					
				case 3:
					System.exit(0);
					
				default:
					System.out.println("Invalidi syöte");
					break;
			}
		}
	}
}



