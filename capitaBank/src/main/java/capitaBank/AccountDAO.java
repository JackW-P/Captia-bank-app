package capitaBank;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;


//import com.mysql.jdbc.PreparedStatement;

public class AccountDAO {
	
	//insert a new user into the database
	public Account insertAccount(NewAccount newAccount) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/capitaBank","root","password");
			String sql = "insert into users(account_id, first_name, last_name,funds) values(?,?,?,?)";
			
			java.sql.PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, newAccount.getAccountId());
			statement.setString(2, newAccount.getCustomer().getFirstName());
			statement.setString(3, newAccount.getCustomer().getLastName());
			statement.setDouble(4, 0);			
			
			int rows = statement.executeUpdate();
			
			if(rows>0) {
				System.out.println("A new user has been inserted");
			}
			
			return getAccount(newAccount.getAccountId());
			
		} catch (Exception f) {
			f.printStackTrace();
		}
		
		return null;
		
	}
	
	
	//gets users name from the database
	public Account getAccount(int accountId) {
		try {
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/capitaBank","root","password");
			
			String sql = "select * from users where account_id = ?";
			
			java.sql.PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, accountId);
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				
				double funds = result.getDouble("funds");
				String first_name = result.getString("first_name");
				String last_name = result.getString("last_name");
				System.out.println(first_name + last_name);
				
				Customer customer = new Customer(first_name, last_name);
				return new Account(accountId, customer, funds);
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
		}
	
	//update balance in the mysql database
	public void updateBalance(double funds, int accountId) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/capitaBank","root","password");
			String sql = "update users set funds =? where account_id=?";
			
			java.sql.PreparedStatement statement = connection.prepareStatement(sql);
			statement.setDouble(1, funds);
			statement.setInt(2, accountId);
			int row = statement.executeUpdate();
			if(row>0) {
				System.out.println("An account has been updated");
			}
			
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	//delete user
	public void deleteAccount(int accountId) {
		try {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/capitaBank","root","password");
		String sql = "delete from users where account_id = ?";
		
		java.sql.PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, accountId);
		int row = statement.executeUpdate();
		if(row>0) {
			System.out.println("An account has been deleted");
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
		
	}


