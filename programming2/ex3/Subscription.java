public class Subscription {
	private String magazine;
	private String subscriber;
	private String address;
	private double monthly_fee;
	
	public Subscription(String magazine, String subscriber, String address, double monthly_fee) {
		this.magazine = magazine;
		this.subscriber = subscriber;
		this.address = address;
		this.monthly_fee = monthly_fee;
	}

	public String getMagazine() {
		return magazine;
	}

	public void setMagazine(String magazine) {
		this.magazine = magazine;
	}

	public String getSubscriber() {
		return subscriber;
	}

	public void setSubscriber(String subscriber) {
		this.subscriber = subscriber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getMonthly_fee() {
		return monthly_fee;
	}

	public void setMonthly_fee(double monthly_fee) {
		this.monthly_fee = monthly_fee;
	}
}
