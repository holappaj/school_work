package oh2_kt2;

import java.util.Scanner;

public class Ex2Main {
	public static void main(String[] args) {
		Scanner lukija = new Scanner(System.in);

		// Tontin tietojen kysyminen
		System.out.println("Anna tontin nimi: ");
		String nimi_tontti = lukija.nextLine();

		System.out.println("Anna leveyspiiri: ");
		String leveyspiiri = lukija.nextLine();

		System.out.println("Anna pituuspiiri: ");
		String pituuspiiri = lukija.nextLine();

		System.out.println("Anna tontin pinta-ala: ");
		double pinta_ala_tontti = lukija.nextDouble();
		while (pinta_ala_tontti <= 0) {
			System.out.printf("Pinta-ala ei voi olla negatiivinen! Syötä uusi pinta-ala:");
			pinta_ala_tontti = lukija.nextDouble();
		}

		Tontti tontti = new Tontti();
		tontti.setLeveyspiiri(leveyspiiri);
		tontti.setNimi(nimi_tontti);
		tontti.setPinta_ala(pinta_ala_tontti);
		tontti.setPituuspiiri(pituuspiiri);

		// Rakennuksen tietojen kysyminen
		System.out.println("Anna rakennuksen pinta-ala: ");
		double pinta_ala_rakennus = lukija.nextDouble();
		while (pinta_ala_rakennus <= 0) {
			System.out.printf("Pinta-ala ei voi olla negatiivinen! Syötä uusi pinta-ala:");
			pinta_ala_rakennus = lukija.nextDouble();
		}

		System.out.println("Anna huoneiden lukumäärä: ");
		double huoneet = lukija.nextDouble();

		Rakennus rakennus = new Rakennus();
		rakennus.setPinta_ala(pinta_ala_rakennus);
		rakennus.setHuoneiden_lkm(huoneet);
		Asukas asukas = new Asukas();

		//Kysytään asukkaiden määrä, jotta voidaan kysyä oikea määrä syntymäpäiviä.
		//Tämä tuntui helpoimmalta tavalta
		System.out.println("Montako ihmistä asuu talossa?");
		int lukumaara = lukija.nextInt();
		lukija.nextLine();
		for (int i = 1; i <= lukumaara; i++) {
			System.out.println("Anna asukkaan nimi:");
			String nimi = lukija.nextLine();
			asukas.setNimi(nimi);
			if (nimi.length() != 0) {
				System.out.println("Anna asukkaan " + nimi + " syntymäpäivä:");
				String syntymapaiva = lukija.nextLine();
				asukas.setSyntymapaiva(syntymapaiva);
				rakennus.setAsukkaat(nimi);
			}
		}

		//Tulostetaan tontin tiedot
		System.out.println("*****Tontin tiedot*****");
		System.out.println("Leveyspiiri: " + tontti.getLeveyspiiri());
		System.out.println("Pituuspiiri: " + tontti.getPituuspiiri());
		System.out.println("Nimi: " + tontti.getNimi());
		System.out.println("Pinta-ala: " + tontti.getPinta_ala());

		// Tulostetaan rakennuksen ja asukkaiden tiedot
		System.out.println();
		System.out.println("***Rakennuksen tiedot***");
		System.out.println("Pinta-ala: " + rakennus.getPinta_ala());
		System.out.println("Huoneiden lukumäärä: " + rakennus.getHuoneiden_lkm());
		System.out.println("Asukkaat: " + rakennus.getAsukkaat());

		// Tulostetaan asukkaiden tiedot muodossa nimi1: paiva1, nimi2: paiva2, jne...
		System.out.println();
		System.out.println("****Asukkaiden tiedot****");
		System.out.println(asukas.getAsukas());
		lukija.close();
	}
}
