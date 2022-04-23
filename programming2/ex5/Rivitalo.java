package oh2_kt5;

import java.util.ArrayList;

public class Rivitalo extends Rakennus{

	public Rivitalo(double asuntojen_lkm, ArrayList<Asunto> asunnot) {
		super(asuntojen_lkm, asunnot);
	}

	@Override
	public String toString() {
		return "Rivitalo, Asuntojen lukum‰‰r‰: " + getAsuntojen_lkm() + "\n";
	}
	
	
}