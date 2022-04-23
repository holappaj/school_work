public class RegularSubscription extends Subscription {
	private int length;
	
	public RegularSubscription(String magazine, String subscriber, String address, double monthly_fee, int length) {
		super(magazine, subscriber, address, monthly_fee);
		this.length = length;
	}

	public int getLength() {
		return length;
	}

	public void printInvoice() {
		System.out.println("");
		System.out.println("This is the invoice for your regular subscription");
		System.out.println("Magazine name: " + getMagazine());
		System.out.println("Subscriber's name: " + getSubscriber());
		System.out.println("Subscriber's address: " + getAddress());
		System.out.println("Length of subscription: " + getLength() + " months");
		System.out.println("Price: " + (getLength() * getMonthly_fee()));
	}
}
