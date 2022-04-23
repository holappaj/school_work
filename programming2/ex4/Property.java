public class Property {
	private String tyyppi;
	private String sijainti;
	
	public Property(String tyyppi, String sijainti) {
		this.tyyppi = tyyppi;
		this.sijainti = sijainti;
	}
	public String getTyyppi() {
		return tyyppi;
	}
	public void setTyyppi(String tyyppi) {
		this.tyyppi = tyyppi;
	}
	public String getSijainti() {
		return sijainti;
	}
	public void setSijainti(String sijainti) {
		this.sijainti = sijainti;
	}
	public String toString() {
        return "\n\nProperty type: " + this.tyyppi + "\nProperty location: " + this.sijainti + "\n";
    }
	
}
