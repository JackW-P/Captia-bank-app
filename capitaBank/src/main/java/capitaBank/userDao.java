package capitaBank;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


import com.mysql.jdbc.PreparedStatement;

public class userDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	//insert a new user into the database
	public void insertUser(int a, String b, String c, double d, String e) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/capitaBank","root","password");
			String sql = "insert into users(account_id, first_name, last_name,account_balance, account_type) values(?,?,?,?,?)";
			
			java.sql.PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, a);
			statement.setString(2, b);
			statement.setString(3, c);
			statement.setDouble(4, d);
			statement.setString(5, e);
			
			
			int rows = statement.executeUpdate();
			
			if(rows>0) {
				System.out.println("A new user has been inserted");
			}
			
		} catch (Exception f) {
			f.printStackTrace();
		}
		
	}
	
	
	//gets users name from the database
	public void getName() {
		try {
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/capitaBank","root","password");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from users");
			while(resultSet.next()) {
				System.out.println(resultSet.getString("first_name"));
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		}
	
	public void updateBalance(double a, int b) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/capitaBank","root","password");
			String sql = "update users set account_balance =? where account_id=?";
			
			java.sql.PreparedStatement statement = connection.prepareStatement(sql);
			statement.setDouble(1, a);
			statement.setInt(2, b);
			int row = statement.executeUpdate();
			if(row>0) {
				System.out.println("A user has been updated");
			}
			
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	//delete user
	public void deleteUser(String a) {
		try {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/capitaBank","root","password");
		String sql = "delete from users where first_name = ?";
		
		java.sql.PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, a);
		int row = statement.executeUpdate();
		if(row>0) {
			System.out.println("A user has been deleted");
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
		
	}


