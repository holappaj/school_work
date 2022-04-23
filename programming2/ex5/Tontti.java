package oh2_kt5;

public class Tontti {
	private String nimi, osoite;
	private double pinta_ala;
	private Rakennus rakennus;
	
	
	public Tontti (String nimi, String osoite, double pinta_ala, Rakennus rakennus) {
		this.nimi = nimi;
		this.osoite = osoite;
		this.pinta_ala = pinta_ala;
		this.rakennus = rakennus;
	}
	//Getterit ja setterit
	public String getNimi() {
		return nimi;
	}
	public String getOsoite() {
		return osoite;
	}
	public void setOsoite(String osoite) {
		this.osoite = osoite;
	}
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public double getPinta_ala() {
		return pinta_ala;
	}
	public void setPinta_ala(double pinta_ala) {
			this.pinta_ala = pinta_ala;
	}
	
	public Rakennus getRakennus() {
		return rakennus;
	}
	public void setRakennus(Rakennus rakennus) {
		this.rakennus = rakennus;
	}
	public String toString() {
        return "\n\nTontin nimi: " + this.nimi + "\nTontin osoite: " + this.osoite + "\nTontin pinta-ala: " + this.pinta_ala + "\n";
    }
}