package com.fdmgroup.jdbcexercise;

import java.sql.*;

public class ExerciseRunner {

	public static void main(String[] args) {

		try {
			DriverManager.registerDriver(new org.h2.Driver());
			Connection connection = DriverManager.getConnection("jdbc:h2:~/connectionName", "sa", "");
			System.out.println("connected");

			Statement statement = connection.createStatement();
			statement.execute("drop table TPUsers if exists;");
			statement.execute("create table TPUsers(userId number(6), username varchar2(20),"
					+ "password varchar2(20), firstName varchar2(20), lastName varchar2, email varchar2, "
					+ "role varchar2(20), status varchar2(20));");
			
			
			
			statement.executeUpdate("insert into TPUsers(userId, username, password, firstName, lastName, email, role, status)"
					+ " values (1, 'dominicpau', 'lolol123', 'dominic', 'pau', 'dom_pau@live.co.uk', 'trainee', 'unemployed');");
			statement.executeUpdate("insert into TPUsers(userId, username, password, firstName, lastName, email, role, status)"
					+ " values (2, 'charlielee', 'lolol123', 'charlie', 'lee', 'charlie_lee@kent.ac.uk', 'sales', 'employed');");
			statement.executeUpdate("insert into TPUsers(userId, username, password, firstName, lastName, email, role, status)"
					+ " values (3, 'victordiep', 'lolol123', 'victor', 'diep', 'victor_diep@kent.ac.uk', 'trainee', 'unemployed');");



			statement.executeUpdate("commit;");

			ResultSet resultSet = statement.executeQuery("select userId,username,password,firstName,lastName,email,"
					+ "role,status from TPUsers");
			
			while (resultSet.next()) {
				
				int idNumber = resultSet.getInt("userId");
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				String firstName = resultSet.getString("firstName");
				String lastName = resultSet.getString("lastName");
				String email = resultSet.getString("email");
				String role = resultSet.getString("role");
				String status = resultSet.getString("status");
				
				User user = new User();
				user.setUserId(idNumber);
				user.setUsername(username);
				user.setPassword(password);
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setEmail(email);
				user.setRole(role);
				user.setStatus(status);
				
				System.out.println("User Id: " + idNumber + " Username: " + username + " Password: " + password + " First Name: " + firstName +
						" Last Name: " + lastName + " email: " + email + " role: " + role + " status: " + status);
				
				
			}

			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
