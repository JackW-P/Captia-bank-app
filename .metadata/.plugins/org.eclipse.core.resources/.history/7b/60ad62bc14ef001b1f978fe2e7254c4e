package capitaBank;

public class savingAccount extends Account{
	
	private double interestRate; 
	
	public double withdraw(double amount) {
		if(amount > balance) {
			return 0;
		} else {
			balance -= amount;
			return amount;
		}
	}
	
	public void addInterest() {
		double balanceInterest = balance * (interestRate/100);
		balance = balance + balanceInterest;
	}
	
	public double getInterestRate() {
		return interestRate;
	}
	
	public void setInterestRate(double rate) {
		
		interestRate = rate;
	}
}
