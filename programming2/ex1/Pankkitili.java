public class Pankkitili {
	private String tilinumero;
	private String omistaja;
	private double saldo;
	
	public String getTilinumero() {
		return tilinumero;
	}
	public void setTilinumero(String tilinumero) {
		this.tilinumero = tilinumero;
	}
	public String getOmistaja() {
		return omistaja;
	}
	public void setOmistaja(String omistaja) {
		this.omistaja = omistaja;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public void otto(double otto) {
		if ((otto > 0) && (otto <= getSaldo())){
			this.saldo -= otto;
		}
		else if (otto <= 0) { 
			System.out.println("\nNosta positiivinen  summa! ");
		}
		else if (otto >= getSaldo()) {
			System.out.println("\nPankkitili ei voi mennä negatiiviseksi!");
		}
	}
	public void talletus(double talletus) {
		if (talletus > 0) {
			this.saldo += talletus;
		}
		else { 
			System.out.println("Et voi tallettaa negatiivista summaa!");
		}
	}
	@Override
	public String toString() {
		return "Pankkitili [tilinumero=" + tilinumero + ", omistaja=" + omistaja + ", saldo=" + saldo + "]";
	}	
}
