public class StandingSubscription extends Subscription{
	private int discount;

	public StandingSubscription(String magazine, String subscriber, String address, double monthly_fee, int discount) {
		super(magazine, subscriber, address, monthly_fee);
		this.discount = discount;
	}

	public int getDiscount() {
		return discount;
	}


	public void printInvoice() {
		System.out.println("");
		System.out.println("This is the Invoice for the Standing Subscription");
		System.out.println("Magazine name: " + getMagazine());
		System.out.println("Subscriber's name: " + getSubscriber());
		System.out.println("Subscriber's address: " + getAddress());
		System.out.println("Length of subscription: 12");
		System.out.println("Price: " + (12 * getMonthly_fee() * (100 - getDiscount())/100));
	}
}
