package oh2_kt5;

import java.util.ArrayList;

public class Kerrostalo extends Rakennus{

	public Kerrostalo(double asuntojen_lkm, ArrayList<Asunto> asunnot) {
		super(asuntojen_lkm, asunnot);
	}

	@Override
	public String toString() {
		return "Kerrostalo, Asuntojen lukum‰‰r‰: " + getAsuntojen_lkm() + "\n";
	}
	
	
}