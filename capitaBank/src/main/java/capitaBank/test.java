package capitaBank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Account_controller ac = new Account_controller();
//		Customer c1 = new Customer("Bob",,);
//		Account a1 = ac.createAccount(c1,accountType.SAVINGS);
//		a1.deposit(10.00);
//		Customer c2 = new Customer(,"John");
//		Account a2 = ac.createAccount(c2,accountType.CHECKING);
//		a2.deposit(100.00);
//		a2.transfer(a1, 20.00);
//		a2.withdraw(40.00);
//		System.out.println(a1.getAccountId());
//		userDao d = new userDao();
//		d.updateBalance(10.00, a1.getAccountId());
//		c1.deposit(10.00);
//		System.out.println(a1.getAccountId());
//		a1.deposit(10.00);
//		ac.removeCustomer(c1);
		
//		getAccount("Bob");
//		AccountDAO d = new AccountDAO();
//		d.insertUser(1, "bob", "alan", 0, "SAVINGS");
//		getAccount("alex");
}
	
//	public static void getAccount(String a) {
//try {
//			
//			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/capitaBank","root","password");
//			
//			String sql = "select * from users where first_name = ?";
//			
//			java.sql.PreparedStatement statement = connection.prepareStatement(sql);
//			statement.setString(1, a);
//			ResultSet result = statement.executeQuery();
////			statement.executeQuery();
//			
//			while(result.next()) {
//				
//				String first_name = result.getString("first_name");
//				String last_name = result.getString("last_name");
//				String account_type = result.getString("account_type");
//				AccountType e = AccountType.valueOf(account_type);
//				
//				System.out.println(first_name + last_name + e);
//				
//			}
//					
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}

	}

