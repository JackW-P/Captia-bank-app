package capitaBank;

import java.util.ArrayList;
import java.util.List;

public class Account_controller {
	private List<Customer> customers = new ArrayList<>();
    private List<Account> accounts = new ArrayList<>();
    private String name;
    private String address;
    private accountType accountType;
    private Customer cust;
   
    
    public Customer createCustomer(String firstName, String lastName, String accountType) {
    	Customer c = new Customer(firstName, lastName, accountType );
    	customers.add(c);
    	return null;
    }
    
    public Account createAccount(Customer c, accountType a) {
    	userDao d = new userDao();
    	
    	if(a == accountType.CHECKING) {
    		checkingAccount acc = new checkingAccount();
    		accounts.add(acc);
    		c.addAccount(acc);
    		d.insertUser(acc.getAccountId(),c.getFirstName(), c.getLastName(),0.0, "CHECKING");
    		return acc;
    	} else if(a == accountType.SAVINGS) {
    		savingAccount s = new savingAccount();
    		accounts.add(s);
    		c.addAccount(s);
    		d.insertUser(s.getAccountId(),c.getFirstName(), c.getLastName(), 0.0, "SAVINGS");
    		return s;
    	}
    	return null;
    }
    
    public void getAccount() {
    	for(Account i:accounts) {
    		System.out.println(i);
    	}
    }
    
    
    public void removeAccount(Account a) {
    	accounts.remove(a);
    	for(Customer i:customers) {
    		cust = i;
    		cust.removeAccount(a);
    	}
    }
    
    public void removeCustomer(Customer c) {
    	customers.remove(c);
    	List<Account> list = c.getAccount();
    	for(Account i:list) {
    		if(accounts.contains(i)) {
    			accounts.remove(i);
    		}
    	}
    	userDao d = new userDao();
    	d.deleteUser(c.getFirstName());
    }
}
