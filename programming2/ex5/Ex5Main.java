package oh2_kt5;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex5Main {
	public static void main(String[] args) {
		Scanner lukija = new Scanner(System.in);
		ArrayList<Asukas> asukkaat = new ArrayList<Asukas>();
		ArrayList<Asunto> asunnot = new ArrayList<Asunto>();
		ArrayList<Tontti> tontit = new ArrayList<Tontti>();
		Asukas asukas = new Asukas(null);
		
		
		// Tontin tietojen kysyminen
		System.out.println("Luot nyt kerrostaloa");
		System.out.println("Anna tontin nimi: ");
		String nimi_tontti = lukija.nextLine();

		System.out.println("Anna tontin pinta-ala: ");
		double pinta_ala_tontti = lukija.nextDouble();
		while (pinta_ala_tontti <= 0) {
			System.out.printf("Pinta-ala ei voi olla negatiivinen! Sy�t� uusi pinta-ala:");
			pinta_ala_tontti = lukija.nextDouble();
		}
		lukija.nextLine();
		
		System.out.println("Anna tontin osoite: ");
		String osoite = lukija.nextLine();
		System.out.println("Anna asuntojen lukum��r�: ");
		int asunto_lkm = lukija.nextInt();
		
		while (asunto_lkm < 2) {
			System.out.println("Kerrostalossa on pakko olla v�hint��n 2 asuntoa. Sy�t� uusi lukum��r�: ");
			asunto_lkm = lukija.nextInt();
		}
		
		// Nyt kysyt��n asuntokohtaiset tiedot
		for (int i = 0; i < asunto_lkm; i++) {
			// Pinta-ala
			System.out.println("Sy�t� asunnon " + (i+1) + " pinta-ala: ");
			double pinta_ala = lukija.nextDouble();
			while (pinta_ala < 0) {
				System.out.println("Asunnon pinta-alan pit�� olla positiivinen");
				pinta_ala = lukija.nextDouble();
			}
			
			// Huoneet
			System.out.println("Sy�t� asunnon " + (i+1) + " huonneiden m��r�: ");
			int huoneet = lukija.nextInt();
			while (huoneet < 0) {
				System.out.println("Huoneita on pakko olla v�hint��n yksi. Sy�te uusi lukum��r�: ");
				huoneet = lukija.nextInt();
			}
			
			// Asukkaat
			System.out.println("Sy�t� asunnon " + (i+1) + " asukaiden lukum��r�: ");
			int asukas_lkm = lukija.nextInt();
			while (asukas_lkm < 1) {
				System.out.println("Asunnossa oltava v�hint��n yksi asukas! Anna uusi asukkaiden lukum��r�: ");
				asukas_lkm = lukija.nextInt();
			}
			lukija.nextLine();
			for (int j = 0; j < asukas_lkm; j++) {
				System.out.println("Anna asukkaan " + (j+1) + " nimi: ");
				String nimi = lukija.nextLine();
				asukas = new Asukas(nimi);
				asukkaat.add(asukas);
			}
			asunnot.add(new Asunto(pinta_ala, huoneet, asukkaat));
			Tontti kerrostaloTontti = new Tontti(nimi_tontti, osoite, pinta_ala_tontti, new Kerrostalo(asunto_lkm, asunnot));
			tontit.add(kerrostaloTontti);
			// Tulostetaan kerrostalon tiedot
			asukkaat.clear();
			if (i == (asunto_lkm - 1)) {
				System.out.println(kerrostaloTontti);
				System.out.println("Rakennuksen tyyppi: " + kerrostaloTontti.getRakennus() + "\n");
				System.out.println("***Asuntojen tiedot***");
				System.out.println(asunnot);

				System.out.println("\n\n");
				
			}

		}

		// Nyt luodaan rivitalo
		asukkaat.clear();
		asunnot.clear();
		System.out.println("Luot nyt rivitaloa");
		System.out.println("Anna tontin nimi: ");
		String nimi_tontti1 = lukija.nextLine();

		System.out.println("Anna tontin pinta-ala: ");
		double pinta_ala_tontti1 = lukija.nextDouble();
		while (pinta_ala_tontti1 <= 0) {
			System.out.printf("Pinta-ala ei voi olla negatiivinen! Sy�t� uusi pinta-ala:");
			pinta_ala_tontti1 = lukija.nextDouble();
		}
		lukija.nextLine();
		
		System.out.println("Anna tontin osoite: ");
		String osoite1 = lukija.nextLine();
		System.out.println("Anna asuntojen lukum��r�: ");
		int asunto_lkm1 = lukija.nextInt();
		
		while (asunto_lkm1 < 2) {
			System.out.println("Rivitalossa on pakko olla v�hint��n 2 asuntoa. Sy�t� uusi lukum��r�: ");
			asunto_lkm1 = lukija.nextInt();
		}
		
		// Nyt kysyt��n asuntokohtaiset tiedot
		for (int i = 0; i < asunto_lkm1; i++) {
			// Pinta-ala
			System.out.println("Sy�t� asunnon " + (i+1) + " pinta-ala: ");
			double pinta_ala1 = lukija.nextDouble();
			while (pinta_ala1 < 0) {
				System.out.println("Asunnon pinta-alan pit�� olla positiivinen");
				pinta_ala1 = lukija.nextDouble();
			}
			
			// Huoneet
			System.out.println("Sy�t� asunnon " + (i+1) + " huonneiden m��r�: ");
			int huoneet1 = lukija.nextInt();
			while (huoneet1 < 0) {
				System.out.println("Huoneita on pakko olla v�hint��n yksi. Sy�te uusi lukum��r�: ");
				huoneet1 = lukija.nextInt();
			}
			
			// Asukkaat
			System.out.println("Sy�t� asunnon " + (i+1) + " asukaiden lukum��r�: ");
			int asukas_lkm1 = lukija.nextInt();
			while (asukas_lkm1 < 1) {
				System.out.println("Asunnossa oltava v�hint��n yksi asukas! Anna uusi asukkaiden lukum��r�: ");
				asukas_lkm1 = lukija.nextInt();
			}
			lukija.nextLine();
			for (int j = 0; j < asukas_lkm1; j++) {
				System.out.println("Anna asukkaan " + (j+1) + " nimi: ");
				String nimi = lukija.nextLine();
				asukas = new Asukas(nimi);
				asukkaat.add(asukas);
			}
			asunnot.add(new Asunto(pinta_ala1, huoneet1, asukkaat));
			Tontti rivitaloTontti = new Tontti(nimi_tontti1, osoite1, pinta_ala_tontti1, new Rivitalo(asunto_lkm1, asunnot));
			tontit.add(rivitaloTontti);
			// Tulostetaan kerrostalon tiedot
			asukkaat.clear();
			if (i == (asunto_lkm1 - 1)) {
				System.out.println(rivitaloTontti);
				System.out.println("Rakennuksen tyyppi: " + rivitaloTontti.getRakennus() + "\n");
				System.out.println("***Asuntojen tiedot***");
				System.out.println(asunnot);

				System.out.println("\n\n");
				
			}

		}
		
		// Nyt luodaan omakotitalo
		asukkaat.clear();
		asunnot.clear();
		System.out.println("Luot nyt omakotitaloa");
		System.out.println("Anna tontin nimi: ");
		nimi_tontti1 = lukija.nextLine();

		System.out.println("Anna tontin pinta-ala: ");
		pinta_ala_tontti1 = lukija.nextDouble();
		while (pinta_ala_tontti1 <= 0) {
			System.out.printf("Pinta-ala ei voi olla negatiivinen! Sy�t� uusi pinta-ala:");
			pinta_ala_tontti1 = lukija.nextDouble();
		}
		lukija.nextLine();
		
		System.out.println("Anna tontin osoite: ");
		osoite1 = lukija.nextLine();
		System.out.println("Anna asuntojen lukum��r�: ");
		asunto_lkm1 = lukija.nextInt();
		
		while (asunto_lkm1 > 2 || asunto_lkm1 < 1) {
			System.out.println("Omakotitalo on joko yksin�inen tai paritalo. Sy�t� uusi lukum��r�: ");
			asunto_lkm1 = lukija.nextInt();
		}
		
		// Nyt kysyt��n asuntokohtaiset tiedot
		for (int i = 0; i < asunto_lkm1; i++) {
			//ArrayList<Asukas> asukkaat = new ArrayList<Asukas>();
			//ArrayList<Asunto> asunnot = new ArrayList<Asunto>();
			// Pinta-ala
			System.out.println("Sy�t� asunnon " + (i+1) + " pinta-ala: ");
			double pinta_ala1 = lukija.nextDouble();
			while (pinta_ala1 < 0) {
				System.out.println("Asunnon pinta-alan pit�� olla positiivinen");
				pinta_ala1 = lukija.nextDouble();
			}
			
			// Huoneet
			System.out.println("Sy�t� asunnon " + (i+1) + " huonneiden m��r�: ");
			int huoneet1 = lukija.nextInt();
			while (huoneet1 < 0) {
				System.out.println("Huoneita on pakko olla v�hint��n yksi. Sy�te uusi lukum��r�: ");
				huoneet1 = lukija.nextInt();
			}
			
			// Asukkaat
			System.out.println("Sy�t� asunnon " + (i+1) + " asukaiden lukum��r�: ");
			int asukas_lkm1 = lukija.nextInt();
			while (asukas_lkm1 < 1) {
				System.out.println("Asunnossa oltava v�hint��n yksi asukas! Anna uusi asukkaiden lukum��r�: ");
				asukas_lkm1 = lukija.nextInt();
			}
			lukija.nextLine();
			for (int j = 0; j < asukas_lkm1; j++) {
				System.out.println("Anna asukkaan " + (j+1) + " nimi: ");
				String nimi = lukija.nextLine();
				asukas = new Asukas(nimi);
				asukkaat.add(asukas);
			}
			asunnot.add(new Asunto(pinta_ala1, huoneet1, asukkaat));
			Tontti omakotitaloTontti = new Tontti(nimi_tontti1, osoite1, pinta_ala_tontti1, new Omakotitalo(asunto_lkm1, asunnot));
			tontit.add(omakotitaloTontti);
			// Tulostetaan kerrostalon tiedot
			asukkaat.clear();
			if (i == (asunto_lkm1 - 1)) {
				System.out.println(omakotitaloTontti);
				System.out.println("Rakennuksen tyyppi: " + omakotitaloTontti.getRakennus() + "\n");
				System.out.println("***Asuntojen tiedot***");
				System.out.println(asunnot);

				System.out.println("\n\n");
				
			}
		}
		
		
		lukija.close();
	}
}