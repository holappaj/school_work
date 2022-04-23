package oh2_kt2;

public class Tontti {
	private String nimi, leveyspiiri, pituuspiiri;
	private double pinta_ala;
	
	//Getterit ja setterit
	public String getNimi() {
		return nimi;
	}
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	public String getLeveyspiiri() {
		return leveyspiiri;
	}
	public void setLeveyspiiri(String leveyspiiri) {
		this.leveyspiiri = leveyspiiri;
	}
	public String getPituuspiiri() {
		return pituuspiiri;
	}
	public void setPituuspiiri(String pituuspiiri) {
		this.pituuspiiri = pituuspiiri;
	}
	public double getPinta_ala() {
		return pinta_ala;
	}
	public void setPinta_ala(double pinta_ala) {
			this.pinta_ala = pinta_ala;
	}
}