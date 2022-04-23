package oh2_kt2;
import java.util.ArrayList;

public class Asukas {
	private ArrayList<String> nimetPaivat = new ArrayList<>();
	private String nimi, syntymapaiva;

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getSyntymapaiva() {
		return syntymapaiva;
	}

	public void setSyntymapaiva(String syntymapaiva) {
		this.syntymapaiva = syntymapaiva;
		tee_lista(nimi, syntymapaiva);
	}
	//Luodaan tässä helposti luettava pohja asukkaiden tiedoille
	public void tee_lista(String henkilo, String paiva) {
		this.nimetPaivat.add(henkilo + ": " + paiva);
	}
	public ArrayList<String> getAsukas() {
		return nimetPaivat;
	}
}
