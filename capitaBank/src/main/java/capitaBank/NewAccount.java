package capitaBank;

public class NewAccount {
	
	private static int nextAccountId = 1;
	
	private final int accountId;
	private final Customer customer;
		
	public NewAccount(Customer customer) {
		this.accountId = nextAccountId;
		this.customer = customer;
		nextAccountId++;
	}

	public int getAccountId() {
		return accountId;
	}

	public Customer getCustomer() {
		return customer;
	}


}
