package com.fdmgroup.jdbcexercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO implements Users {

	User user;
	String username;

	// phase 2: start
	@Override
	public List<User> listUsers() {

		// key points:
		// 1. create table with all your columns.
		// 2. create couple of rows of data.
		// 3. check your User class to include all the data
		// 4. create a UsersDAORunner class and check that the listUsers method is
		// working.
		// 5.

		try {
			DriverManager.registerDriver(new org.h2.Driver());
			;
			Connection connection = DriverManager.getConnection("jdbc:h2:~/connectionName", "sa", "");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from TPUsers");

			List<User> users = new ArrayList<>();
			while (resultSet.next()) {
				int userId = resultSet.getInt("userId");
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				String firstname = resultSet.getString("firstName");
				String lastname = resultSet.getString("lastName");
				String email = resultSet.getString("email");
				String role = resultSet.getString("role");
				String status = resultSet.getString("status");

				User user = new User();
				user.setUserId(userId);
				user.setUsername(username);
				user.setPassword(password);
				user.setFirstName(firstname);
				user.setLastName(lastname);
				user.setEmail(email);
				user.setRole(role);
				user.setStatus(status);
				
				users.add(user);

			}
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listUsers();
	}

	@Override
	public void addUser(User user) {
		this.user = user;

	}

	@Override
	public User getUser(String username) {

		try {
			DriverManager.registerDriver(new org.h2.Driver());
			Connection connection = DriverManager.getConnection("jdbc:h2:~/connectionName", "sa", "");
			System.out.println("connected");

			PreparedStatement preparedStatement = connection
					.prepareStatement("select userID,userName,password,firstName,lastName"
							+ "email, role, status from TPUsers where username =?");
			preparedStatement.setString(1, username); // setting unknown value, as 1?

			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();

			User newUser = new User();

			newUser.setUserId(resultSet.getInt("userID"));
			newUser.setUsername(resultSet.getString("userName"));
			newUser.setPassword(resultSet.getString("password"));
			newUser.setFirstName(resultSet.getString("firstName"));
			newUser.setLastName(resultSet.getString("lastName"));
			newUser.setEmail(resultSet.getString("email"));
			newUser.setRole(resultSet.getString("role"));
			newUser.setStatus(resultSet.getString("status"));

			connection.close();

			return newUser;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void removeUser(String username) {

		try {
			DriverManager.registerDriver(new org.h2.Driver());
			Connection connection = DriverManager.getConnection("jdbc:h2:~/connectionName", "sa", "");
			System.out.println("connected");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	@Override
	public void updateUser(User user) {

	}

}
