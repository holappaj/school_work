import java.util.ArrayList;

public class InsInfoContainer {
	private ArrayList<InsuranceInfo> infoList;
	
	public InsInfoContainer(ArrayList<InsuranceInfo> infoList) {
		this.infoList = infoList;
	}
	
	//add info
	public void addInfoContainer(InsuranceInfo infoSet) {
		this.infoList.add(infoSet);
	}
	public void printInfoList() {
		System.out.println("****Printing List****");
		System.out.println(infoList);
	}
	public void printOverValue(double value) {
		System.out.println("\n\nPrinting insurance values over " + value);
		for (InsuranceInfo insInfo: infoList) {
			if (value < insInfo.getVakuutusarvo()) {
				System.out.println(insInfo.getInsInfProperty() + "Insurance value: " +insInfo.getVakuutusarvo());
			}
		}		
	}
	
	public void printValueUnder(double value) {
		System.out.println("\n\nPrinting insurance values under " + value);
		for (InsuranceInfo insInfo: infoList) {
			if (value > insInfo.getVakuutusarvo()) {
				System.out.println(insInfo.getInsInfProperty() + "Insurance value: " +insInfo.getVakuutusarvo());
			}
		}
	}
}