package capitaBank;

public class Account {	
	private final int accountId;
	private final Customer customer;
	
	protected double funds;
	
	public Account(int accountId, Customer customer, double funds) {
		this.accountId = accountId;
		this.customer = customer;
		this.funds = funds;
	}
	
	//get the id number for the account
	public int getAccountId() {
		return accountId;
	}
	
	//withdraw money
	public double withdraw(double amount) {
		AccountDAO d = new AccountDAO();
		funds -= amount;
		d.updateBalance(funds, getAccountId());
		return amount;
		
	}
	
	//deposit money
	public void deposit(double amount) {
		AccountDAO d = new AccountDAO();
		funds += amount;
		d.updateBalance(funds, accountId);
	}
	
	//get balance in account
	public double getFunds(){
		return funds;
	}
	
	//transfer money from this account to another account
	public void transfer(Account accountToTransfer, double amount) {
		AccountDAO userDAO = new AccountDAO();
		accountToTransfer.deposit(amount);
		funds -=amount;
		userDAO.updateBalance(funds, accountId);
	}
}
