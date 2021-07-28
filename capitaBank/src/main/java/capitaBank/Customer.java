package capitaBank;

public class Customer {
	
	private static long nextCustomerId = 100;
	
	private final long customerId;
	private final String firstName;
	private final String lastName;
		
	/**
	 * Create a new customer that is not inserted into the DB
	 * @param firstName
	 * @param lastName
	 */
	public Customer(String firstName, String lastName) {
		customerId = nextCustomerId;
		nextCustomerId+=10;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	/**
	 * Create a new customer given we know the customer id
	 * @param customerId
	 * @param firstName
	 * @param lastName
	 */
	public Customer(long customerId, String firstName, String lastName) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public long getCustomerId() {
		return customerId;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
}
