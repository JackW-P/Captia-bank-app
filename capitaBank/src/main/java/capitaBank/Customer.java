package capitaBank;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private long customer_Id;
	private static long nextCustomerId = 100;
	private String firstName;
	private String lastName;
	private String address;
	private Account acc;
	
	private ArrayList<Account> accounts = new ArrayList<>();
	
	public Customer(String firstName,String lastName, String address) {
		super();
		customer_Id = nextCustomerId;
		nextCustomerId+=10;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}
	
	public void addAccount(Account account) {
		accounts.add(account);
		
	}
	
	public List<Account> getAccount(){
		return accounts;
	}
	
	public void removeAccount(Account account) {
		accounts.remove(account);
	}
	
	public void printAccount() {
		for(Account i:accounts) {
			System.out.println(i);
		}
	}
	

	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setFirstName(String name) {
		this.firstName = name;
	}
	
	public void setLastName(String name) {
		this.lastName = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public long getCustomerId() {
		return customer_Id;
	}
}
