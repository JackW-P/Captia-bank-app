package com.fdmgroup.jdbcexercise;

import java.util.List;

public class UserDAORunner {

	public static void main(String[] args) {

		UsersDAO usersDao = new UsersDAO();

		List<User> listOfUsers = usersDao.listUsers();
		System.out.println(listOfUsers.size());

		for (User eachUser : listOfUsers) {
			System.out.println(eachUser.getFirstName() + eachUser.getLastName() + eachUser.getPassword());
		}

		User returnedUser = usersDao.getUser("dominicpau");
		String returnedPassword = returnedUser.getPassword();

		System.out.println(returnedPassword);

	}

}
