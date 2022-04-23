import java.util.ArrayList;
import java.util.Scanner;

public class Vt4main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<InsuranceInfo> infoList = new ArrayList<InsuranceInfo>();
		InsInfoContainer insInfoContainer = new InsInfoContainer(infoList);
		System.out.println("You need to add at least 5 properties");
		System.out.println("The number of properties you want to add: ");
		int quantity = scanner.nextInt();
		while (quantity < 5) {
			System.out.println("Minimum number is 5");
			System.out.println("Give new number of properties:");
			quantity = scanner.nextInt();
		}
		for (int i=0; i < quantity; i++) {
			scanner.nextLine();
			System.out.println("Inputting info for property " + (i+1));
			System.out.println("Input type of property: ");
			String propertyType = scanner.nextLine();
			
			System.out.println("Input location of property: ");
			String propertyLocation = scanner.nextLine();
			
			System.out.println("Input insurance value of property: ");
			double insuranceValue = scanner.nextDouble();
			while (insuranceValue < 0) {
				System.out.println("Insurance value must be positive! Give new value: ");
				insuranceValue = scanner.nextDouble();
			}
			
			InsuranceInfo insInfo = new InsuranceInfo(insuranceValue, new Property(propertyType, propertyLocation));
			insInfoContainer.addInfoContainer(insInfo);
			System.out.println("");	
		}
		
		System.out.println("Will now print all the propety info");
		insInfoContainer.printInfoList();
		
		scanner.nextLine();
		System.out.println("Give a insurance value. Will retrive insurance values over: ");
		double value = scanner.nextDouble();
		while (value < 0) {
			System.out.println("Can't be negative. Give new value: ");
			value = scanner.nextDouble();
		}
		insInfoContainer.printOverValue(value);
		
		scanner.nextLine();
		System.out.println("Give a insurance value. Will retrive insurance values under: ");
		double valueUnder = scanner.nextDouble();
		while (valueUnder < 0) {
			System.out.println("Can't be negative. Give new value: ");
			valueUnder = scanner.nextDouble();
		}
		insInfoContainer.printValueUnder(valueUnder);
		scanner.close();
	}
}
