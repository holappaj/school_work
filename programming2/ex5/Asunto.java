package oh2_kt5;
import java.util.ArrayList;

public class Asunto {
	private double asunnon_pinta_ala;
	private int huoneiden_lkm;
	private ArrayList<Asukas> asukit = new ArrayList<Asukas>();
	
	public Asunto(double asunnon_pinta_ala, int huoneiden_lkm, ArrayList<Asukas> asukkaat) {
		this.asunnon_pinta_ala = asunnon_pinta_ala;
		this.huoneiden_lkm = huoneiden_lkm;
		this.asukit.addAll(asukkaat);
	}
	public double getAsunnon_pinta_ala() {
		return asunnon_pinta_ala;
	}
	public void setAsunnon_pinta_ala(double asunnon_pinta_ala) {
		this.asunnon_pinta_ala = asunnon_pinta_ala;
	}
	public int getHuoneiden_lkm() {
		return huoneiden_lkm;
	}
	public void setHuoneiden_lkm(int huoneiden_lkm) {
		this.huoneiden_lkm = huoneiden_lkm;
	}
	public ArrayList<Asukas> getAsukit() {
		return asukit;
	}
	public void setAsukit(ArrayList<Asukas> asukit) {
		this.asukit = asukit;
	}
	
	@Override
	public String toString() {
		return "\npinta-ala=" + asunnon_pinta_ala + " huoneiden lukumäärä=" + huoneiden_lkm + " asukit=" + asukit;
	}
	
}
