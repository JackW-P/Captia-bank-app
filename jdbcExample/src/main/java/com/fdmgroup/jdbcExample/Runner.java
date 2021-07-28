package com.fdmgroup.jdbcExample;

import java.sql.*;

public class Runner {

	public static void main(String[] args) {

		/*
		 * H2 is a light database. Oracle is also a database, Connection keyword is to
		 * connect to that database. default username is sa, and default password is
		 * blank.
		 * 
		 * 
		 * statement object in order to send SQL to the database. send various
		 * statements to the statement object all these 4 lines did was drop a table,
		 * created a table, inserted and committed (to save changes permanently)/
		 * 
		 * set of data is collected (could be a whole table) and saved into variable
		 * resultSet. resultSet.next() means go from nothing to the first row of data.
		 * (first time) subsequent next goes to the second row and so on. While loop:
		 * while there is still data, print out the value.
		 * 
		 * sysout with resultSet.getInt() was done here to check that the connection
		 * worked.
		 * 
		 * 
		 */

		try {
			DriverManager.registerDriver(new org.h2.Driver());
			Connection connection = DriverManager.getConnection("jdbc:h2:~/connectionName", "sa", "");
			System.out.println("connected");
			Statement statement = connection.createStatement();
			statement.execute("drop table testtable if exists;");
			statement.execute("create table testtable(mynumber number(6), myname varchar2(20) );");
			statement.executeUpdate("insert into testtable(mynumber, myname) values (1,'Adrian');");
			statement.executeUpdate("insert into testtable(mynumber, myname) values (2,'John');");
			statement.executeUpdate("insert into testtable(mynumber, myname) values (3,'Rebecca');");
			statement.executeUpdate("commit;");

			ResultSet resultSet = statement.executeQuery("select mynumber,myname from testtable");
			while (resultSet.next()) {

				int number = resultSet.getInt("mynumber");
				String name = resultSet.getString("myname");

				System.out.print("" + number);
				System.out.println(",  " + name);
			}
			;

			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
