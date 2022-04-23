package oh2_kt5;

import java.util.ArrayList;

public class Omakotitalo extends Rakennus{

	public Omakotitalo(double asuntojen_lkm, ArrayList<Asunto> asunnot) {
		super(asuntojen_lkm, asunnot);
	}

	@Override
	public String toString() {
		return "Omakotitalo, Asuntojen lukum‰‰r‰: " + getAsuntojen_lkm() + "\n";
	}
	
	
}