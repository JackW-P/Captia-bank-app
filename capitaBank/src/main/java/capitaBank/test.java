package capitaBank;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account_controller ac = new Account_controller();
		Customer c1 = new Customer("Bob","Alan","Road");
		Account a1 = ac.createAccount(c1,accountType.SAVINGS);
		a1.deposit(10.00);
		Customer c2 = new Customer("Alex","John","Road");
		Account a2 = ac.createAccount(c2,accountType.CHECKING);
		a2.deposit(100.00);
//		a2.transfer(a1, 20.00);
		a2.withdraw(40.00);
//		System.out.println(a1.getAccountId());
//		userDao d = new userDao();
//		d.updateBalance(10.00, a1.getAccountId());
//		c1.deposit(10.00);
//		System.out.println(a1.getAccountId());
//		a1.deposit(10.00);
//		ac.removeCustomer(c1);
		
	}

}
