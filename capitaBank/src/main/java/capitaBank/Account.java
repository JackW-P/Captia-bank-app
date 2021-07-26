package capitaBank;

public class Account {
	private final int account_Id;
	private static int nextAccountId = 1;
	protected double balance;
	
	
	public Account() {
		account_Id = nextAccountId;
		nextAccountId++;
	}
	
	public double withdraw(double amount) {
		userDao d = new userDao();
		balance -= amount;
		d.updateBalance(balance, getAccountId());
		return amount;
		
	}
	
	public void deposit(double amount) {
		userDao d = new userDao();
		balance += amount;
		d.updateBalance(balance, getAccountId());
	}
	
	public double getBalance(){
		return balance;
	}
	
	public void transfer(Account a,double amount) {
		userDao d = new userDao();
		a.deposit(amount);
		balance -=amount;
		d.updateBalance(balance, getAccountId());
	}
	
	public void correctBalance(double amount) {
		balance = amount;
	}
	
	public int getAccountId() {
		return account_Id;
	}
}
