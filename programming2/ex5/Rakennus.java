package oh2_kt5;

import java.util.ArrayList;

public class Rakennus {
	private double asuntojen_lkm;
	private String tyyppi;
	private ArrayList<String> asunnot = new ArrayList<>();

	public Rakennus(double asuntojen_lkm, ArrayList<Asunto> asunnot2) {
		this.setAsuntojen_lkm(asuntojen_lkm);
	}

	public String getTyyppi() {
		return tyyppi;
	}

	public void setTyyppi(String tyyppi) {
		this.tyyppi = tyyppi;
	}

	public void setAsunto(String asunto_nimi) {
		this.asunnot.add(asunto_nimi);
	}
	public ArrayList<String> getAsunnot() {
		return this.asunnot;
	}

	public double getAsuntojen_lkm() {
		return asuntojen_lkm;
	}

	public void setAsuntojen_lkm(double asuntojen_lkm) {
		this.asuntojen_lkm = asuntojen_lkm;
	}

	@Override
	public String toString() {
		return "\n\nRakennuksen tyyppi: " + this.tyyppi + "\nAsuntojen lukum‰‰r‰: " + this.asuntojen_lkm + "Asuntojen numerot: " + this.asunnot;
	}

}
