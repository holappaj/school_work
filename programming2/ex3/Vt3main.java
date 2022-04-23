import java.util.Scanner;

public class Vt3main {
	public static void main(String[] args) {
		Scanner lukija = new Scanner(System.in);
		
		// Here we do a regular subscription
		System.out.println("Create your regular subscription below");
		System.out.println("What magazine do you want to order? Journal name: ");
		String magazinename = lukija.nextLine();
		
		System.out.println("What is the subscriber's name? Name: ");
		String name = lukija.nextLine();
		
		System.out.println("Give your address: ");
		String address = lukija.nextLine();
		
		System.out.println("Give monthly fee: ");
		double fee = lukija.nextDouble();
		while (fee <= 0) {
			System.out.printf("The monthly fee can't be negative! Give a new fee: ");
			fee = lukija.nextDouble();
		}
		System.out.println("Give subscription length: ");
		int length = lukija.nextInt();
		while (length <= 0) {
			System.out.printf("The length can't be negative! Give new subscription length in months: ");
			length = lukija.nextInt();
		}
		Subscription regSubscription = new RegularSubscription(magazinename, name, address, fee, length);
		printSubscriptionInvoice(regSubscription);

		// HERE WO DO A STANDING SUBSCRPTION	
		System.out.println("");
		System.out.println("");
		
		//Clearing input
		lukija.nextLine();
		System.out.println("Create your Standing Subscription below");
		System.out.println("What magazine do you want to order? Journal name: ");
		String magazinename2 = lukija.nextLine();
		
		System.out.println("What is the subscriber's name? Name: ");
		String name2 = lukija.nextLine();
		
		System.out.println("Give your address: ");
		String address2 = lukija.nextLine();
		
		System.out.println("Give monthly fee: ");
		double fee2 = lukija.nextDouble();
		while (fee <= 0) {
			System.out.printf("The monthly fee can't be negative! Give a new fee: ");
			fee = lukija.nextDouble();
		}
		System.out.println("Give discount percentage: ");
		int discount = lukija.nextInt();
		while ((discount < 0) || (discount > 100)) {
			System.out.printf("The discount must be between 0 and 100! Give new discount: ");
			discount = lukija.nextInt();
		}
		lukija.close();
		Subscription standSubscription = new StandingSubscription(magazinename2, name2, address2, fee2, discount);
		printSubscriptionInvoice(standSubscription);
	}
	
	static void printSubscriptionInvoice(Subscription subs) {
		if (subs instanceof RegularSubscription) {
			((RegularSubscription) subs).printInvoice();
		}
		else if (subs instanceof StandingSubscription) {
			((StandingSubscription) subs).printInvoice();
		}
	}
}
