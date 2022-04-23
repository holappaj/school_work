package oh2_kt2;
import java.util.ArrayList;

public class Rakennus {
	private double pinta_ala, huoneiden_lkm;
	private ArrayList<String> asukkaat = new ArrayList<>();

	public double getPinta_ala() {
		return pinta_ala;
	}
	public void setPinta_ala(double pinta_ala) {
			this.pinta_ala = pinta_ala;
	}
	public double getHuoneiden_lkm() {
		return huoneiden_lkm;
	}
	public void setHuoneiden_lkm(double huoneiden_lkm) {
		this.huoneiden_lkm = huoneiden_lkm;
	}

	public void setAsukkaat(String nimi) {
		this.asukkaat.add(nimi);
	}
	public ArrayList<String> getAsukkaat() {
		return asukkaat;
	}

}
