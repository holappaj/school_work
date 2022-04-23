public class InsuranceInfo {
	private double vakuutusarvo;
	private Property InsInfProperty;
	
	public InsuranceInfo(double vakuutusarvo, Property insInfProperty) {
		this.vakuutusarvo = vakuutusarvo;
		this.InsInfProperty = insInfProperty;
	}

	public double getVakuutusarvo() {
		return vakuutusarvo;
	}

	public void setVakuutusarvo(double vakuutusarvo) {
		this.vakuutusarvo = vakuutusarvo;
	}

	public Property getInsInfProperty() {
		return InsInfProperty;
	}

	public void setInsInfProperty(Property insInfProperty) {
		InsInfProperty = insInfProperty;
	}
	
	public String toString() {
        return InsInfProperty.toString() + "\n" + "Insurance Value: " + this.vakuutusarvo + "euros";
    }
}
